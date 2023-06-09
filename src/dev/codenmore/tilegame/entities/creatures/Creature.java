package dev.codenmore.tilegame.entities.creatures;
import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.tiles.Tile;

public abstract class Creature extends Entity
{
    public static final float DEFAULT_SPEED=3.0f;
    public static final Integer DEFAULT_CREATURE_WIDTH=128;
    public static final Integer DEFAULT_CREATURE_HEIGHT=128;
    protected float speed;
    protected float xMove,yMove;

    public Creature(Handler handler, Float x, Float y, Integer width, Integer height)
    {
        super(handler,x, y,width,height);
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    public void move()
    {
        if(!checkEntityCollisions(xMove,0f))
            moveX();
        if(!checkEntityCollisions(0f,yMove))
            moveY();
    }

    public void moveX()
    {
        if(xMove>0)
        {
            //move right
            Integer tx=(int)(x+xMove+bounds.x+bounds.width)/ Tile.TILEWIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)
            && !collisionWithTile(tx,(int)(y+bounds.y+ bounds.height)/Tile.TILEHEIGHT))
            {
                x+=xMove;
            }
            else
            {
                x=(float)(tx*Tile.TILEWIDTH-bounds.x-bounds.width-1);
            }
        }
        else if(xMove<0)
        {
            //move left
            Integer tx=(int)(x+xMove+bounds.x)/ Tile.TILEWIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/Tile.TILEHEIGHT)
                    && !collisionWithTile(tx,(int)(y+bounds.y+ bounds.height)/Tile.TILEHEIGHT))
            {
                x+=xMove;
            }
            else
            {
                x=(float)(tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bounds.x);
            }
        }
    }

    public void moveY()
    {
        if(yMove<0)
        {
            //up
            Integer ty=(int)(y+yMove+bounds.y)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)
            && !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty))
            {
                y+=yMove;
            }
            else
            {
                y=(float)(ty*Tile.TILEHEIGHT+Tile.TILEHEIGHT-bounds.y);
            }
        }
        else if(yMove>0)
        {
            //down
            Integer ty=(int)(y+yMove+bounds.y+bounds.height)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)
                    && !collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty))
            {
                y+=yMove;
            }
            else
            {
                y=(float)(ty*Tile.TILEHEIGHT-bounds.y-bounds.height-1);
            }
        }
    }

    protected boolean collisionWithTile(Integer x,Integer y)
    {
        return handler.getGame().gameState.getWorld().getTile(x,y).isSolid();
    }
    //getters setters
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }
}
