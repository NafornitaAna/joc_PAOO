package dev.codenmore.tilegame;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.worlds.Worlds;

public class Handler
{
    private Game game;
    private Worlds world;

    public Handler(Game game)
    {
        this.game=game;
    }
    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    public MouseManager getMouseManager(){return game.getMouseManager();}
    public Integer getWidth()
    {
        return game.getWidth();
    }
    public Integer getHeight()
    {
        return game.getHeight();
    }
    public Worlds getWorld() {
        return world;
    }

    public void setWorld(Worlds world) {
        this.world = world;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
