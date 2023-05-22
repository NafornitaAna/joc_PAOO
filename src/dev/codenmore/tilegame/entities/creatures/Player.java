package dev.codenmore.tilegame.entities.creatures;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature
{
    //animations
    private final Animation animDown,animUp,animLeft,animRight;

    //attack timer
    private long lastAttackTimer,attackCooldown=500,attackTimer=attackCooldown;

    //inventory
    private Inventory inventory;
    public Player(Handler handler, Float x, Float y)
    {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=38;
        bounds.y=64;
        bounds.height=48;
        bounds.width=48;

        //animations
        animDown=new Animation(200,Assets.pisicaDown);
        animUp=new Animation(200,Assets.pisicaUp);
        animLeft=new Animation(200,Assets.pisicaLeft);
        animRight=new Animation(200,Assets.pisicaRight);

        inventory=new Inventory(handler);
    }

    public void die()
    {
        this.x=0f;
        this.y=0f;
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
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //attack
        checkAttacks();
        //inventory
        inventory.tick();
    }

    private void checkAttacks() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 100;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().attack1 && handler.getKeyManager().up)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y-arSize;
        }
        else if(handler.getKeyManager().attack1 && handler.getKeyManager().down)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y- cb.height;
        }
        else if(handler.getKeyManager().attack1 && handler.getKeyManager().left)
        {
            ar.x=cb.x-arSize;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if(handler.getKeyManager().attack1 && handler.getKeyManager().right)
        {
            ar.x=cb.x+ cb.width;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else
        {
            return;
        }
        attackTimer=0;

        for(Entity e: handler.getGame().gameState.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar))
            {
                e.hurt(1);
                return;
            }
        }
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
    }

    public void postRender(Graphics g)
    {
        inventory.render(g);
    }
    public Inventory getInventory() {
        return inventory;
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
