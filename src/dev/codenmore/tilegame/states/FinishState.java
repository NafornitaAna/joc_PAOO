package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.UIManager;

import java.awt.*;

public class FinishState extends State{

    private UIManager uiManager;

    public FinishState(Handler handler) {
        super(handler);
        this.uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
    }

    @Override
    public void tick() {
        uiManager.tick();
        verifEscapeKey();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
        drawBackground(g);
        drawCongrats(g,250,100);
        drawScor(g,100,350);
        drawCastigator(g,250,150);
    }

    public void drawCastigator(Graphics g,int x,int y)
    {
        g.setColor(Color.magenta);
        g.setFont(Assets.font28);
        int scorP1=handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getInventory().getCount();
        int scorP2=handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getInventory().getCount2();
        if(scorP1>scorP2)
            g.drawString("Winner is Player1",x, y);
        else g.drawString("Winner is Player2",x, y);
    }

    public void drawBackground(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
    }

    public void drawCongrats(Graphics g,int x, int y){
        g.setColor(Color.magenta);
        g.setFont(Assets.font28);
        String mesaj = "Congratulations!";
        g.drawString(mesaj,x, y);
    }

    public void drawScor(Graphics g,int x, int y){
        g.setColor(Color.pink);
        g.setFont(Assets.font28);
        g.drawString("Score player 1: "+handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getInventory().getCount(),x,y);
        g.drawString("Score player 2: "+handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getInventory().getCount2(),x+300,y);
    }

    public UIManager getUiManager() {
        return uiManager;
    }
    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    @Override
    public void loadWorld() {

    }
}
