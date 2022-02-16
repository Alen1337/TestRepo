package com.testengine.game.object.game.building.tower.core;

public class AttackTowerStat {
    private float levelBaseDMGMultiplier;
    private float levelHealthDMGMultiplier;
    private float levelArmorDMGMultiplier;
    private float levelShieldDMGMultiplier;
    private float startBaseDMG;
    private float level;
    private float healthDMGMultiplier, armorDMGMultiplier, shieldDMGMultiplier;

    public AttackTowerStat(float startBaseDMG, float levelBaseDMGMultiplier, float levelHealthDMGMultiplier, float levelArmorDMGMultiplier, float levelShieldDMGMultiplier) {
        this.startBaseDMG = startBaseDMG;
        this.levelBaseDMGMultiplier = levelBaseDMGMultiplier;
        this.levelHealthDMGMultiplier = levelHealthDMGMultiplier;
        this.levelArmorDMGMultiplier = levelArmorDMGMultiplier;
        this.levelShieldDMGMultiplier = levelShieldDMGMultiplier;
        level = 1;
        healthDMGMultiplier = 0;
        armorDMGMultiplier = 0;
        shieldDMGMultiplier = 0;
    }

    public void levelUp() {
        level++;
    }

    public void healthLvlUp() {
        levelUp();
        healthDMGMultiplier += level * levelHealthDMGMultiplier;
    }

    public void armorLvlUp() {
        levelUp();
        armorDMGMultiplier += level * levelArmorDMGMultiplier;
    }

    public void shieldLvlUp() {
        levelUp();
        shieldDMGMultiplier += level * levelShieldDMGMultiplier;
    }

    public float getBaseDMG() {
        return startBaseDMG + (level * levelBaseDMGMultiplier);
    }

    public float getHealthDMG() {
        return getBaseDMG() + healthDMGMultiplier;
    }

    public float getArmorDMG() {
        return getBaseDMG() + armorDMGMultiplier;
    }

    public float getShieldDMG() {
        return getBaseDMG() + shieldDMGMultiplier;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public float getHealthDMGMultiplier() {
        return healthDMGMultiplier;
    }

    public void setHealthDMGMultiplier(float healthDMGMultiplier) {
        this.healthDMGMultiplier = healthDMGMultiplier;
    }

    public float getArmorDMGMultiplier() {
        return armorDMGMultiplier;
    }

    public void setArmorDMGMultiplier(float armorDMGMultiplier) {
        this.armorDMGMultiplier = armorDMGMultiplier;
    }

    public float getShieldDMGMultiplier() {
        return shieldDMGMultiplier;
    }

    public void setShieldDMGMultiplier(float shieldDMGMultiplier) {
        this.shieldDMGMultiplier = shieldDMGMultiplier;
    }
}
