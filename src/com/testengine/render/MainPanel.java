package com.testengine.render;

import com.testengine.game.core.GameHandler;
import com.testengine.game.scene.GameScene;
import com.testengine.game.scene.MenuScene;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
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
            GameHandler.mouseClicked(e);
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
        if(renderScene.getSceneType() == SceneType.MENU) {
            renderMenuScene(g, (MenuScene)renderScene);
        } else if(renderScene.getSceneType() == SceneType.GAME) {
            renderGameScene(g, (GameScene)renderScene);
        }
    }

    private void renderMenuScene(Graphics g, MenuScene scene) {
        /*g.clearRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLUE);
        g.fillRect(getWidth() / 2 - 50, getHeight() / 5 - 50, 100, 40);
        g.setColor(Color.YELLOW);
        g.drawString("Start",getWidth() / 2 - 17,getHeight() / 5 - 25);*/


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
        Debug.Log("[" + scene.getSceneType() + SUCCESS_SCENE_CONNECTION_TO_RENDERER);
    }

}
