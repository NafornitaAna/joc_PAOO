package dev.codenmore.tilegame.states;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;

import java.awt.*;

public class MenuState extends State
{
    private UIManager uiManager;
    public MenuState(Handler handler)
    {
        super(handler);
        uiManager=new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton
                (315, 150, 150, 64, Assets.btn_start, new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setUiManager(null);
                        State.setState(handler.getGame().gameState);
                    }
                }));
        uiManager.addObject(new UIImageButton
                (300, 250, 128, 64, Assets.btn_continue, new ClickListener() {
            @Override
            public void onClick() {
//                handler.getMouseManager().setUiManager(null);
//                //handler.getGame().getDatabase().restoreData(handler);
//                int level=handler.getGame().getDatabase().getLevel();
//                if(level==0||level==1)
//                {
//                    State.setState(handler.getGame().gameState);
//                }
//                if(level==2)
//                {
//                    State.setState(handler.getGame().gameState2);
//                }
//                if(level==3)
//                {
//                    State.setState(handler.getGame().gameState3);
//                }


                handler.getMouseManager().setUiManager(null);
                State.setState(new GameState(handler));
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
