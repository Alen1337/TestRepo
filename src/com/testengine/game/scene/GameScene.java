package com.testengine.game.scene;

import com.testengine.game.core.ObjectHandler;
import com.testengine.game.object.core.PlayerBasement;
import com.testengine.game.object.game.core.BuildTile;
import com.testengine.game.object.game.building.tower.species.SingleShotTower;
import com.testengine.game.object.game.unit.Unit;
import com.testengine.game.object.game.unit.UnitStat;
import com.testengine.game.object.game.unit.UnitType;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.*;

public class GameScene extends Scene {
    private boolean isBuildMode;
    private BuildTile buildTile;

    public GameScene() {
        super(SceneType.GAME);
        isBuildMode = false;

        PlayerBasement base = new PlayerBasement(
                new Transform(new Position(50,50,50,50),new Velocity(0,0,0,0)),10);

        Unit unit = new Unit(
                new Transform(new Position(50,100,50,50),new Velocity(0,0.05f,0,0)),
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

    public void setBuildMode(boolean state) {
        if(state) {
            buildTile = new BuildTile(null, 50,50);
            gameObjects.add(buildTile);
            Debug.Log(BUILD_MODE_ON);
        } else {
            gameObjects.remove(buildTile);
            buildTile = null;
            Debug.Log((BUILD_MODE_OFF));
        }
        isBuildMode = state;
    }

    public boolean isBuildMode() {
        return isBuildMode;
    }
}
