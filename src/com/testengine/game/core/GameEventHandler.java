package com.testengine.game.core;

import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.ViewSceneHandler;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

import static com.testengine.utils.Debug.SUCCESS_GAMEHANDLER_CONNECTION;

public class GameEventHandler {
    private static GameMain gameMain;

    public static void setGame(GameMain game) {
        gameMain = game;
        Debug.Log(SUCCESS_GAMEHANDLER_CONNECTION);
    }

    public static void keyPressed(InputKey inputKey) {
        gameMain.onKeyPress(inputKey);
    }

    public static SceneType getMainSceneType() {
        if(gameMain != null) return gameMain.getMainScene().getSceneType();
        return null;
    }

    public static void mouseClicked(MouseEvent e) {
        gameMain.onMouseClick(e.getX(), e.getY());
    }

    public static MainMenuScene getMainMenu() {
        Scene scene = gameMain.getMainScene();
        if(scene.getSceneType() == SceneType.MAINMENU) {
            return (MainMenuScene) scene;
        } else {
            return null;
        }
    }

    public static Scene getMainScene() {
        return gameMain.getMainScene();
    }

    public static GameMain getGameMain() {
        return gameMain;
    }
}
