package com.testengine.game.core;

import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.aobject.AORenderer;
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
        mainScene = getStartScene();
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
        RenderEventHandler.update();
        handleCameraMoving();
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

    private Scene getStartScene() {
        Debug.Log(START_MENUSCENE_CREATION);
        return new MainMenuScene();
    }
    public Scene getMainScene() { return this.mainScene; }

    public void onKeyPress(InputKey inputKey) {
        Debug.LogInput(inputKey + " is pressed!");
        if(inputKey == InputKey.SPACE) {

        } else if(inputKey == InputKey.D) {
            mainScene = new MainMenuScene();
            RenderEventHandler.loadScene(mainScene);
        }
    }

    private static float lastPosX = 0;
    private static float lastPosY = 0;
    public static void handleCameraMoving() {

        if(GameEventHandler.getMainSceneType() == SceneType.GAME) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();

            if(AORenderer.camera.getMoving()) {

                float mousePosX = ((float)b.getX() - RenderEventHandler.getWindowX());
                float mousePosY = ((float)b.getY() - RenderEventHandler.getWindowY());
                float nowPosX = AORenderer.camera.getTransform().getPosition().getX();
                float nowPosY = AORenderer.camera.getTransform().getPosition().getY();
                float lastPosX = nowPosX;
                float lastPosY = nowPosY;

                float width = AORenderer.camera.getTransform().getPosition().getWidth();
                float height = AORenderer.camera.getTransform().getPosition().getHeight();


                Debug.LogInput("Camera x: " + AORenderer.camera.getTransform().getPosition().getX() + " y:" + AORenderer.camera.getTransform().getPosition().getY());
                if(mousePosX != lastPosX) {
                    AORenderer.camera.getTransform().getPosition().setX(mousePosX - AORenderer.camera.getLastPosition().getX());
                }
                if(mousePosX != lastPosX) {
                    AORenderer.camera.getTransform().getPosition().setY(mousePosY - AORenderer.camera.getLastPosition().getX());
                }



            }
        }
    }

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
