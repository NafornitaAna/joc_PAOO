package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.BrakebleObject;
import dev.codenmore.tilegame.entities.statics.Ceasca;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;
import dev.codenmore.tilegame.worlds.World;
import dev.codenmore.tilegame.worlds.World2;
import dev.codenmore.tilegame.worlds.World3;
import dev.codenmore.tilegame.worlds.Worlds;

import java.awt.*;

public class GameState extends State
{

    public GameState(Handler handler)
    {
        super(handler);
        world=new World(handler,"res/worlds/world1.txt");
    }
    @Override
    public void tick()
    {
        world.tick();

        if(!this.enitiesExists())
        {
            int playerVech1 = world.getEntityManager().getPlayer().getInventory().getCount();
            int playerVech2 = world.getEntityManager().getPlayer2().getInventory().getCount2();

            if(this.world instanceof World)
            {
                this.world = new World2(handler, "res/worlds/world2.txt");
            }
            else if(this.world instanceof World2)
            {
                this.world = new World3(handler, "res/worlds/world3.txt");
            }
            else if (this.world instanceof World3)
            {
                System.out.println("GATA");
            }

            if(playerVech1!=0)
            {
                this.handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getInventory().setInventoryItems(new Item(Assets.xp,"xp",0));
                this.handler.getGame().gameState.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems().setCount(playerVech1);
            }
            if(playerVech2!=0)
            {
                this.handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getInventory().setInventoryItems2(new Item(Assets.xp,"xp",0));
                this.handler.getGame().gameState.getWorld().getEntityManager().getPlayer2().getInventory().getInventoryItems2().setCount(playerVech2);
            }
        }
    }

    public boolean enitiesExists() {
        var entities = world.getEntityManager().getEntities();
        for(int i=0;i<entities.size();i++)
        {
            if(entities.get(i) instanceof BrakebleObject){
                return true;
            }
        }
        return false;
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
    }

    @Override
    public void loadWorld() {
        handler.getGame().gameState.setWorld(world);
    }
}










