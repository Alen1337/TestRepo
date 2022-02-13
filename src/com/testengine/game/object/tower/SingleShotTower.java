package com.testengine.game.object.tower;

import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.utils.Transform;

import java.util.Timer;
import java.util.TimerTask;

public class SingleShotTower extends AttackTower {
    public SingleShotTower(Transform transform, float range, int attackSpeed) {
        super(transform,
                range,
                attackSpeed,
                new AttackTowerStat(10,10,10,10,10),
                TowerType.SINGLE_SHOT);
    }

    @Override
    protected void onShot() {

    }


}
