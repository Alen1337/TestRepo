package com.testengine.game.scene;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.render.core.ViewSceneHandler;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.START_MENUSCENE_CREATION;

public class SceneHandler {
    public static void loadScene(Scene sceneToLoad) {
        unloadScene(GameEventHandler.getMainScene());
        ViewSceneHandler.unloadScene();
        GameEventHandler.getGameMain().setMainScene(sceneToLoad);
        ViewSceneHandler.loadScene(sceneToLoad.getSceneType());
    }

    private static void unloadScene(Scene sceneToUnLoad) {
        sceneToUnLoad.onDestroy();
    }

    public static Scene getStartScene() {
        Debug.Log(START_MENUSCENE_CREATION);
        return new MainMenuScene();
    }

    public static void loadMainMenuScene() {
        loadScene(new MainMenuScene());
    }

    public static Scene getMainScene() {
        return GameEventHandler.getMainScene();
    }

    public static MainMenuScene getMainMenuScene() {
        return (MainMenuScene)getMainScene();
    }

    public static GameScene getGameScene() {
        return (GameScene)getMainScene();
    }
}
