package dev.codenmore.tilegame.entities;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.statics.BrakebleObject;

import java.awt.*;

public abstract class Entity
{
    public static final Integer DEFAULT_HEALTH=3;
    protected Handler handler;
    protected Float x,y;
    protected Integer width,height;
    protected Integer health;
    protected boolean active=true;
    protected Rectangle bounds;
    public Entity(Handler handler,Float x, Float y, Integer width, Integer height)
    {
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        health=DEFAULT_HEALTH;
        bounds=new Rectangle(0,0,width,height);
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void die();
    public void hurt(int amt)
    {
        health-=amt;
        if(health<=0)
        {
            if(this instanceof BrakebleObject)
                active=false;
            die();
        }
    }
    public Rectangle getCollisionBounds(float xOffset,float yOffset)
    {
        return new Rectangle((int)(x+bounds.x + xOffset),(int)(y+bounds.y +yOffset),bounds.width,bounds.height);
    }
    public boolean checkEntityCollisions(float xOffset,float yOffset)
    {
        for(Entity e: handler.getGame().gameState.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
