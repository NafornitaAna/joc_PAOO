package dev.codenmore.tilegame.entities;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Creature;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NPC_Soricel extends Creature
{
    private int xMove=1,yMove=1;
    private final Animation animDown,animUp,animLeft,animRight;

    public NPC_Soricel(Handler handler, Float x, Float y) {
        super(handler, x, y, 45, 45);
        bounds.x=10;
        bounds.y=10;
        bounds.width=30;
        bounds.height=30;

        //animations
        animDown=new Animation(200,Assets.soareceDown);
        animUp=new Animation(200,Assets.soareceUp);
        animLeft=new Animation(200,Assets.soareceLeft);
        animRight=new Animation(200,Assets.soareceRight);
    }

    @Override
    public void tick()
    {
        //animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //movement
        move();
        x += xMove;
        y += yMove;
        if(x<0)
            xMove = xMove *-1;
        if(x+2*height>765)
            xMove = xMove *-1;
        if(y<0)
            yMove=yMove*-1;
        if(y+2*width>490)
            yMove=yMove*-1;


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), Math.round(x-handler.getGameCamera().getxOffset())
                ,Math.round(y-handler.getGameCamera().getyOffset()),90,90,null);
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.xpItem.createNew(Math.round(x),Math.round(y)));
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
