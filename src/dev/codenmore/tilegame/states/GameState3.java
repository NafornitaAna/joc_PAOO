package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.BrakebleObject;
import dev.codenmore.tilegame.entities.statics.Ceasca;
import dev.codenmore.tilegame.worlds.World3;
import dev.codenmore.tilegame.worlds.Worlds;
import dev.codenmore.tilegame.worlds.World2;

import java.awt.*;

public class GameState3 extends State
{
    private World3 world;
    public GameState3(Handler handler)
    {
        super(handler);
        world=new World3(handler,"res/worlds/world3.txt");
    }

    public void loadWorld(){
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










