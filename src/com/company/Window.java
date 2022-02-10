package com.company;

import javax.swing.*;
import java.awt.*;

import static com.company.Debug.START_WINDOW_CREATION;
import static com.company.Debug.SUCCESS_WINDOW_CREATION;

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

}
