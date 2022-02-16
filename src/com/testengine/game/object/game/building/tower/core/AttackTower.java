package com.testengine.game.object.game.building.tower.core;

import com.testengine.game.object.game.unit.Unit;
import com.testengine.game.object.utils.Transform;

import java.util.Timer;
import java.util.TimerTask;

public abstract class AttackTower extends Tower {
    protected Unit targetUnit;
    private Timer shotTimer;
    private int attackSpeed;
    protected boolean searchingForTarget;
    protected AttackTowerStat attackTowerStat;

    public AttackTower(Transform transform, float range, int attackSpeed, AttackTowerStat attackTowerStat, TowerType towerType) {
        super(transform, range, towerType);
        shotTimer = new Timer();
        this.attackSpeed = attackSpeed;
        this.attackTowerStat = attackTowerStat;
        this.searchingForTarget = true;
    }

    public void clearTargetUnit() {
        searchingForTarget = true;
        stopShot();
        targetUnit = null;
    }

    public void setTargetUnit(Unit target) {
        searchingForTarget = false;
        targetUnit = target;
        setShotTimerPeriod();
    }

    protected abstract void onShot();

    public void refreshShotTimerPeriod() {
        stopShot();
        setShotTimerPeriod();

    }

    public void setShotTimerPeriod() {
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

    public AttackTowerStat getAttackTowerStat() {
        return attackTowerStat;
    }

    @Override
    public void onDestroy() {
        stopShot();
    }
}
