package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage sheet;
    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet=sheet;
    }
    public BufferedImage crop(Integer x,Integer y,Integer width,Integer height)
    {
        return sheet.getSubimage(x,y,width,height);
    }
}
