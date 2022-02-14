package com.testengine.render.aview;

import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.render.aview.aobject.AORenderer;
import com.testengine.utils.Debug;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ACamera {
    private Transform transform;
    private float scale = 1;
    private Boolean isMoving;
    private Position lastPostion;
    public ACamera(Transform transform) {
        this.transform = transform;
        isMoving = false;
        lastPostion = new Position(0,0,transform.getPosition().getWidth(),transform.getPosition().getHeight());
    }

    public Transform getTransform() {
        return transform;
    }

    public float getScale() {
        return scale;
    }

    public static void handleButtonPress(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            AORenderer.camera.lastPostion.setX(AORenderer.camera.transform.getPosition().getX());
            AORenderer.camera.lastPostion.setY(AORenderer.camera.transform.getPosition().getY());
            AORenderer.camera.isMoving = true;
        }
    }

    public static void handleButtonRelease(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {

            AORenderer.camera.isMoving = false;
        }
    }

    public Position getLastPosition() {
        return lastPostion;
    }

    public Boolean getMoving() {
        return isMoving;
    }
}
