package dev.codenmore.tilegame.states;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.Worlds;

import java.awt.*;

public abstract class State
{
    protected Worlds world;
    private static State currentState=null;
    public static void setState(State state)
    {
        currentState=state;
    }
    public static State getState()
    {
        return currentState;
    }

    //class
    protected Handler handler;
    public State(Handler handler)
    {
        this.handler=handler;
    }
    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract void loadWorld();

    public Worlds getWorld() {
        return world;
    }

    public void setWorld(Worlds world) {
        this.world = world;
    }

    public void verifEscapeKey()
    {
        if(handler.getKeyManager().esc){
            handler.getGame().getDatabase().insert(handler);
            State.setState(new MenuState(handler));
            handler.getKeyManager().esc = false;
        }
    }
}
