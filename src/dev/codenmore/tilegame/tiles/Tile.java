package dev.codenmore.tilegame.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{
    //static stuff
    public static Tile[]tiles=new Tile[256];
    public static Tile woodTile=new WoodTile(0);
    public static Tile margine=new Margine(1);

    //class
    public static final int TILEWIDTH=765,TILEHEIGHT=490;
    protected BufferedImage texture;
    protected final Integer id;
    public Tile(BufferedImage texture,Integer id)
    {
        this.texture=texture;
        this.id=id;

        tiles[id]=this;
    }
    public boolean isSolid()
    {
        return false;
    }
    public void tick()
    {

    }
    public void render(Graphics g,Integer x,Integer y)
    {
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }
    public Integer getId()
    {
        return id;
    }
}
