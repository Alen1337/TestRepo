package com.testengine.game.object.core;

public class Player extends GameObject {
    private int money;
    private int maxMana;
    private int currentMana;
    private int manaRegen;
    private int wood, stone, clay, steel, explosive;

    public Player() {
        super(null,ObjectType.PLAYER);
        money = 500;
        maxMana = 100;
        currentMana = 100;
        manaRegen = 1;
        wood = 0;
        stone = 0;
        clay = 0;
        steel = 0;
        explosive = 0;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void onDestroy() {

    }
}
