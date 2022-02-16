package com.testengine.render.core;

import com.testengine.render.aview.agui.AGFps;
import com.testengine.render.aview.aobject.AOHandler;
import com.testengine.utils.Debug;
import com.testengine.utils.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {

    public MainPanel(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));

        initKeyActions();
        addMouseListener(new MouseEvents());
        addKeyListener(new KeyEvents());

        AOHandler.setRenderPanel(this);
    }

    private class MouseEvents implements MouseListener {
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
    private class KeyEvents implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar() == 'd') {
                ViewSceneHandler.handleKeyPress(InputKey.d);
            } else if(e.getKeyChar() == 'a') {
                ViewSceneHandler.handleKeyPress(InputKey.a);
            } else if(e.getKeyChar() == 's') {
                ViewSceneHandler.handleKeyPress(InputKey.s);
            } else if(e.getKeyChar() == 'w') {
                ViewSceneHandler.handleKeyPress(InputKey.w);
            } else if(e.getKeyChar() == '\u001B') {
                ViewSceneHandler.handleKeyPress(InputKey.ESCAPE);
            } else if(e.getKeyChar() == ' ') {
                ViewSceneHandler.handleKeyPress(InputKey.SPACE);
            } else if(e.getKeyChar() == 'b') {
                ViewSceneHandler.handleKeyPress(InputKey.b);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() == 'd') {
                ViewSceneHandler.handleKeyRelease(InputKey.d);
            } else if(e.getKeyChar() == 'a') {
                ViewSceneHandler.handleKeyRelease(InputKey.a);
            } else if(e.getKeyChar() == 's') {
                ViewSceneHandler.handleKeyRelease(InputKey.s);
            } else if(e.getKeyChar() == 'w') {
                ViewSceneHandler.handleKeyRelease(InputKey.w);
            } else if(e.getKeyChar() == '\u001B') {
                ViewSceneHandler.handleKeyRelease(InputKey.ESCAPE);
            } else if(e.getKeyChar() == ' ') {
                ViewSceneHandler.handleKeyRelease(InputKey.SPACE);
            } else if(e.getKeyChar() == 'b') {
                ViewSceneHandler.handleKeyRelease(InputKey.b);
            }
        }
    }
    private void initKeyActions() {
        this.getInputMap().put(KeyStroke.getKeyStroke("A"), "pressed left");
        this.getActionMap().put("pressed left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "pressed right");
        this.getActionMap().put("pressed right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("S"), "pressed down");
        this.getActionMap().put("pressed down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "pressed up");
        this.getActionMap().put("pressed up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
        this.getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
        this.getActionMap().put("space", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        this.getInputMap().put(KeyStroke.getKeyStroke("B"), "b");
        this.getActionMap().put("b", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {

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
