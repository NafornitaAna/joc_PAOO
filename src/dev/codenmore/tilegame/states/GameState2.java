package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.BrakebleObject;
import dev.codenmore.tilegame.entities.statics.Ceasca;
import dev.codenmore.tilegame.worlds.Worlds;
import dev.codenmore.tilegame.worlds.World2;

import java.awt.*;

public class GameState2 extends State
{
    private World2 world;
    public GameState2(Handler handler)
    {
        super(handler);
        world=new World2(handler,"res/worlds/world2.txt");
    }

    public void loadWorld(){
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
            State.setState(handler.getGame().gameState3);
            handler.getGame().gameState3.loadWorld();
        }
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
    }
}










