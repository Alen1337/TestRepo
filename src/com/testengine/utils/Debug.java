package com.testengine.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug {
    //STARTING_MESSAGES
    public static String START_WINDOW_CREATION = "[WINDOW] Creating window...";
    public static String START_APPLICATION = "[APP] Starting application...";
    public static String START_MENUSCENE_CREATION = "[MENUSCENE] Creating MenuScene...";

    //SUCCESS_MESSAGES
    public static String SUCCESS_WINDOW_CREATION = "[WINDOW] Window succesfully created!";
    public static String SUCCESS_APPLICATION_CLOSE = "[APP] Successfully closed!";
    public static String SUCCESS_APPLICATION_START = "[APP] Successfully started!";
    public static String SUCCESS_MENUSCENE_CREATION = "[MENUSCENE] MenuScene successfully created!";
    public static String SUCCESS_GAMESCENE_CREATION = "[GAMESCENE] GameScene successfully created!";
    public static String SUCCESS_GAMEHANDLER_CONNECTION = "[GAMEHANDLER] Game is successfully connected to GameHandler!";
    public static String SUCCESS_RENDERHANDLER_CONNECTION = "[RENDERHANDLER] Window is successfully connected to RenderHandler!";
    public static String SUCCESS_SCENE_CONNECTION_TO_RENDERER = "SCENE] Successfully loaded to the renderer!";
    //ERROR_MESSAGES
    public static String ERROR_WINDOW_CREATION = "[ERROR][WINDOW] Some error ocoured while loading the window!";



    //Settings
    public static Boolean BasicMode = true;
    public static Boolean InputMode = true;
    static SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

    public static void Log(String message) {
        if(BasicMode) {
            System.out.println(getTime() +  " [BASIC] - " + message);
        }
    }
    public static void LogInput(String message) {
        if(InputMode) {
            System.out.println(getTime() +  " [INPUT] - " + message);
        }
    }

    private static String getTime() {
        Date date = new Date();
        return formatter.format(date);
    }
}