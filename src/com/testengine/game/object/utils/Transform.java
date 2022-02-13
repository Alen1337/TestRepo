package com.testengine.game.object.utils;

public class Transform {
    private Position position;
    private Velocity velocity;

    public Transform(Position position, Velocity velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void update(float dt) {
        position.setX(position.getX() + (velocity.getX() * dt));
        position.setY(position.getY() + (velocity.getY() * dt));

        velocity.update();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
}
