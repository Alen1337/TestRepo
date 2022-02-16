package com.testengine.game.object.game.building.tower.species;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.object.game.shot.SingleShotTowerShot;
import com.testengine.game.object.game.building.tower.core.AttackTower;
import com.testengine.game.object.game.building.tower.core.AttackTowerStat;
import com.testengine.game.object.game.building.tower.core.TowerType;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.Debug;

public class SingleShotTower extends AttackTower {
    public SingleShotTower(Transform transform, float range, int attackSpeed) {
        super(transform,
                range,
                attackSpeed,
                new AttackTowerStat(24,10,10,10,10),
                TowerType.SINGLE_SHOT);
        Debug.LogCreateObject("["+ this.getTowerType() + Debug.SUCCESS_GAMEOBJECT_TOWER_CREATION);
    }

    @Override
    protected void onShot() {
        GameEventHandler.createShot(SingleShotTowerShot.createNew(this,targetUnit,attackTowerStat));
    }


    @Override
    public void update(float dt) {
        transform.update(dt);
    }
}
