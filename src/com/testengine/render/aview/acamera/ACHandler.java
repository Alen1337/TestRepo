package com.testengine.render.aview.acamera;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.game.scene.SceneType;
import com.testengine.render.core.ViewSceneHandler;
import com.testengine.utils.Debug;

import java.awt.*;

public class ACHandler {
    public static void handleCamera() {
        if(GameEventHandler.getMainSceneType() == SceneType.GAME) {
            handleGameCameraGrabAndMove();
        }
    }
    private static void handleGameCameraGrabAndMove() {

        if(GameEventHandler.getMainSceneType() == SceneType.GAME) {
            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            ACGame gameCamera = (ACGame)ViewSceneHandler.getCamera();
            if(gameCamera != null && gameCamera.getMoving()) {

                float mousePosX = ((float)b.getX() - RenderEventHandler.getWindowX());
                float mousePosY = ((float)b.getY() - RenderEventHandler.getWindowY());
                float nowPosX = gameCamera.getTransform().getPosition().getX();
                float nowPosY = gameCamera.getTransform().getPosition().getY();
                float lastPosX = nowPosX;
                float lastPosY = nowPosY;

                float width = gameCamera.getTransform().getPosition().getWidth();
                float height = gameCamera.getTransform().getPosition().getHeight();


                Debug.LogInput("Camera x: " + gameCamera.getTransform().getPosition().getX() + " y:" + gameCamera.getTransform().getPosition().getY());
                if(mousePosX != lastPosX) {
                    gameCamera.getTransform().getPosition().setX(mousePosX - gameCamera.getLastPosition().getX());
                }
                if(mousePosX != lastPosX) {
                    gameCamera.getTransform().getPosition().setY(mousePosY - gameCamera.getLastPosition().getX());
                }



            }
        }
    }


}
