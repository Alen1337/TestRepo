package com.testengine.render.core;

import com.testengine.game.core.RenderEventHandler;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.ascene.ASGameScene;
import com.testengine.render.aview.ascene.ASMainMenuScene;
import com.testengine.render.aview.ascene.AScene;
import com.testengine.render.aview.acamera.ACamera;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

import static com.testengine.utils.Debug.SUCCESS_SCENE_CONNECTION_TO_RENDERER;

public class ViewSceneHandler {
    private static AScene renderScene;

    public static void clear() {

    }
    public static ACamera getCamera() {
        return renderScene.getCamera();
    }

    public static void handleMouseClick(MouseEvent e) {
        renderScene.handleMouseClick(e);
    }

    public static void handleMousePress(MouseEvent e) {
        renderScene.handleMousePress(e);
    }

    public static void handleMouseRelease(MouseEvent e) {
        renderScene.handleMouseRelease(e);
    }

    public static void handleKeyPress(InputKey inputKey) { renderScene.onKeyPress(inputKey); }

    public static AScene getRenderScene() {
        return renderScene;
    }

    public static void setRenderScene(AScene renderScene) {
        ViewSceneHandler.renderScene = renderScene;

    }

    public static void loadScene(SceneType sceneTypeToLoad) {
        if(sceneTypeToLoad == SceneType.MAINMENU) {
            setRenderScene(new ASMainMenuScene(0,0, RenderEventHandler.getWindowWidth(), RenderEventHandler.getWindowHeight()));
        } else if(sceneTypeToLoad == SceneType.GAME) {
            setRenderScene(new ASGameScene(0,0, RenderEventHandler.getWindowWidth(), RenderEventHandler.getWindowHeight()));

        }
        Debug.Log("[" + sceneTypeToLoad + SUCCESS_SCENE_CONNECTION_TO_RENDERER);
    }

    public static void unloadScene() { renderScene.onDestroy(); }
}
