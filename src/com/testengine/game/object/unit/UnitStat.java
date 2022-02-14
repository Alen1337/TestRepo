package com.testengine.game.object.unit;

import com.testengine.game.object.shot.Damage;

public class UnitStat {
    private float health, armor, shield;
    private float maxHealth;
    private Boolean dead;

    public UnitStat(float health, float armor, float shield) {
        this.health = health;
        this.maxHealth = health;
        this.armor = armor;
        this.shield = shield;
        this.dead = false;
    }

    public void takeDMG(Damage damage) {
        if(shield > 0) {
            setShield(shield - damage.getShield());
        }
        else if(armor > 0) {
            setArmor(armor - damage.getArmor());
        }
        else if(health > 0) {
            setHealth(health - damage.getHealth());
        } else {
            dead = true;
        }
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

    public float getMaxHealth() {
        return maxHealth;
    }

    public Boolean isDead() {
        return dead;
    }
}
