package com.testengine.render.aview.aobject;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.SpriteHandler;
import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.tower.core.Tower;
import com.testengine.game.object.unit.Unit;
import com.testengine.game.scene.GameScene;
import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.core.ViewSceneHandler;

import javax.swing.*;
import java.awt.*;

public class AORenderer {
    private static JPanel renderPanel;
    public static void renderView(Graphics g) {
        if(GameEventHandler.getGameMain() != null) {
            if (GameEventHandler.getMainSceneType() == SceneType.MAINMENU) {
                renderMenuScene(g, (MainMenuScene) GameEventHandler.getMainScene());
            } else if (GameEventHandler.getMainSceneType() == SceneType.GAME) {
                renderGameScene(g, (GameScene) GameEventHandler.getMainScene());
            }
        }
    }
    private static void renderMenuScene(Graphics g, MainMenuScene scene) {
        g.drawImage(SpriteHandler.MAIN_MENU_NEW_GAME_BUTTON,
                ViewSceneHandler.MainMenuSceneView.getNewGameButton().getX(),
                ViewSceneHandler.MainMenuSceneView.getNewGameButton().getY(),
                ViewSceneHandler.MainMenuSceneView.getNewGameButton().getWidth(),
                ViewSceneHandler.MainMenuSceneView.getNewGameButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_LOAD_GAME_BUTTON,
                ViewSceneHandler.MainMenuSceneView.getLoadGameButton().getX(),
                ViewSceneHandler.MainMenuSceneView.getLoadGameButton().getY(),
                ViewSceneHandler.MainMenuSceneView.getLoadGameButton().getWidth(),
                ViewSceneHandler.MainMenuSceneView.getLoadGameButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_SETTINGS_BUTTON,
                ViewSceneHandler.MainMenuSceneView.getSettingsButton().getX(),
                ViewSceneHandler.MainMenuSceneView.getSettingsButton().getY(),
                ViewSceneHandler.MainMenuSceneView.getSettingsButton().getWidth(),
                ViewSceneHandler.MainMenuSceneView.getSettingsButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_EXIT_BUTTON,
                ViewSceneHandler.MainMenuSceneView.getExitButton().getX(),
                ViewSceneHandler.MainMenuSceneView.getExitButton().getY(),
                ViewSceneHandler.MainMenuSceneView.getExitButton().getWidth(),
                ViewSceneHandler.MainMenuSceneView.getExitButton().getHeight(), null);
    }

    private static void renderGameScene(Graphics g, GameScene scene) {
        for(int i = 0; i < scene.getGameObjects().size();i++) {
            GameObject object = scene.getGameObjects().get(i);
            renderObject(g, object);
        }

    }

    private static void renderObject(Graphics g, GameObject object) {
        if(object.getObjectType() == ObjectType.UNIT) AOUnit.render(g,(Unit)object);
        else if(object.getObjectType() == ObjectType.TOWER) AOTower.render(g,(Tower)object);
        return;
    }



    public static void setRenderPanel(JPanel renderPanel) {
        AORenderer.renderPanel = renderPanel;
    }

}
