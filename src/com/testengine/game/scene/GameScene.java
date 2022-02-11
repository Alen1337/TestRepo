package com.testengine.game.scene;

import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.SUCCESS_GAMESCENE_CREATION;

public class GameScene extends Scene {
    public GameScene() {
        super(SceneType.GAME);
        Debug.Log(SUCCESS_GAMESCENE_CREATION);
    }

    @Override
    public void update() {

    }
}
