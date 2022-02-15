package com.testengine.render.aview.acamera;

import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;

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

    public abstract void handleButtonPress(MouseEvent e);
    public abstract void handleButtonClick(MouseEvent e);
    public abstract void handleButtonRelease(MouseEvent e);
}
