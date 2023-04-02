package dev.codenmore.tilegame.entities;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

import java.awt.*;

public abstract class Entity
{
    protected Handler handler;
    protected Float x,y;
    protected Integer width,height;
    protected Rectangle bounds;
    public Entity(Handler handler,Float x, Float y, Integer width, Integer height)
    {
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
        bounds=new Rectangle(0,0,width,height);
    }
    public abstract void tick();
    public abstract void render(Graphics g);

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

}
