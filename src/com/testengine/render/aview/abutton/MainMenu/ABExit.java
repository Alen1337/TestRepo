package com.testengine.render.aview.abutton.MainMenu;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.scene.SceneHandler;
import com.testengine.render.aview.abutton.core.ABType;
import com.testengine.render.aview.abutton.core.AButton;

public class ABExit extends AButton {
    public ABExit(int x, int y, int width, int height) {
        super(x,y,width,height, ABType.MENU_EXIT);
    }
    @Override
    public void onClick() {
            SceneHandler.getMainMenuScene().onExit();
    }
}
