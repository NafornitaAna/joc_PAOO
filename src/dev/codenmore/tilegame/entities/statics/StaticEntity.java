package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity
{
    public StaticEntity(Handler handler,float x,float y,Integer width,Integer height)
    {
        super(handler,x,y,width,height);
    }
}
