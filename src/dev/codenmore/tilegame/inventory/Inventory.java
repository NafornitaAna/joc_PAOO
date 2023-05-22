package dev.codenmore.tilegame.inventory;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.Text;
import dev.codenmore.tilegame.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Inventory
{
    private Handler handler;
    private boolean active=false;
    private Item inventoryItems = null;
    private Item inventoryItems2 = null;
    private final int invX=64,invY=42,invWidth=637,invHeight=406;
    private int invListCenterX=invX+7,invListCenterY=invY+7,
                invListCenterX2=invX+630,invListCenterY2=invY+7;
    public Inventory(Handler handler)
    {
        this.handler=handler;
    }
    public void tick()
    {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active=!active;
    }
    public void render(Graphics g)
    {
        if(!active)
            return;

        if(inventoryItems != null)
        {
            Text.drawString(g,inventoryItems.getName()+" "+inventoryItems.getCount(),invListCenterX,invListCenterY,true,Color.WHITE,Assets.font28);
        }
        if(inventoryItems2 != null)
        {
            Text.drawString(g,inventoryItems2.getName()+" "+inventoryItems2.getCount(),invListCenterX2,invListCenterY2,true,Color.WHITE,Assets.font28);
        }
    }

    //inventory
    public void addItem(Item item)
    {
        if(this.inventoryItems == null)
        {
            inventoryItems = new Item(item);
        }
        else
        {
            inventoryItems.setCount(this.inventoryItems.getCount()+1);
        }
    }
    public void addItem2(Item item)
    {
        if(this.inventoryItems2 == null)
        {
            inventoryItems2 = new Item(item);
        }
        else
        {
            inventoryItems2.setCount(this.inventoryItems2.getCount()+1);
        }
    }

    //getters setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Item getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Item inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public Item getInventoryItems2() {
        return inventoryItems2;
    }

    public void setInventoryItems2(Item inventoryItems2) {
        this.inventoryItems2 = inventoryItems2;
    }

    public int getCount(){
        if(inventoryItems == null)
        {
            return 0;
        }
        return inventoryItems.getCount();
    }

    public int getCount2(){
        if(inventoryItems2 == null)
        {
            return 0;
        }
        return inventoryItems2.getCount();
    }

}
