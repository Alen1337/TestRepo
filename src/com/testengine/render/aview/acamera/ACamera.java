package com.testengine.render.aview.acamera;

import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.InputKey;

import javax.swing.*;
import java.awt.event.MouseEvent;

public abstract class ACamera {
    protected Transform transform;
    protected float scale;
    public ACamera(Transform transform) {
        this.transform = transform;
    }

    public Transform getTransform() {
        return transform;
    }
    public float getScale() {
        return scale;
    }
    public float getX() { return  transform.getPosition().getX(); }
    public float getY() { return transform.getPosition().getY(); }

    public abstract void handleButtonPress(MouseEvent e);
    public abstract void handleButtonClick(MouseEvent e);
    public abstract void handleButtonRelease(MouseEvent e);
    public abstract void handleKeyPress(InputKey inputKey);
    public abstract void handleKeyRelease(InputKey inputKey);
    public abstract void update(float dt);
}
