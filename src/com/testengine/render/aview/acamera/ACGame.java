package com.testengine.render.aview.acamera;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.game.object.utils.Position;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.scene.SceneType;
import com.testengine.render.core.ViewSceneHandler;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ACGame extends ACamera {
    private float movingSpeed = 1;

    public ACGame(Transform transform) {
        super(transform);
    }

    public Transform getTransform() {
        return transform;
    }

    public float getScale() {
        return scale;
    }

    @Override
    public void handleButtonPress(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {
            
        }
    }

    @Override
    public void handleButtonClick(MouseEvent e) {

    }

    @Override
    public void handleButtonRelease(MouseEvent e) {
        if(SwingUtilities.isRightMouseButton(e)) {


        }
    }

    @Override
    public void handleKeyPress(InputKey inputKey) {
        if(inputKey == InputKey.w) {
            onKeyPress_w();
        } else if(inputKey == InputKey.a) {
            onKeyPress_a();
        } else if(inputKey == InputKey.s) {
            onKeyPress_s();
        } else if(inputKey == InputKey.d) {
            onKeyPress_d();
        }
    }

    @Override
    public void handleKeyRelease(InputKey inputKey) {
        if(inputKey == InputKey.w) {
            onKeyRelease_w();
        } else if(inputKey == InputKey.a) {
            onKeyRelease_a();
        } else if(inputKey == InputKey.s) {
            onKeyRelease_s();
        } else if(inputKey == InputKey.d) {
            onKeyRelease_d();
        }
    }

    @Override
    public void update(float dt) {
        transform.update(dt);
    }


    private void onKeyPress_w() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(movingSpeed);
    }
    private void onKeyPress_a() {
        transform.getVelocity().setX(movingSpeed);
        transform.getVelocity().setY(0);
    }
    private void onKeyPress_s() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(-movingSpeed);
    }
    private void onKeyPress_d() {
        transform.getVelocity().setX(-movingSpeed);
        transform.getVelocity().setY(0);
    }

    private void onKeyRelease_w() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(0);
    }

    private void onKeyRelease_a() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(0);
    }

    private void onKeyRelease_s() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(0);
    }

    private void onKeyRelease_d() {
        transform.getVelocity().setX(0);
        transform.getVelocity().setY(0);
    }


}
