package com.testengine.render.aview.ascene;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.render.aview.acamera.ACGame;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

public class ASGameScene extends AScene {

    public ASGameScene(int x, int y, int width, int height) {
        super();
        camera = new ACGame(new Transform(new Position(0,0, width, height), new Velocity()));
    }

    @Override
    public void handleMousePress(MouseEvent e) {
        camera.handleButtonPress(e);
    }

    @Override
    public void handleMouseRelease(MouseEvent e) {
        camera.handleButtonRelease(e);
    }

    @Override
    public void handleMouseClick(MouseEvent e) {
        camera.handleButtonClick(e);
    }

    @Override
    public void onKeyPress(InputKey inputKey) {
        Debug.LogInput(inputKey + " is pressed!");
        GameEventHandler.backToMenu();
    }
}
