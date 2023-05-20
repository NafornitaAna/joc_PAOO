package dev.codenmore.tilegame;
import dev.codenmore.tilegame.display.Display;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.*;
import dev.codenmore.tilegame.utils.Database;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLException;

public class Game implements Runnable
{
    private Display display;
    private Integer width,height;
    public String title;
    private Boolean running=false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    //states
    public State gameState,gameState2,gameState3;
    public State menuState;

    //db
    Database database= null;

    //input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //handler
    private Handler handler;
    private static Game instance = null;

    public static Game NewGame(String title,Integer width,Integer height)
    {
        if(instance == null)
            instance = new Game(title, width, height);
        return instance;
    }

    private Game(String title,Integer width,Integer height)
    {
        this.height=height;
        this.width=width;
        this.title=title;
        keyManager=new KeyManager();
        mouseManager=new MouseManager();
    }

    private void init()
    {
        try
        {
            database=new Database("database.db");
            database.createNewTable();
        }
        catch (Exception e)
        {
            System.out.println("nu s-a putut initializa database");
            return;
        }
        display=new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        handler=new Handler(this);
        gameCamera=new GameCamera(handler,0f,0f);
        gameState=new GameState(handler);
        gameState.loadWorld();
        gameState2=new GameState2(handler);
        gameState3=new GameState3(handler);
        menuState=new MenuState(handler);
        State.setState(menuState);
    }
    private void tick()
    {
        keyManager.tick();
        if(State.getState()!=null)
            State.getState().tick();
        verifEscapeKey();
    }
    private void rander()
    {
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g=bs.getDrawGraphics();
        //clear screen
        g.clearRect(0,0,width,height);

        //draw here

        if(State.getState()!=null)
            State.getState().render(g);

        //end draw
        bs.show();
        g.dispose();
    }
    public void run()
    {
        init();

        Integer fps=60;
        Double timePerTick=1000000000.0/fps;
        Double delta=0.0;
        Long now;
        Long lastTime=System.nanoTime();
        Long timer=0L;
        Integer ticks=0;

        while(running)
        {
            now=System.nanoTime();
            delta+=(now-lastTime)/timePerTick;
            timer+=now-lastTime;
            lastTime=now;

            if(delta>=1)
            {
                tick();
                rander();
                ticks++;
                delta--;
            }

            if(timer>=1000000000)
            {
                System.out.println("ticks and frames: "+ticks);
                ticks=0;
                timer=0L;
            }
        }
        stop();
    }

    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    public MouseManager getMouseManager(){return mouseManager;}
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
    public Integer getHeight() {
        return height;
    }
    public Integer getWidth() {
        return width;
    }
    public synchronized void start()
    {
        if(running)
            return;
        running=true;
        thread=new Thread(this);
        thread.start();
    }
    public synchronized void stop()
    {
        if(!running)
            return;
        running=false;
        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void verifEscapeKey()
    {
        if(handler.getKeyManager().esc){
            State.setState(new MenuState(handler));
        }
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
