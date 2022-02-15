package com.testengine.render.aview.ascene;

import com.testengine.render.aview.acamera.ACamera;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

public abstract class AScene {
    protected ACamera camera;
    public AScene() {

    }

    public ACamera getCamera() {
        return camera;
    }

    public abstract void handleMousePress(MouseEvent e);
    public abstract void handleMouseRelease(MouseEvent e);
    public abstract void handleMouseClick(MouseEvent e);
    public abstract void onKeyPress(InputKey inputKey);
    public abstract void onDestroy();
}
