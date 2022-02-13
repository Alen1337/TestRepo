package com.testengine.game.object.core;

import com.testengine.game.object.utils.Transform;

public class PlayerBasement extends GameObject {
    private int maxHealth;
    private int currentHealth;

    public PlayerBasement(Transform transform, int maxHealth) {
        super(transform, ObjectType.PLAYER_BASE);
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}
