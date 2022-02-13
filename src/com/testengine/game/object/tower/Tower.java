package com.testengine.game.object.tower;

import com.testengine.game.object.GameObject;
import com.testengine.game.object.ObjectType;
import com.testengine.game.object.utils.Transform;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Tower extends GameObject {
    protected float range;
    protected TowerType towerType;

    public Tower(Transform transform, float range, TowerType towerType) {
        super(transform, ObjectType.TOWER);
        this.range = range;
        this.towerType = towerType;
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
