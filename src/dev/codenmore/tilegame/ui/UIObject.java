package dev.codenmore.tilegame.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject
{
    protected float x,y;
    protected Integer width,height;
    protected Rectangle bounds;
    protected boolean hovering=false;
    public UIObject(float x,float y,Integer width,Integer height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle((int)x,(int)y,width,height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void onClick();
    public void onMouseMove(MouseEvent e)
    {
        if(bounds.contains(e.getX(),e.getY()))
            hovering=true;
        else
            hovering=false;
    }
    public void onMouseRelease(MouseEvent e)
    {
        if(hovering)
            onClick();
    }

    //getters setters
    public boolean isHovering() {
        return hovering;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
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

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
