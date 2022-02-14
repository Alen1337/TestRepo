package com.testengine.render.aview.agui;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.scene.SceneType;

import java.awt.*;

public class AGFps {
    public static void render(Graphics g) {
        if(GameEventHandler.getGameMain() != null && GameEventHandler.getMainScene().getSceneType() == SceneType.GAME) {
            g.setColor(Color.BLACK);
            g.drawString("FPS: " + (int)(1000 / GameEventHandler.getGameMain().getFps()), 20, 20);
            g.drawString("FrameTime: " + GameEventHandler.getGameMain().getFps() + " ms", 20, 40);
        }

    }
}
