package com.testengine.game.core;

import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.acamera.ACGame;
import com.testengine.render.aview.acamera.ACHandler;
import com.testengine.render.core.ViewSceneHandler;
import com.testengine.render.core.Window;
import com.testengine.render.aview.amenu.AMMainMenu;
import com.testengine.utils.Debug;

import java.awt.event.MouseEvent;

import static com.testengine.utils.Debug.SUCCESS_RENDERHANDLER_CONNECTION;

public class RenderEventHandler {
    private static Window window;
    public static void setWindow(Window window2) {
        window = window2;
        Debug.Log(SUCCESS_RENDERHANDLER_CONNECTION);
    }
    public static void update() {
        ACHandler.handleCamera();
        window.update();
    }

    public static void loadScene(Scene scene) {
        ViewSceneHandler.loadScene(scene.getSceneType());
    }


    public static int getWindowWidth() {
        return window.getWidth();
    }

    public static int getWindowHeight() {
        return window.getHeight();
    }

    public static float getWindowX() {
        return window.getX();
    }

    public static float getWindowY() {
        return window.getY();
    }
}
