package com.testengine.game.object.game.core;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.game.building.core.Building;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.render.core.ViewSceneHandler;
import com.testengine.utils.Debug;

public class BuildTile extends GameObject {

    private Building buildingToBuild;
    public BuildTile(Building buildingToBuild, float width, float height) {
        super(new Transform(new Position(0,0,width,height),new Velocity()), ObjectType.BUILD_TILE);
        this.buildingToBuild = buildingToBuild;
    }

    @Override
    public void update(float dt) {
        Position mouse = ViewSceneHandler.getMousePositionInGame();
        if(mouse != null) {
            //Debug.LogInput(mouse.getX() + " " + mouse.getY());
            transform.getPosition().setX(getTilePosition(mouse.getX()));
            transform.getPosition().setY(getTilePosition(mouse.getY()));
        }

    }

    private float getTilePosition(float cord) {
        if(cord < 0) {
            return (int)((cord / this.transform.getPosition().getWidth()) + -1) * this.transform.getPosition().getWidth();
        } else {
            return (int)(cord / this.transform.getPosition().getWidth()) * this.transform.getPosition().getWidth();
        }
    }

    @Override
    public void onDestroy() {

    }
}
