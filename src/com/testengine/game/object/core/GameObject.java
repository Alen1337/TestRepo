package com.testengine.game.object.core;

import com.testengine.game.object.utils.Transform;

public abstract class GameObject {
    protected Transform transform;
    protected ObjectType objectType;

    public GameObject(Transform transform, ObjectType objectType) {
        this.transform = transform;
        this.objectType = objectType;
    }

    public abstract void update(float dt);
    public abstract void onDestroy();
    public Transform getTransform() {
        return transform;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}
