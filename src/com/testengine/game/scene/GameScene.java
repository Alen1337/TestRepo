package com.testengine.game.scene;

import com.testengine.game.object.tower.SingleShotTower;
import com.testengine.game.object.tower.TowerType;
import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.unit.UnitStat;
import com.testengine.game.object.unit.UnitType;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.SUCCESS_GAMESCENE_CREATION;

public class GameScene extends Scene {


    public GameScene() {
        super(SceneType.GAME);
        Unit unit = new Unit(
                new Transform(new Position(50,50,50,50),new Velocity(0,0,0,0)),
                new UnitStat(10000,5000,5000),
                UnitType.SMALL
                );

        SingleShotTower tower = new SingleShotTower(
                new Transform(new Position(200,200,50,50), new Velocity(0,0,0,0)),
                200, 1500
        );

        gameObjects.add(unit);
        gameObjects.add(tower);

        Debug.Log(SUCCESS_GAMESCENE_CREATION);
    }

    @Override
    public void update() {

    }
}
