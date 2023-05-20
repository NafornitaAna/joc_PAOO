package dev.codenmore.tilegame.items;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item
{
    //handler
    public static Item[] items=new Item[256];
    public static Item xpItem=new Item(Assets.xp,"xp",0);

    //class
    public static final int ITEMWIDTH=32,ITEMHEIGHT=32;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected Rectangle bounds;
    protected final int id;
    protected int x,y,count;
    protected boolean pickedUp=false;
    public Item(BufferedImage texture, String name, int id)
    {
        this.texture=texture;
        this.name=name;
        this.id = id;
        count=0;

        bounds=new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);

        items[id]=this;
    }

    public Item(Item item)
    {
        this.texture = item.getTexture();
        this.name = item.getName();
        this.id = item.getId();
        this.count = 1;
        this.bounds=new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
        items[id]=this;
    }
    public void tick()
    {
        if(handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds))
        {
            pickedUp=true;
            handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
        if(handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getCollisionBounds(0f,0f).intersects(bounds))
        {
            pickedUp=true;
            handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getInventory().addItem2(this);
        }
    }
    public void render(Graphics g)
    {
        if(handler==null)
            return;
        render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
    }
    public void render(Graphics g, int x,int y)
    {
        g.drawImage(texture,x+50,y,ITEMWIDTH,ITEMHEIGHT,null);
    }

    public Item createNew(int count)
    {
        Item i=new Item(texture,name,id);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }
    public Item createNew(int x,int y)
    {
        Item i=new Item(texture,name,id);
        i.setPosition(x,y);
        return i;
    }
    public void setPosition(int x,int y)
    {
        this.x=x;
        this.y=y;
        bounds.x=x+50;
        bounds.y=y;
    }

    //getters setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}













