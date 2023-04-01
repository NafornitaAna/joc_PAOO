package dev.codenmore.tilegame.gfx;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public class GameCamera
{
    private Game game;
    private Float xOffset,yOffset;

    public GameCamera(Game game,Float xOffset, Float yOffset)
    {
        this.game=game;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }
    public void centerOnEntity(Entity e)
    {
        xOffset=e.getX()-game.getWidth()/2+e.getWidth()/2;
        yOffset=e.getY()-game.getHeight()/2+e.getHeight()/2;
    }
    public void move(Float xAmt,Float yAmt)
    {
        xOffset+=xAmt;
        yOffset+=yAmt;
    }
    public Float getyOffset() {
        return yOffset;
    }

    public void setyOffset(Float yOffset) {
        this.yOffset = yOffset;
    }

    public Float getxOffset() {
        return xOffset;
    }

    public void setxOffset(Float xOffset) {
        this.xOffset = xOffset;
    }

}
