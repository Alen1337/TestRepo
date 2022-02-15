package com.testengine.game.scene;


import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.*;

public class MainMenuScene extends Scene {

    public MainMenuScene() {
        super(SceneType.MAINMENU);
        Debug.Log(SUCCESS_MENUSCENE_CREATION);
    }

    @Override
    public void update(float dt) {

    }

    public void onNewGame() {
        Debug.LogInput(SUCCESS_MAIN_MENU_NEW_GAME_BUTTON_CLICKED);

        SceneHandler.loadScene(new GameScene());
    }

    public void onLoadGame() {
        Debug.LogInput(SUCCESS_MAIN_MENU_LOAD_GAME_BUTTON_CLICKED);
    }

    public void onSettings() {
        Debug.LogInput(SUCCESS_MAIN_MENU_SETTINGS_BUTTON_CLICKED);
    }

    public void onExit() {
        Debug.LogInput(SUCCESS_MAIN_MENU_EXIT_BUTTON_CLICKED);
    }

    @Override
    public void onDestroy() {

    }
}
