package com.testengine.render.aview.aobject;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.SpriteHandler;
import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.game.core.BuildTile;
import com.testengine.game.object.game.shot.Shot;
import com.testengine.game.object.game.building.tower.core.Tower;
import com.testengine.game.object.game.unit.Unit;
import com.testengine.game.object.utils.Transform;
import com.testengine.game.scene.GameScene;
import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.ascene.ASMainMenuScene;
import com.testengine.render.core.ViewSceneHandler;

import javax.swing.*;
import java.awt.*;

public class AOHandler {
    private static JPanel renderPanel;

    public static void render(Graphics g) {
        if(GameEventHandler.getGameMain() != null) {
            if (GameEventHandler.getMainSceneType() == SceneType.MAINMENU) {
                renderMenuScene(g, (MainMenuScene) GameEventHandler.getMainScene(), ViewSceneHandler.getCamera().getTransform());
            } else if (GameEventHandler.getMainSceneType() == SceneType.GAME) {
                renderGameScene(g, (GameScene) GameEventHandler.getMainScene(), ViewSceneHandler.getCamera().getTransform());
            }
        }
    }
    private static void renderMenuScene(Graphics g, MainMenuScene scene, Transform camera) {
        ASMainMenuScene renderScene = (ASMainMenuScene) ViewSceneHandler.getRenderScene();

        g.drawImage(SpriteHandler.MAIN_MENU_NEW_GAME_BUTTON,
                renderScene.getMainMenu().getNewGameButton().getX(),
                renderScene.getMainMenu().getNewGameButton().getY(),
                renderScene.getMainMenu().getNewGameButton().getWidth(),
                renderScene.getMainMenu().getNewGameButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_LOAD_GAME_BUTTON,
                renderScene.getMainMenu().getLoadGameButton().getX(),
                renderScene.getMainMenu().getLoadGameButton().getY(),
                renderScene.getMainMenu().getLoadGameButton().getWidth(),
                renderScene.getMainMenu().getLoadGameButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_SETTINGS_BUTTON,
                renderScene.getMainMenu().getSettingsButton().getX(),
                renderScene.getMainMenu().getSettingsButton().getY(),
                renderScene.getMainMenu().getSettingsButton().getWidth(),
                renderScene.getMainMenu().getSettingsButton().getHeight(), null);
        g.drawImage(SpriteHandler.MAIN_MENU_EXIT_BUTTON,
                renderScene.getMainMenu().getExitButton().getX(),
                renderScene.getMainMenu().getExitButton().getY(),
                renderScene.getMainMenu().getExitButton().getWidth(),
                renderScene.getMainMenu().getExitButton().getHeight(), null);
    }

    private static void renderGameScene(Graphics g, GameScene scene, Transform camera) {
        for(int i = 0; i < scene.getGameObjects().size();i++) {
            GameObject object = scene.getGameObjects().get(i);
            renderObject(g, object, camera);
        }

    }

    private static void renderObject(Graphics g, GameObject object, Transform camera) {
        if(object.getObjectType() == ObjectType.UNIT) AOUnit.render(g,(Unit)object, camera);
        else if(object.getObjectType() == ObjectType.TOWER) AOTower.render(g,(Tower)object, camera);
        else if(object.getObjectType() == ObjectType.SHOT) AOShot.render(g,(Shot)object, camera);
        else if(object.getObjectType() == ObjectType.BUILD_TILE) AOBuildTile.render(g,(BuildTile)object, camera);
        return;
    }



    public static void setRenderPanel(JPanel renderPanel) {
        AOHandler.renderPanel = renderPanel;
    }

}
