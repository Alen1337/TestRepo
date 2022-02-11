package com.testengine.game.core;

import com.testengine.game.scene.Scene;
import com.testengine.render.Window;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.SUCCESS_RENDERHANDLER_CONNECTION;

public class RenderHandler {
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
}
