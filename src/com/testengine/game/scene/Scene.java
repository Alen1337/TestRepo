package com.testengine.game.scene;

import com.testengine.game.object.GameObject;

import java.util.ArrayList;

public abstract class Scene {
    protected final ArrayList<GameObject> gameObjects;
    protected SceneType sceneType;

    public abstract void update();

    protected Scene(SceneType sceneType) {
        gameObjects = new ArrayList();
        this.sceneType = sceneType;
    }

    public SceneType getSceneType() {
        return sceneType;
    }


    public ArrayList<GameObject> getGameObjects() {
        return this.gameObjects;
    }

}
