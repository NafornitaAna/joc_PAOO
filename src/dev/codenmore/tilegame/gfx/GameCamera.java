package dev.codenmore.tilegame.gfx;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

public class GameCamera
{
    private Handler handler;
    private Float xOffset,yOffset;

    public GameCamera(Handler handler,Float xOffset, Float yOffset)
    {
        this.handler=handler;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }
    public void checkBlankSpace()
    {
        if(xOffset<0)
            xOffset=0f;
        else if(xOffset>handler.getGame().gameState.getWorld().getWidth()* Tile.TILEWIDTH-handler.getWidth())
            xOffset=(float)(handler.getGame().gameState.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth());
        if(yOffset<0)
            yOffset=0f;
        else if(yOffset>handler.getGame().gameState.getWorld().getHeight()* Tile.TILEHEIGHT-handler.getHeight())
            yOffset=(float)(handler.getGame().gameState.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight());
    }
    public void centerOnEntity(Entity e)
    {
        xOffset=e.getX()-handler.getWidth()/2+e.getWidth()/2;
        yOffset=e.getY()-handler.getHeight()/2+e.getHeight()/2;
        checkBlankSpace();
    }
    public void move(Float xAmt,Float yAmt)
    {
        xOffset+=xAmt;
        yOffset+=yAmt;
        checkBlankSpace();
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
