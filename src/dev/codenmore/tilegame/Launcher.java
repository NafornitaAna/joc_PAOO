package dev.codenmore.tilegame;

public class Launcher
{
    public static void main(String[] args)
    {
        Game game = Game.NewGame("Cat o'clock",765,490);
        game.start();
    }
}
