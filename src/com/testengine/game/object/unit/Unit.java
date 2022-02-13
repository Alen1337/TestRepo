package com.testengine.game.object.unit;

import com.testengine.game.object.GameObject;
import com.testengine.game.object.ObjectType;
import com.testengine.game.object.utils.Transform;

public class Unit extends GameObject {
    private UnitStat unitStat;
    private UnitType unitType;

    public Unit(Transform transform, UnitStat unitStat, UnitType unitType) {
        super(transform, ObjectType.UNIT);
        this.unitStat = unitStat;
        this.unitType = unitType;
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
}
