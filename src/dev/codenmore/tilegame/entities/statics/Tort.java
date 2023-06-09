package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.items.Item;

import java.awt.*;

public class Tort extends StaticEntity {

    public Tort(Handler handler, float x, float y)
    {
        super(handler, x, y, 45, 45);
        bounds.x=10;
        bounds.y=10;
        bounds.width=30;
        bounds.height=30;
    }

    @Override
    public void die()
    {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tort,Math.round(x-handler.getGameCamera().getxOffset()),
                Math.round(y-handler.getGameCamera().getyOffset()),80,80,null);
//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),
//                (int)(y+bounds.y-handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }
}
