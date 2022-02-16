package com.testengine.render.aview.ascene;

import com.testengine.game.core.RenderEventHandler;
import com.testengine.game.object.utils.Position;
import com.testengine.render.aview.acamera.ACamera;
import com.testengine.utils.InputKey;

import java.awt.*;
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
    public abstract void onKeyRelease(InputKey inputKey);
    public abstract void onDestroy();
    public Position getMousePositionInGame() {
        Point p = RenderEventHandler.getWindow().getMainPanel().getMousePosition();
        if(p != null) {
            int rX = p.x;
            int rY = p.y;

            int mouseX = rX;
            int mouseY = rY;
            int inGameX = mouseX - (int)camera.getX();
            int inGameY = mouseY - (int)camera.getY();
            return new Position((float)inGameX,(float)inGameY,0,0);
        }
        return null;
    }
}
