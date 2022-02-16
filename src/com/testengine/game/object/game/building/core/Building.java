package com.testengine.game.object.game.building.core;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.utils.Transform;

public abstract class Building extends GameObject {
    public Building(Transform transform, ObjectType objectType) {
        super(transform, objectType);
    }

}
