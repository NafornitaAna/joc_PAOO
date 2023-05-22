package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    private boolean[] keys,justPressed,cantPress;
    public Boolean up,down,left,right,up2,down2,left2,right2,esc;
    public boolean attack1,attack2;
    public KeyManager()
    {
        keys=new boolean[256];
        justPressed=new boolean[keys.length];
        cantPress=new boolean[keys.length];
    }
    public void tick()
    {
        for(int i=0;i< keys.length;i++)
        {
            if(cantPress[i]&&!keys[i])
            {
                cantPress[i]=false;
            }
            else if(justPressed[i])
            {
                cantPress[i]=true;
                justPressed[i]=false;
            }
            if(!cantPress[i]&&keys[i])
            {
                justPressed[i]=true;
            }
        }
        attack1=keys[KeyEvent.VK_F];
        attack2=keys[KeyEvent.VK_CONTROL];
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
        up2=keys[KeyEvent.VK_UP];
        down2=keys[KeyEvent.VK_DOWN];
        left2=keys[KeyEvent.VK_LEFT];
        right2=keys[KeyEvent.VK_RIGHT];
        esc = keys[KeyEvent.VK_ESCAPE];
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()<0||e.getKeyCode()>= keys.length)
            return;
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode()<0||e.getKeyCode()>= keys.length)
            return;
        keys[e.getKeyCode()]=false;
    }
    public boolean keyJustPressed(int keyCode)
    {
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }
}
