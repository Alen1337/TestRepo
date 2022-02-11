package com.testengine.render.aview.amenu;

import com.testengine.render.aview.abutton.MainMenu.ABExit;
import com.testengine.render.aview.abutton.MainMenu.ABLoadGame;
import com.testengine.render.aview.abutton.MainMenu.ABNewGame;
import com.testengine.render.aview.abutton.MainMenu.ABSettings;

public class AMMainMenu extends AMenu {
    ABNewGame newGameButton;
    ABLoadGame loadGameButton;
    ABSettings settingsButton;
    ABExit exitButton;

    public AMMainMenu(int x, int y, int width, int height) {
        super(x,y,width,height);
        newGameButton = new ABNewGame(x,0,width,100);
        loadGameButton = new ABLoadGame(x,100,width,200);
        settingsButton = new ABSettings(x,200,width,300);
        exitButton = new ABExit(x,300,width,400);
    }
}
