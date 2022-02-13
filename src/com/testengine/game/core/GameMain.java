package com.testengine.game.core;

import com.testengine.game.scene.GameScene;
import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.testengine.utils.Debug.START_MENUSCENE_CREATION;


public class GameMain {
    private Timer newFrameTimer;
    private Scene mainScene;

    public GameMain() {
        mainScene = getStartScene();
        RenderEventHandler.loadScene(mainScene);
        newFrameTimer = new Timer(0, new NewFrameListener());
        newFrameTimer.start();
    }

    private void update() {
        mainScene.update();
        RenderEventHandler.update();
    }

    class NewFrameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            update();
        }
    }

    private Scene getStartScene() {
        Debug.Log(START_MENUSCENE_CREATION);
        return new MainMenuScene();
    }
    public Scene getMainScene() { return this.mainScene; }

    public void onKeyPress(InputKey inputKey) {
        Debug.LogInput(inputKey + " is pressed!");
        if(inputKey == InputKey.SPACE) {
            mainScene = new GameScene();
            RenderEventHandler.loadScene(mainScene);
        } else if(inputKey == InputKey.D) {
            mainScene = new MainMenuScene();
            RenderEventHandler.loadScene(mainScene);
        }
    }

    public void onMouseClick(int x, int y) {
        Debug.LogInput("Mouse clicked at x:" + x + " y: " + y);
    }
}
