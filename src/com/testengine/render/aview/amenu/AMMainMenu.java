package com.testengine.render.aview.amenu;

import com.testengine.game.core.GameEventHandler;
import com.testengine.render.aview.abutton.MainMenu.ABExit;
import com.testengine.render.aview.abutton.MainMenu.ABLoadGame;
import com.testengine.render.aview.abutton.MainMenu.ABNewGame;
import com.testengine.render.aview.abutton.MainMenu.ABSettings;

import java.awt.event.MouseEvent;

import static com.testengine.render.ViewSceneHandler.MainMenuSceneView;

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

    public static void handleClick(MouseEvent e) {
        if(MainMenuSceneView.getExitButton().isClicked(e.getX(),e.getY())) {
            MainMenuSceneView.getExitButton().onClick();
        }
        else if(MainMenuSceneView.getNewGameButton().isClicked(e.getX(),e.getY())) {
            MainMenuSceneView.getNewGameButton().onClick();
        }
        else if(MainMenuSceneView.getLoadGameButton().isClicked(e.getX(),e.getY())) {
            MainMenuSceneView.getLoadGameButton().onClick();
        }
        else if(MainMenuSceneView.getSettingsButton().isClicked(e.getX(),e.getY())) {
            MainMenuSceneView.getSettingsButton().onClick();
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
