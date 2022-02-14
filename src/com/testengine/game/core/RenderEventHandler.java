package com.testengine.game.core;

import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.ACamera;
import com.testengine.render.aview.aobject.AORenderer;
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
        window.update();
    }

    public static Boolean isWindowCreated() {
        return window != null;
    }

    public static void loadScene(Scene scene) {
        window.setRenderScene(scene);
    }

    public static void handleMouseClick(MouseEvent e) {
        if(GameEventHandler.getMainSceneType() == SceneType.MAINMENU) {
            AMMainMenu.handleClick(e);
        }
    }

    public static void handleMousePress(MouseEvent e) {
        if(GameEventHandler.getMainSceneType() == SceneType.GAME) {
            ACamera.handleButtonPress(e);
        }
    }

    public static void handleMouseRelease(MouseEvent e) {
        if(GameEventHandler.getMainSceneType() == SceneType.GAME) {
            ACamera.handleButtonRelease(e);
        }
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
