package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.Entity;

public abstract class Creature extends Entity
{
    public static final Integer DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=3.0f;
    public static final Integer DEFAULT_CREATURE_WIDTH=64;
    public static final Integer DEFAULT_CREATURE_HEIGHT=64;
    protected Integer health;
    protected float speed;
    protected float xMove,yMove;

    public Creature(Game game,Float x, Float y, Integer width, Integer height)
    {
        super(game,x, y,width,height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    public void move()
    {
        x+=xMove;
        y+=yMove;
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
