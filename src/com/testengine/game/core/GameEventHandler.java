package com.testengine.game.core;

import com.testengine.game.object.game.shot.Shot;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneHandler;
import com.testengine.game.scene.SceneType;
import com.testengine.utils.Debug;

import java.awt.event.MouseEvent;

import static com.testengine.utils.Debug.SUCCESS_GAMEHANDLER_CONNECTION;

public class GameEventHandler {
    private static GameMain gameMain;

    public static void setGame(GameMain game) {
        gameMain = game;
        Debug.Log(SUCCESS_GAMEHANDLER_CONNECTION);
    }

    public static SceneType getMainSceneType() {
        if(gameMain != null) return gameMain.getMainScene().getSceneType();
        return null;
    }

    public static void mouseClicked(MouseEvent e) {
        gameMain.onMouseClick(e.getX(), e.getY());
    }

    public static Scene getMainScene() {
        return gameMain.getMainScene();
    }

    public static GameMain getGameMain() {
        return gameMain;
    }

    public static void createShot(Shot shot){
        GameEventHandler.getMainScene().getGameObjects().add(shot);
    }

    public static void backToMenu() {
        SceneHandler.loadMainMenuScene();
    }

}
