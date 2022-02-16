package com.testengine.game.core;

import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneHandler;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.acamera.ACHandler;
import com.testengine.render.aview.aobject.AOHandler;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.testengine.utils.Debug.START_MENUSCENE_CREATION;


public class GameMain {
    private Timer newFrameTimer;
    private Scene mainScene;
    private float fps;
    private float outFPS;
    private Timer fpsTimer;
    long last_time = System.nanoTime();

    public GameMain() {
        mainScene = SceneHandler.getStartScene();
        RenderEventHandler.loadScene(mainScene);
        newFrameTimer = new Timer(0, new NewFrameListener());
        newFrameTimer.start();
        outFPS = 0;

        fpsTimer = new Timer(250, new FPSTimeListener());
        fpsTimer.start();

    }

    private void update() {
        long time = System.nanoTime();
        int dt = (int) ((time - last_time) / 1000000);
        last_time = time;
        fps = dt;

        mainScene.update(dt);
        RenderEventHandler.update(dt);
    }

    class FPSTimeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            outFPS = fps;
        }
    }
    class NewFrameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            update();
        }
    }


    public Scene getMainScene() { return this.mainScene; }





    public void onMouseClick(int x, int y) {
        Debug.LogInput("Mouse clicked at x:" + x + " y: " + y);
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public float getFps() {
        return outFPS;
    }
}
