package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Animation
{
    private Integer speed,index;
    private Long lastTime,timer;
    private BufferedImage[] frames;

    public Animation(Integer speed,BufferedImage[] frames)
    {
        this.frames=frames;
        this.speed=speed;
        index=0;
        timer=0l;
        lastTime=System.currentTimeMillis();
    }
    public void tick()
    {
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if(timer>speed)
        {
            index++;
            timer=0l;
            if(index>=frames.length)
                index=0;
        }
    }
    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }
}









