package com.testengine.render.aview.ascene;

import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.object.utils.Velocity;
import com.testengine.render.aview.acamera.ACGame;
import com.testengine.render.aview.amenu.AMMainMenu;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import java.awt.event.MouseEvent;

public class ASMainMenuScene extends AScene {
    private AMMainMenu mainMenu;
    public ASMainMenuScene(int x, int y, int width, int height) {
        super();
        mainMenu = new AMMainMenu(x, y, width, height);
        camera = new ACGame(new Transform(new Position(0,0, width, height), new Velocity()));
    }

    @Override
    public void handleMousePress(MouseEvent e) {

    }

    @Override
    public void handleMouseRelease(MouseEvent e) {

    }

    @Override
    public void handleMouseClick(MouseEvent e) {
        mainMenu.handleClick(e);
    }

    @Override
    public void onKeyPress(InputKey inputKey) {
        Debug.LogInput(inputKey + " is pressed!");
    }

    @Override
    public void onKeyRelease(InputKey inputKey) {

    }

    public AMMainMenu getMainMenu() {
        return mainMenu;
    }

    @Override
    public void onDestroy() {

    }
}
