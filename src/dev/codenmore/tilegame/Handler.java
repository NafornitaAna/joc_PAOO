package dev.codenmore.tilegame;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;

public class Handler
{
    private Game game;
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
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
}
