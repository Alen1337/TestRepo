package com.testengine.render.core;

import com.testengine.game.scene.Scene;
import com.testengine.render.core.MainPanel;
import com.testengine.utils.Debug;

import javax.swing.*;
import java.awt.*;

import static com.testengine.utils.Debug.START_WINDOW_CREATION;
import static com.testengine.utils.Debug.SUCCESS_WINDOW_CREATION;

public class Window {
    private final JFrame frame;
    private MainPanel mainPanel;

    public Window(String name, int x, int y, int width, int height) {
        Debug.Log(START_WINDOW_CREATION);

        frame = new JFrame(name);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocation(x,y);
        frame.setPreferredSize(new Dimension(width, height));

        mainPanel = new MainPanel(width, height);
        frame.getContentPane().add(mainPanel);



        frame.pack();
        frame.setVisible(true);

        Debug.Log(SUCCESS_WINDOW_CREATION);
    }

    public void update() {
        mainPanel.update();
    }

    public void setRenderScene(Scene scene) {
        mainPanel.setRenderScene(scene);
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int getHeight() {
        return frame.getHeight();
    }

    public int getX() {
        return frame.getX();

    }

    public int getY() {
        return frame.getY();
    }

}
