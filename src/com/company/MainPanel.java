package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {
    public MainPanel(int width, int height) {
        super();
        setPreferredSize(new Dimension(width, height));

        initKeyActions();
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
                //MainHandler.getInputHandler().onKeyPress(InputKey.D);
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
            }
        });
    }

    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        draw(grphcs);
    }

    protected void draw(Graphics g) {

    }

}
