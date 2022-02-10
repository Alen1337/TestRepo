package com.company;

import javax.swing.*;
import java.awt.*;

public class Window {
    private final JFrame frame;
    private MainPanel mainPanel;

    public Window(String name, int x, int y, int width, int height) {
        frame = new JFrame(name);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocation(x,y);
        frame.setPreferredSize(new Dimension(width, height));

        mainPanel = new MainPanel(width, height);
        frame.getContentPane().add(mainPanel);



        frame.pack();
        frame.setVisible(true);
    }

}
