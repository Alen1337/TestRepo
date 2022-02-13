package com.testengine.game.object.utils;

public class Velocity {
    private float x,y;
    private float aX, aY;

    public Velocity(float x, float y, float aX, float aY) {
        this.x = x;
        this.y = y;
        this.aX = aX;
        this.aY = aY;
    }

    public Velocity() {
        this.x = 0;
        this.y = 0;
        this.aX = 0;
        this.aY = 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getaX() {
        return aX;
    }

    public float getaY() {
        return aY;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setaX(float aX) {
        this.aX = aX;
    }

    public void setaY(float aY) {
        this.aY = aY;
    }

    public void update() {
        x += aX;
        y += aY;
    }
}
