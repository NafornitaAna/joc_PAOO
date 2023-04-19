package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.Ceasca;
import dev.codenmore.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State
{
    private World world;
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
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
    }
}










