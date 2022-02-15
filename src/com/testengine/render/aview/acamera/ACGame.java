package com.testengine.render.aview.acamera;

import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.render.aview.aobject.AOHandler;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ACGame extends ACamera {
    private Boolean isMoving;
    private Position lastPostion;
    public ACGame(Transform transform) {
        super(transform);
        isMoving = false;
        lastPostion = new Position(0,0,transform.getPosition().getWidth(),transform.getPosition().getHeight());
    }

    public Transform getTransform() {
        return transform;
    }

    public float getScale() {
        return scale;
    }

    @Override
    public void handleButtonPress(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            lastPostion.setX(transform.getPosition().getX());
            lastPostion.setY(transform.getPosition().getY());
            isMoving = true;
        }
    }

    @Override
    public void handleButtonClick(MouseEvent e) {

    }

    @Override
    public void handleButtonRelease(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {

            isMoving = false;
        }
    }

    public Position getLastPosition() {
        return lastPostion;
    }

    public Boolean getMoving() {
        return isMoving;
    }


}
