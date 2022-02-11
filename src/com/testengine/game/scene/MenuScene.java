package com.testengine.game.scene;


import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.SUCCESS_MENUSCENE_CREATION;

public class MenuScene extends Scene {

    public MenuScene() {
        super(SceneType.MENU);
        Debug.Log(SUCCESS_MENUSCENE_CREATION);
    }

    @Override
    public void update() {

    }

    public void onStartNewGame() {

    }

    public void onLoadGame() {

    }

    public void onSettings() {

    }

    public void onExit() {

    }
}
