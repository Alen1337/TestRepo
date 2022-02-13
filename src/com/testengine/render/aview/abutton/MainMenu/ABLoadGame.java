package com.testengine.render.aview.abutton.MainMenu;

import com.testengine.game.core.GameEventHandler;
import com.testengine.render.aview.abutton.core.ABType;
import com.testengine.render.aview.abutton.core.AButton;

public class ABLoadGame extends AButton {
    public  ABLoadGame(int x, int y, int width, int height) {
        super(x,y,width,height, ABType.MENU_LOAD_GAME);
    }
    @Override
    public void onClick() {
        if(GameEventHandler.getMainMenu() != null) {
            GameEventHandler.getMainMenu().onLoadGame();
        }
    }
}
