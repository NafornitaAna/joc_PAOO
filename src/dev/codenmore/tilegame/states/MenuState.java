package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;
import dev.codenmore.tilegame.worlds.World;
import dev.codenmore.tilegame.worlds.World2;

import java.awt.*;

public class MenuState extends State
{
    private UIManager uiManager;
    public MenuState(Handler handler)
    {
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        //intru in joc nou
        uiManager.addObject(new UIImageButton
                (315, 150, 150, 64, Assets.btn_start, new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setUiManager(null);
                        handler.getGame().gameState.setWorld(new World(handler, "res/worlds/world1.txt"));
                        State.setState(handler.getGame().gameState);
                    }
                }));

        //reluare joc vechi
        uiManager.addObject(new UIImageButton
                (300, 250, 128, 64, Assets.btn_continue, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                handler.getGame().getDatabase().restoreData(handler);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        uiManager.render(g);
    }

    @Override
    public void loadWorld() {

    }
}
