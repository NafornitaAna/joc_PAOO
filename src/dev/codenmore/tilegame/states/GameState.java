package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.BrakebleObject;
import dev.codenmore.tilegame.entities.statics.Ceasca;
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
        handler.setWorld(world);
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
//            handler.setWorld(new World2(handler,"res/worlds/world2.txt"));
            State.setState(handler.getGame().gameState2);
        }

    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
    }
}










