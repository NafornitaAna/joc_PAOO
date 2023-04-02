package dev.codenmore.tilegame.entities.creatures;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature
{
    //animations
    private Animation animDown,animUp,animLeft,animRight;

    public Player(Handler handler, Float x, Float y)
    {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=16;
        bounds.y=32;
        bounds.height=32;
        bounds.width=32;

        //animations
        animDown=new Animation(200,Assets.pisicaDown);
        animUp=new Animation(200,Assets.pisicaUp);
        animLeft=new Animation(200,Assets.pisicaLeft);
        animRight=new Animation(200,Assets.pisicaRight);
    }

    @Override
    public void tick()
    {
        //animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput()
    {
        xMove=0;
        yMove=0;

        if(handler.getKeyManager().up)
            yMove=-speed;
        if(handler.getKeyManager().down)
            yMove=+speed;
        if(handler.getKeyManager().left)
            xMove=-speed;
        if(handler.getKeyManager().right)
            xMove=+speed;
    }
    @Override
    public void render(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), Math.round(x-handler.getGameCamera().getxOffset())
                ,Math.round(y-handler.getGameCamera().getyOffset()),width,height,null);
        //g.setColor(Color.red);
        //g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),
        //           (int)(y+bounds.y-handler.getGameCamera().getyOffset()),
        //        bounds.width, bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove<0)
        {
            return animLeft.getCurrentFrame();
        }
        else if(xMove>0)
        {
            return animRight.getCurrentFrame();
        }
        else if(yMove<0)
        {
            return animUp.getCurrentFrame();
        }
        else
        {
            return animDown.getCurrentFrame();
        }
    }
}
