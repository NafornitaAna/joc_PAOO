package dev.codenmore.tilegame.entities;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.creatures.Player;
import dev.codenmore.tilegame.entities.creatures.Player2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager
{
    private Player player;
    private Player2 player2;
    private ArrayList<Entity> entities;
    private Comparator<Entity>renderSorter=new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY()+a.getHeight()<b.getY()+b.getHeight())
                return -1;
            return 1;
        }
    };
    public EntityManager(Player player,Player2 player2)
    {
        this.player=player;
        this.player2=player2;
        entities=new ArrayList<Entity>();
        addEntity(player);
        addEntity(player2);
    }
    public void tick()
    {
        Iterator<Entity> it= entities.iterator();
        while(it.hasNext())
        {
            Entity e=it.next();
            e.tick();
            if(!e.isActive())
                it.remove();
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g)
    {
        for(Entity e:entities)
        {
            e.render(g);
        }
        player.postRender(g);
        player2.postRender(g);
    }
    public void addEntity(Entity e)
    {
        entities.add(e);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public Player2 getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player2 player2) {
        this.player2 = player2;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}








