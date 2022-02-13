package com.testengine.game.object.unit;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.Debug;

public class Unit extends GameObject {
    private UnitStat unitStat;
    private UnitType unitType;

    public Unit(Transform transform, UnitStat unitStat, UnitType unitType) {
        super(transform, ObjectType.UNIT);
        this.unitStat = unitStat;
        this.unitType = unitType;
        Debug.Log("["+ this.getUnitType() + Debug.SUCCESS_GAMEOBJECT_UNIT_CREATION);
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
