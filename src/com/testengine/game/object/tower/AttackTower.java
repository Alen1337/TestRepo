package com.testengine.game.object.tower;

import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.utils.Transform;

import java.util.Timer;
import java.util.TimerTask;

public abstract class AttackTower extends Tower {
    protected Unit targetUnit;
    private Timer shotTimer;
    private int attackSpeed;
    private boolean searchingForTarget;
    private AttackTowerStat attackTowerStat;

    public AttackTower(Transform transform, float range, int attackSpeed, AttackTowerStat attackTowerStat, TowerType towerType) {
        super(transform, range, towerType);
        shotTimer = new Timer();
        this.attackSpeed = attackSpeed;
        this.attackTowerStat = attackTowerStat;
        this.searchingForTarget = true;
    }

    public void setTargetUnit(Unit target) {
        targetUnit = target;
    }

    protected abstract void onShot();

    public void refreshShotTimerPeriod() {
        shotTimer.cancel();
        shotTimer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        onShot();
                    }
                }, 0, attackSpeed);
    }

    public void stopShot() {
        shotTimer.cancel();
    }

    public Unit getTargetUnit() {
        return targetUnit;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public boolean isSearchingForTarget() {
        return searchingForTarget;
    }

    public void setSearchingForTarget(boolean searchingForTarget) {
        this.searchingForTarget = searchingForTarget;
    }
}
