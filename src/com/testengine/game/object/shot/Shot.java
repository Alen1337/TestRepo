package com.testengine.game.object.shot;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.tower.core.Tower;
import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;

public abstract class Shot extends GameObject {
    protected Damage damage;
    protected Tower towerFrom;
    protected Unit target;
    protected DamageType damageType;


    public Shot(float width, float height, Tower towerFrom, Unit target, Damage damage, DamageType damageType) {
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
