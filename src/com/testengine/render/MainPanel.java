package com.testengine.render;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.game.scene.Scene;
import com.testengine.game.scene.SceneType;
import com.testengine.render.aview.amenu.AMMainMenu;
import com.testengine.render.aview.aobject.AORenderer;
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

        AORenderer.setRenderPanel(this);
    }

    public class MouseEvents implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            RenderEventHandler.handleMouseClick(e);
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
                GameEventHandler.keyPressed(InputKey.D);
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
                GameEventHandler.keyPressed(InputKey.SPACE);
            }
        });
    }


    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        AORenderer.renderView(grphcs);
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
