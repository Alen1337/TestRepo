package com.testengine.game.core;

import com.testengine.game.core.GameMain;
import com.testengine.game.scene.SceneType;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

import static com.testengine.utils.Debug.SUCCESS_GAMEHANDLER_CONNECTION;

public class GameHandler {
    private static GameMain gameMain;

    public static void setGame(GameMain game) {
        gameMain = game;
        Debug.Log(SUCCESS_GAMEHANDLER_CONNECTION);
    }

    public static void keyPressed(InputKey inputKey) {
        gameMain.onKeyPress(inputKey);
    }

    public static SceneType getMainSceneType() {
        return gameMain.getMainScene().getSceneType();
    }

    public static void mouseClicked(MouseEvent e) {
        gameMain.onMouseClick(e.getX(), e.getY());
    }
}
