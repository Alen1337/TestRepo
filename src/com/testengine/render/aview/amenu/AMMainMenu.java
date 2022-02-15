package com.testengine.render.aview.amenu;

import com.testengine.game.core.GameEventHandler;
import com.testengine.render.aview.abutton.MainMenu.ABExit;
import com.testengine.render.aview.abutton.MainMenu.ABLoadGame;
import com.testengine.render.aview.abutton.MainMenu.ABNewGame;
import com.testengine.render.aview.abutton.MainMenu.ABSettings;

import java.awt.event.MouseEvent;



public class AMMainMenu extends AMenu {
    private ABNewGame newGameButton;
    private ABLoadGame loadGameButton;
    private ABSettings settingsButton;
    private ABExit exitButton;

    public AMMainMenu(int x, int y, int width, int height) {
        super(x,y,width,height);
        newGameButton = new ABNewGame(x,0,width,100);
        loadGameButton = new ABLoadGame(x,110,width,100);
        settingsButton = new ABSettings(x,220,width,100);
        exitButton = new ABExit(x,330,width,100);
    }

    public void handleClick(MouseEvent e) {
        if(exitButton.isClicked(e.getX(),e.getY())) {
            exitButton.onClick();
        }
        else if(newGameButton.isClicked(e.getX(),e.getY())) {
            newGameButton.onClick();
        }
        else if(loadGameButton.isClicked(e.getX(),e.getY())) {
            loadGameButton.onClick();
        }
        else if(settingsButton.isClicked(e.getX(),e.getY())) {
            settingsButton.onClick();
        } else {
            GameEventHandler.mouseClicked(e);
        }
    }

    public ABNewGame getNewGameButton() {
        return newGameButton;
    }

    public ABLoadGame getLoadGameButton() {
        return loadGameButton;
    }

    public ABSettings getSettingsButton() {
        return settingsButton;
    }

    public ABExit getExitButton() {
        return exitButton;
    }

}
