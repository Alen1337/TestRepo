package com.testengine.render.aview.aobject;

import com.testengine.game.object.shot.Shot;
import com.testengine.game.object.shot.SingleShotTowerShot;
import com.testengine.game.object.tower.core.TowerType;
import com.testengine.game.object.utils.Transform;

import java.awt.*;

import static com.testengine.render.aview.aobject.AORenderer.camera;

public class AOShot {
    public static void render(Graphics g, Shot shot) {
        if(shot.getTowerFrom().getTowerType() == TowerType.SINGLE_SHOT) {
            renderSingleShotTowerShot(g, (SingleShotTowerShot)shot);
        }
    }

    private static void renderSingleShotTowerShot(Graphics g, SingleShotTowerShot shot) {
        Transform t = shot.getTransform();
        Transform c = camera.getTransform();
        g.setColor(Color.RED);
        g.fillRect((int)t.getPosition().getX() + (int)c.getPosition().getX(), (int)t.getPosition().getY() + (int)c.getPosition().getY(),
                (int)t.getPosition().getWidth(),(int)t.getPosition().getHeight());
    }
}
