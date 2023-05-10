package dev.codenmore.tilegame.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets
{
    private static final Integer width=48,height=48;
    public static BufferedImage lemn,margine,
            ceasca,briosa1,briosa2,cartiJoc,pahar,lingura,tort,xp;
    public static BufferedImage[] pisicaDown,pisicaUp,pisicaLeft,pisicaRight,pisicaDown2,pisicaUp2,pisicaLeft2,pisicaRight2,
            soareceDown,soareceUp,soareceLeft,soareceRight;
    public static BufferedImage[] btn_start;
    public static BufferedImage inventoryScreen;
    public static Font font28;
    public static void init()
    {
        font28=FontLoader.loadFont("res/fonts/font.ttf",28);

        SpriteSheet sheetPisici=new SpriteSheet(ImageLoader.loadImage("/textures/pisici.png"));
        SpriteSheet sheetLemn=new SpriteSheet(ImageLoader.loadImage("/textures/wood(1).jpg"));
        SpriteSheet sheetSoareci=new SpriteSheet(ImageLoader.loadImage("/textures/soareci.png"));
        SpriteSheet sheetBtn=new SpriteSheet(ImageLoader.loadImage("/textures/btn.png"));
        SpriteSheet sheetBtnH=new SpriteSheet(ImageLoader.loadImage("/textures/btnH.png"));
        SpriteSheet sheetCeasca=new SpriteSheet(ImageLoader.loadImage("/textures/ceasca.png"));
        SpriteSheet sheetBriosa1=new SpriteSheet(ImageLoader.loadImage("/textures/briosa.png"));
        SpriteSheet sheetBriosa2=new SpriteSheet(ImageLoader.loadImage("/textures/briosa2.png"));
        SpriteSheet sheetCartiDeJoc=new SpriteSheet(ImageLoader.loadImage("/textures/playing-cards.png"));
        SpriteSheet sheetPahar=new SpriteSheet(ImageLoader.loadImage("/textures/pahar.png"));
        SpriteSheet sheetLingura=new SpriteSheet(ImageLoader.loadImage("/textures/lingura.png"));
        SpriteSheet sheetTort=new SpriteSheet(ImageLoader.loadImage("/textures/tort.png"));
        SpriteSheet sheetMargine=new SpriteSheet(ImageLoader.loadImage("/textures/lemn.jpg"));
        SpriteSheet sheetXp=new SpriteSheet(ImageLoader.loadImage("/textures/xp.png"));

        btn_start=new BufferedImage[2];
        btn_start[0]=sheetBtn.crop(0,0,264,97);
        btn_start[1]=sheetBtnH.crop(0,0,264,97);

        xp=sheetXp.crop(0,0,190,191);

        inventoryScreen=ImageLoader.loadImage("/textures/black.jpg");

        soareceDown=new BufferedImage[3];
        soareceDown[0]=sheetSoareci.crop(width*6,height*4,width,height);
        soareceDown[1]=sheetSoareci.crop(width*7,height*4,width,height);
        soareceDown[2]=sheetSoareci.crop(width*8,height*4,width,height);
        soareceLeft=new BufferedImage[3];
        soareceLeft[0]=sheetSoareci.crop(width*6,height*5,width,height);
        soareceLeft[1]=sheetSoareci.crop(width*7,height*5,width,height);
        soareceLeft[2]=sheetSoareci.crop(width*8,height*5,width,height);
        soareceRight=new BufferedImage[3];
        soareceRight[0]=sheetSoareci.crop(width*6,height*6,width,height);
        soareceRight[1]=sheetSoareci.crop(width*7,height*6,width,height);
        soareceRight[2]=sheetSoareci.crop(width*8,height*6,width,height);
        soareceUp=new BufferedImage[3];
        soareceUp[0]=sheetSoareci.crop(width*6,height*7,width,height);
        soareceUp[1]=sheetSoareci.crop(width*7,height*7,width,height);
        soareceUp[2]=sheetSoareci.crop(width*8,height*7,width,height);

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

        tort = sheetTort.crop(0,0,66,66);
        ceasca = sheetCeasca.crop(0,0,64,64);
        briosa1 = sheetBriosa1.crop(0,0,500,500);
        briosa2 = sheetBriosa2.crop(0,0,221,304);
        cartiJoc = sheetCartiDeJoc.crop(0,0,270,270);
        pahar = sheetPahar.crop(0,0,44,65);
        lingura= sheetLingura.crop(0,0,331,670);
        margine=sheetMargine.crop(0,0,1531,980);
    }
}
