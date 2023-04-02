package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
    private static final Integer width=48,height=48;
    public static BufferedImage soareci,lemn;
    public static BufferedImage[] pisicaDown,pisicaUp,pisicaLeft,pisicaRight,pisicaDown2,pisicaUp2,pisicaLeft2,pisicaRight2;
    public static void init()
    {
        SpriteSheet sheetPisici=new SpriteSheet(ImageLoader.loadImage("/textures/pisici.png"));
        SpriteSheet sheetLemn=new SpriteSheet(ImageLoader.loadImage("/textures/wood(1).jpg"));
        SpriteSheet sheetSoareci=new SpriteSheet(ImageLoader.loadImage("/textures/soareci.png"));
        pisicaDown=new BufferedImage[3];
        pisicaDown[0]=sheetPisici.crop(width*6,0,width,height);
        pisicaDown[1]=sheetPisici.crop(width*7,0,width,height);
        pisicaDown[2]=sheetPisici.crop(width*8,0,width,height);
        pisicaLeft=new BufferedImage[3];
        pisicaLeft[0]=sheetPisici.crop(width*6,height,width,height);
        pisicaLeft[1]=sheetPisici.crop(width*7,height,width,height);
        pisicaLeft[2]=sheetPisici.crop(width*8,height,width,height);
        pisicaRight=new BufferedImage[3];
        pisicaRight[0]=sheetPisici.crop(width*6,2*height,width,height);
        pisicaRight[1]=sheetPisici.crop(width*7,2*height,width,height);
        pisicaRight[2]=sheetPisici.crop(width*8,2*height,width,height);
        pisicaUp=new BufferedImage[3];
        pisicaUp[0]=sheetPisici.crop(width*6,3*height,width,height);
        pisicaUp[1]=sheetPisici.crop(width*7,3*height,width,height);
        pisicaUp[2]=sheetPisici.crop(width*8,3*height,width,height);
        pisicaDown2=new BufferedImage[3];
        pisicaDown2[0]=sheetPisici.crop(width*3,0,width,height);
        pisicaDown2[1]=sheetPisici.crop(width*4,0,width,height);
        pisicaDown2[2]=sheetPisici.crop(width*5,0,width,height);
        pisicaLeft2=new BufferedImage[3];
        pisicaLeft2[0]=sheetPisici.crop(width*3,height,width,height);
        pisicaLeft2[1]=sheetPisici.crop(width*4,height,width,height);
        pisicaLeft2[2]=sheetPisici.crop(width*5,height,width,height);
        pisicaRight2=new BufferedImage[3];
        pisicaRight2[0]=sheetPisici.crop(width*3,2*height,width,height);
        pisicaRight2[1]=sheetPisici.crop(width*4,2*height,width,height);
        pisicaRight2[2]=sheetPisici.crop(width*5,2*height,width,height);
        pisicaUp2=new BufferedImage[3];
        pisicaUp2[0]=sheetPisici.crop(width*3,3*height,width,height);
        pisicaUp2[1]=sheetPisici.crop(width*4,3*height,width,height);
        pisicaUp2[2]=sheetPisici.crop(width*5,3*height,width,height);
        lemn=sheetLemn.crop(0,0,1531,980);
    }
}