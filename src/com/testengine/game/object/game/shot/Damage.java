package com.testengine.game.object.game.shot;

public class Damage {
    private float health, armor, shield;

    public Damage(float health, float armor, float shield) {
        this.health = health;
        this.armor = armor;
        this.shield = shield;
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
}
