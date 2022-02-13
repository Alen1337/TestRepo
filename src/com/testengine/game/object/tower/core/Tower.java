package com.testengine.game.object.tower.core;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.utils.Transform;

public abstract class Tower extends GameObject {
    protected float range;
    protected TowerType towerType;

    public Tower(Transform transform, float range, TowerType towerType) {
        super(transform, ObjectType.TOWER);
        this.range = range;
        this.towerType = towerType;
    }

    public float getRange() {
        return range;
    }

    public TowerType getTowerType() {
        return towerType;
    }

    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public void setTowerType(TowerType towerType) {
        this.towerType = towerType;
    }
}
