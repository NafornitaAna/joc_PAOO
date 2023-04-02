package dev.codenmore.tilegame.entities.creatures;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player2 extends Creature
{
    //animations
    private Animation animDown,animUp,animLeft,animRight;

    public Player2(Handler handler, Float x, Float y)
    {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=16;
        bounds.y=32;
        bounds.height=32;
        bounds.width=32;

        //animations
        animDown=new Animation(200,Assets.pisicaDown2);
        animUp=new Animation(200,Assets.pisicaUp2);
        animLeft=new Animation(200,Assets.pisicaLeft2);
        animRight=new Animation(200,Assets.pisicaRight2);
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

        if(handler.getKeyManager().up2)
            yMove=-speed;
        if(handler.getKeyManager().down2)
            yMove=+speed;
        if(handler.getKeyManager().left2)
            xMove=-speed;
        if(handler.getKeyManager().right2)
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
