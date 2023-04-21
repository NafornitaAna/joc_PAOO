package dev.codenmore.tilegame.inventory;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory
{
    private Handler handler;
    private boolean active=false;
    private ArrayList<Item> inventoryItems;
    private ArrayList<Item> inventoryItems2;
    private int invX=64,invY=42,invWidth=637,invHeight=406;
    private int invListCenterX=invX+159,invListCenterY=invY+invHeight/2,
                invListCenterX2=invX+477,invListCenterY2=invY+invHeight/2;
    public Inventory(Handler handler)
    {
        this.handler=handler;
        inventoryItems=new ArrayList<Item>();
        inventoryItems2=new ArrayList<Item>();
    }
    public void tick()
    {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active=!active;
        if(!active)
            return;
    }
    public void render(Graphics g)
    {
        if(!active)
            return;
        g.drawImage(Assets.inventoryScreen,invX,invY,invWidth,invHeight,null);
        int len=inventoryItems.size();
        int len2=inventoryItems2.size();
        if(len==0||len2==0)
            return;
        Text.drawString(g,inventoryItems.get(0).getName(),invListCenterX,invListCenterY,true,Color.white,Assets.font28);
        Text.drawString(g,inventoryItems2.get(0).getName(),invListCenterX2,invListCenterY2,true,Color.white,Assets.font28);
    }

    //inventory
    public void addItem(Item item)
    {
        for(Item i:inventoryItems)
        {
            if(i.getId()==item.getId())
            {
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }
    public void addItem2(Item item)
    {
        for(Item i:inventoryItems2)
        {
            if(i.getId()==item.getId())
            {
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        inventoryItems2.add(item);
    }

    //getters setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
