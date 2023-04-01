package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final Integer width=48,height=48;
    public static BufferedImage pisici,soareci,lemn;
    public static void init()
    {
        SpriteSheet sheetPisici=new SpriteSheet(ImageLoader.loadImage("/textures/pisici.png"));
        SpriteSheet sheetLemn=new SpriteSheet(ImageLoader.loadImage("/textures/lemn.jpg"));
        SpriteSheet sheetSoareci=new SpriteSheet(ImageLoader.loadImage("/textures/soareci.png"));
        pisici=sheetPisici.crop(0,0,width,height);
        lemn=sheetLemn.crop(0,0,1531,980);
    }
}
