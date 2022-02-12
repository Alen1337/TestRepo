package com.testengine.render.aview.abutton.MainMenu;

import com.testengine.game.core.GameHandler;
import com.testengine.render.aview.abutton.core.ABType;
import com.testengine.render.aview.abutton.core.AButton;

public class ABNewGame extends AButton {

    public ABNewGame(int x, int y, int width, int height) {
        super(x,y,width,height, ABType.MENU_NEW_GAME);
    }
    @Override
    public void onClick() {
        if(GameHandler.getMainMenu() != null) {
            GameHandler.getMainMenu().onNewGame();
        }
    }
}
