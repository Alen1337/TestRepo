package com.testengine.game.object.unit;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.Debug;

public class Unit extends GameObject {
    private UnitStat unitStat;
    private UnitType unitType;
    private int goldOnKill;

    public Unit(Transform transform, UnitStat unitStat, int goldOnKill, UnitType unitType) {
        super(transform, ObjectType.UNIT);
        this.unitStat = unitStat;
        this.goldOnKill = goldOnKill;
        this.unitType = unitType;
        Debug.LogObject("["+ this.getUnitType() + Debug.SUCCESS_GAMEOBJECT_UNIT_CREATION);
    }

    public void update(float dt) {
        transform.update(dt);
    }

    public Transform getTransform() {
        return transform;
    }

    public UnitStat getUnitStat() {
        return unitStat;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public int getGoldOnKill() {
        return this.goldOnKill;
    }

}
