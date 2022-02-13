package com.testengine.game.object.unit;

public class UnitStat {
    private float health, armor, shield;

    public UnitStat(float health, float armor, float shield) {
        this.health = health;
        this.armor = armor;
        this.shield = shield;
    }

    public void takeDMG(float healthDMG, float armorDMG, float shieldDMG) {
        health -= healthDMG;
        armor -= armorDMG;
        shield -= shieldDMG;
    }

    public float getHealth() {
        return health;
    }

    public float getArmor() {
        return armor;
    }

    public float getShield() {
        return shield;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public void setShield(float shield) {
        this.shield = shield;
    }
}
