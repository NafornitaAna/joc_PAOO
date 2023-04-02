package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State
{
    private Player player;
    private Player2 player2;
    private World world;
    public GameState(Handler handler)
    {
        super(handler);
        world=new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);
        player=new Player(handler,100f,100f);
        player2=new Player2(handler,200f,200f);
    }
    @Override
    public void tick()
    {
        world.tick();
        player.tick();
        player2.tick();
    }

    @Override
    public void render(Graphics g)
    {
        world.render(g);
        player.render(g);
        player2.render(g);
    }
}










