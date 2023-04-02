package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean[] keys;
    public Boolean up,down,left,right,up2,down2,left2,right2;
    public KeyManager()
    {
        keys=new boolean[256];
    }
    public void tick()
    {
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
        up2=keys[KeyEvent.VK_UP];
        down2=keys[KeyEvent.VK_DOWN];
        left2=keys[KeyEvent.VK_LEFT];
        right2=keys[KeyEvent.VK_RIGHT];
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()]=true;
        System.out.println("pressed!!!");
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()]=false;
    }
}
