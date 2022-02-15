package com.testengine.render.core;

import com.testengine.render.aview.agui.AGFps;
import com.testengine.render.aview.aobject.AOHandler;
import com.testengine.utils.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {

    public MainPanel(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));

        initKeyActions();
        addMouseListener(new MouseEvents());

        AOHandler.setRenderPanel(this);
    }

    public class MouseEvents implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            ViewSceneHandler.handleMouseClick(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ViewSceneHandler.handleMousePress(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ViewSceneHandler.handleMouseRelease(e);
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
                ViewSceneHandler.getRenderScene().onKeyPress(InputKey.D);
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
                ViewSceneHandler.getRenderScene().onKeyPress(InputKey.SPACE);
            }
        });
    }


    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        AOHandler.render(grphcs);
        AGFps.render(grphcs);
    }


}
