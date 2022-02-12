package com.testengine.render.aview.abutton.MainMenu;

import com.testengine.game.core.GameHandler;
import com.testengine.render.aview.abutton.core.ABType;
import com.testengine.render.aview.abutton.core.AButton;

public class ABSettings extends AButton {
    public ABSettings(int x, int y, int width, int height) {
        super(x,y,width,height, ABType.MENU_SETTINGS);
    }
    @Override
    public void onClick() {
        if(GameHandler.getMainMenu() != null) {
            GameHandler.getMainMenu().onSettings();
        }
    }
}
