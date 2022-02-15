package com.testengine.game.scene;

import com.testengine.game.core.ObjectHandler;
import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.PlayerBasement;
import com.testengine.game.object.tower.species.SingleShotTower;
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

        PlayerBasement base = new PlayerBasement(
                new Transform(new Position(50,50,50,50),new Velocity(0,0,0,0)),10);

        Unit unit = new Unit(
                new Transform(new Position(50,100,50,50),new Velocity(0,0,0,0)),
                new UnitStat(300,100,100),
                100,
                UnitType.SMALL
                );

        SingleShotTower tower = new SingleShotTower(
                new Transform(new Position(200,200,100,100), new Velocity(0,0,0,0)),
                500, 1000
        );

        //gameObjects.add(base);
        gameObjects.add(unit);
        gameObjects.add(tower);

        Debug.Log(SUCCESS_GAMESCENE_CREATION);
    }

    @Override
    public void update(float dt) {
        ObjectHandler.update(gameObjects, dt);
    }

    @Override
    public void onDestroy() {
        for(int i = 0;i<gameObjects.size();i++) {
            gameObjects.get(i).onDestroy();
        }
    }
}
