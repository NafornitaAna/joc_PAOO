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
import dev.codenmore.tilegame.worlds.Worlds;

import java.awt.*;

public class GameState extends State
{
    private Worlds world;

    public GameState(Handler handler)
    {
        super(handler);
        world=new World(handler,"res/worlds/world1.txt");
    }
    @Override
    public void tick()
    {
        world.tick();

        var entities = world.getEntityManager().getEntities();
        boolean ok = false;
        for(int i=0;i<entities.size();i++)
        {
            if(entities.get(i) instanceof BrakebleObject){
                ok = true;
            }
        }
        if(!ok)
        {
            int playerVech1 = world.getEntityManager().getPlayer().getInventory().getCount();
            int playerVech2 = world.getEntityManager().getPlayer2().getInventory().getCount2();

            State.setState(handler.getGame().gameState2);
            handler.getGame().gameState2.loadWorld();

            if(playerVech1!=0)
            {
                this.handler.getWorld().getEntityManager().getPlayer().getInventory().setInventoryItems(new Item(Assets.xp,"xp",0));
                this.handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems().setCount(playerVech1);
            }
            if(playerVech2!=0)
            {
                this.handler.getWorld().getEntityManager().getPlayer2().getInventory().setInventoryItems2(new Item(Assets.xp,"xp",0));
                this.handler.getWorld().getEntityManager().getPlayer2().getInventory().getInventoryItems2().setCount(playerVech2);
            }
        }

    }


    @Override
    public void render(Graphics g)
    {
        world.render(g);
    }

    @Override
    public void loadWorld() {
        handler.setWorld(world);
    }
}










