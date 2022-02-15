package com.testengine.render.aview.abutton.MainMenu;

import com.testengine.Main;
import com.testengine.game.core.GameEventHandler;
import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.SceneHandler;
import com.testengine.render.aview.abutton.core.ABType;
import com.testengine.render.aview.abutton.core.AButton;

public class ABNewGame extends AButton {

    public ABNewGame(int x, int y, int width, int height) {
        super(x,y,width,height, ABType.MENU_NEW_GAME);
    }
    @Override
    public void onClick() {
        SceneHandler.getMainMenuScene().onNewGame();
    }
}
