package com.testengine.render;

import com.testengine.game.core.GameHandler;
import com.testengine.game.core.SpriteHandler;
import com.testengine.game.scene.GameScene;
import com.testengine.game.scene.MainMenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.amenu.AMMainMenu;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.testengine.utils.Debug.SUCCESS_SCENE_CONNECTION_TO_RENDERER;

public class MainPanel extends JPanel {
    private Scene renderScene;

    public MainPanel(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));

        initKeyActions();
        addMouseListener(new MouseEvents());
    }

    public class MouseEvents implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

            if(renderScene.getSceneType() == SceneType.MAINMENU) {
                if(ViewSceneHandler.MainMenuSceneView.getExitButton().isClicked(e.getX(),e.getY())) {
                    ViewSceneHandler.MainMenuSceneView.getExitButton().onClick();
                }
                else if(ViewSceneHandler.MainMenuSceneView.getNewGameButton().isClicked(e.getX(),e.getY())) {
                    ViewSceneHandler.MainMenuSceneView.getNewGameButton().onClick();
                }
                else if(ViewSceneHandler.MainMenuSceneView.getLoadGameButton().isClicked(e.getX(),e.getY())) {
                    ViewSceneHandler.MainMenuSceneView.getLoadGameButton().onClick();
                }
                else if(ViewSceneHandler.MainMenuSceneView.getSettingsButton().isClicked(e.getX(),e.getY())) {
                    ViewSceneHandler.MainMenuSceneView.getSettingsButton().onClick();
                } else {
                    GameHandler.mouseClicked(e);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private void initKeyActions() {
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //MainHandler.getInputHandler().onKeyPress(InputKey.A);
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GameHandler.keyPressed(InputKey.D);
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //MainHandler.getInputHandler().onKeyPress(InputKey.S);
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //MainHandler.getInputHandler().onKeyPress(InputKey.W);
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //MainHandler.getInputHandler().onKeyPress(InputKey.ESCAPE);
            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
        this.getActionMap().put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //MainHandler.getInputHandler().onKeyPress(InputKey.SPACE);
                GameHandler.keyPressed(InputKey.SPACE);
            }
        });
    }


    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        renderer(grphcs);
    }

    protected void renderer(Graphics g) {
        if(renderScene.getSceneType() == SceneType.MAINMENU) {
            renderMenuScene(g, (MainMenuScene)renderScene);
        } else if(renderScene.getSceneType() == SceneType.GAME) {
            renderGameScene(g, (GameScene)renderScene);
        }
    }

    private void renderMenuScene(Graphics g, MainMenuScene scene) {
        /*g.clearRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLUE);
        g.fillRect(getWidth() / 2 - 50, getHeight() / 5 - 50, 100, 40);
        g.setColor(Color.YELLOW);
        g.drawString("Start",getWidth() / 2 - 17,getHeight() / 5 - 25);*/
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

    private void renderGameScene(Graphics g, GameScene scene) {
        g.clearRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLUE);
        g.fillRect(getWidth() / 2 - 50, getHeight() / 5 - 50, 100, 40);
        g.setColor(Color.YELLOW);
        g.drawString("Back to Menu",getWidth() / 2 - 35,getHeight() / 5 - 25);
    }

    public void setRenderScene(Scene scene) {
        renderScene = scene;
        if(scene.getSceneType() == SceneType.MAINMENU) {
            ViewSceneHandler.clear();
            ViewSceneHandler.MainMenuSceneView = new AMMainMenu(0,0,this.getWidth(),this.getHeight());
        } else if(scene.getSceneType() == SceneType.GAME) {
            ViewSceneHandler.clear();
        }
        Debug.Log("[" + scene.getSceneType() + SUCCESS_SCENE_CONNECTION_TO_RENDERER);
    }

}
