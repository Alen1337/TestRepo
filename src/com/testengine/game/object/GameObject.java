package com.testengine.game.object;

import com.testengine.game.object.utils.Transform;

public abstract class GameObject {
    protected Transform transform;
    protected ObjectType objectType;

    public GameObject(Transform transform, ObjectType objectType) {
        this.transform = transform;
        this.objectType = objectType;
    }

    public Transform getTransform() {
        return transform;
    }

    public ObjectType getObjectType() {
        return objectType;
    }
}
