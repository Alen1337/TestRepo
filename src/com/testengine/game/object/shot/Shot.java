package com.testengine.game.object.shot;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.tower.core.Tower;
import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.utils.Debug;

public abstract class Shot extends GameObject {
    protected Damage damage;
    protected Tower towerFrom;
    protected Unit target;
    protected DamageType damageType;
    protected float speed;

    public Shot(float speed, float width, float height, Tower towerFrom, Unit target, Damage damage, DamageType damageType) {
        super(new Transform(
                new Position(
                        towerFrom.getTransform().getPosition().getX(),
                        towerFrom.getTransform().getPosition().getY(),
                        width,height),
                new Velocity(0,0,0,0)),
                ObjectType.SHOT);
        this.towerFrom = towerFrom;
        this.target = target;
        this.damage = damage;
        this.damageType = damageType;
        this.speed = speed;
    }

    private float toRadian(float angle) {
        return (float)(angle * Math.PI / 180);
    }

    public void calcVelocity() {
        if(target != null) {
            Position targetPos = target.getTransform().getPosition();
            Position thisPos = transform.getPosition();
            float xDistance = thisPos.getX() - targetPos.getX();
            float yDistance = thisPos.getY() - targetPos.getY();
            float angle = (float)Math.atan2(yDistance, xDistance);

            Velocity thisVel = transform.getVelocity();
            thisVel.setX((float)Math.cos(angle + toRadian(180)) * speed);
            thisVel.setY((float)Math.sin(angle + toRadian(180)) * speed);
        } else {
            Debug.Log(Debug.ERROR_CALC_SHOT_VELOCITY);
        }
    }

    public Damage getDamage() {
        return damage;
    }

    public Tower getTowerFrom() {
        return towerFrom;
    }

    public Unit getTarget() {
        return target;
    }
}
