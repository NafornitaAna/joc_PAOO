package dev.codenmore.tilegame.worlds;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.EntityManager;
import dev.codenmore.tilegame.entities.NPC_Soricel;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;
import dev.codenmore.tilegame.entities.statics.*;
import dev.codenmore.tilegame.items.ItemManager;
import dev.codenmore.tilegame.tiles.Tile;
import dev.codenmore.tilegame.utils.Utils;
import java.awt.*;

public class World2 extends Worlds
{
    public World2(Handler handler, String path)
    {
        this.handler =handler;
        entityManager=new EntityManager(handler,new Player(handler,100f,100f),
                new Player2(handler,100f,100f));
        itemManager=new ItemManager(handler);
        entityManager.addEntity(new Ceasca(handler,400,300));
        entityManager.addEntity(new Briosa1(handler,250,250));
        entityManager.addEntity(new CartiDeJoc(handler,400,10));
        entityManager.addEntity(new Pahar(handler,20,400));
        entityManager.addEntity(new NPC_Soricel(handler,0f,100f));
        entityManager.addEntity(new NPC_Soricel(handler,600f,300f));

        loadWorld(path);

        entityManager.getPlayer().setX((float)spawnX);
        entityManager.getPlayer().setY((float)spawnY);
        entityManager.getPlayer2().setX((float)spawnX+100);
        entityManager.getPlayer2().setY((float)spawnY);
    }
}

