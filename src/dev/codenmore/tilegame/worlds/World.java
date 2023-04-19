package dev.codenmore.tilegame.worlds;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.*;
import dev.codenmore.tilegame.items.ItemManager;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;
import java.awt.*;

public class World
{
    private Handler handler;
    private Integer width,height;
    private int spawnX,spawnY;
    private Integer[][] tiles;

    //entities
    private EntityManager entityManager;

    //item
    private ItemManager itemManager;
    public World(Handler handler, String path)
    {
        this.handler =handler;
        entityManager=new EntityManager(handler,new Player(handler,100f,100f),
                new Player2(handler,100f,100f));
        itemManager=new ItemManager(handler);
        entityManager.addEntity(new Ceasca(handler,400,300));
        entityManager.addEntity(new Briosa1(handler,250,250));
        entityManager.addEntity(new CartiDeJoc(handler,400,10));
        entityManager.addEntity(new Pahar(handler,20,400));


        loadWorld(path);

        entityManager.getPlayer().setX((float)spawnX);
        entityManager.getPlayer().setY((float)spawnY);
        entityManager.getPlayer2().setX((float)spawnX+100);
        entityManager.getPlayer2().setY((float)spawnY);
    }
    public void tick()
    {
        itemManager.tick();
        entityManager.tick();
    }
    public void render(Graphics g)
    {
        Integer xStart=Math.max(0,(int)(handler.getGameCamera().getxOffset()/Tile.TILEWIDTH)),
                xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+ handler.getWidth())/Tile.TILEWIDTH+1),
                yStart=Math.max(0,(int)(handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT)),
                yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight())/Tile.TILEHEIGHT+1);

        for(Integer y=yStart;y<yEnd;y++)
            for(Integer x=xStart;x<xEnd;x++)
            {
                getTile(x,y).render(g,(int)(x*Tile.TILEHEIGHT- handler.getGameCamera().getxOffset()),
                        (int)(y*Tile.TILEHEIGHT- handler.getGameCamera().getyOffset()));
            }
        //items
        itemManager.render(g);
        //entities
        entityManager.render(g);
    }
    public Tile getTile(Integer x,Integer y)
    {
        if(x<0||y<0||x>=width||y>=height)
            return Tile.woodTile;
        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)
            return Tile.woodTile;
        return t;
    }
    private void loadWorld(String path)
    {
        String file= Utils.loadFileAsString(path);
        String [] tokens=file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        spawnX=Utils.parseInt(tokens[2]);
        spawnY=Utils.parseInt(tokens[3]);

        tiles=new Integer[width][height];
        for(Integer y=0;y<height;y++)
            for(Integer x=0;x<width;x++)
                tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
    }

    //getters setters
    public Integer getWidth()
    {
        return width;
    }
    public Integer getHeight()
    {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}
