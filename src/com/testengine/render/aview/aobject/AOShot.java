package com.testengine.render.aview.aobject;

import com.testengine.game.object.game.shot.Shot;
import com.testengine.game.object.game.shot.SingleShotTowerShot;
import com.testengine.game.object.game.building.tower.core.TowerType;
import com.testengine.game.object.utils.Transform;

import java.awt.*;


public class AOShot {
    public static void render(Graphics g, Shot shot, Transform camera) {
        if(shot.getTowerFrom().getTowerType() == TowerType.SINGLE_SHOT) {
            renderSingleShotTowerShot(g, (SingleShotTowerShot)shot, camera);
        }
    }

    private static void renderSingleShotTowerShot(Graphics g, SingleShotTowerShot shot, Transform camera) {
        Transform t = shot.getTransform();
        g.setColor(Color.RED);
        g.fillRect((int)t.getPosition().getX() + (int)camera.getPosition().getX(), (int)t.getPosition().getY() + (int)camera.getPosition().getY(),
                (int)t.getPosition().getWidth(),(int)t.getPosition().getHeight());
    }
}
