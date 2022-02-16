package com.testengine.game.object.game.shot;

import com.testengine.game.object.game.building.tower.core.AttackTowerStat;
import com.testengine.game.object.game.building.tower.core.Tower;
import com.testengine.game.object.game.unit.Unit;
import com.testengine.utils.Debug;

public class SingleShotTowerShot extends Shot {
    private static float WIDTH = 20;
    private static float HEIGHT = 20;
    private static float SPEED = 0.4f;
    public static SingleShotTowerShot createNew(Tower towerFrom, Unit targetUnit, AttackTowerStat attackTowerStat) {
        return new SingleShotTowerShot(towerFrom, targetUnit, new Damage(attackTowerStat.getHealthDMG(),attackTowerStat.getArmorDMG(), attackTowerStat.getShieldDMG()));
    }
    public SingleShotTowerShot(Tower towerFrom, Unit target, Damage damage) {
        super(SingleShotTowerShot.SPEED, SingleShotTowerShot.WIDTH, SingleShotTowerShot.HEIGHT, towerFrom, target, damage, DamageType.SINGLE_TARGET);
        Debug.LogCreateObject("["+ this.towerFrom.getTowerType() + Debug.SUCCESS_GAMEOBJECT_SHOT_CREATION);
    }

    @Override
    public void update(float dt) {
        transform.update(dt);
        calcVelocity();
    }
}
