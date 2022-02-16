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
    public static String SUCCESS_MAIN_MENU_NEW_GAME_BUTTON_CLICKED = "[MAINMENU] New Game button clicked!";
    public static String SUCCESS_MAIN_MENU_LOAD_GAME_BUTTON_CLICKED = "[MAINMENU] Load Game button clicked!";
    public static String SUCCESS_MAIN_MENU_SETTINGS_BUTTON_CLICKED = "[MAINMENU] Settings button clicked!";
    public static String SUCCESS_MAIN_MENU_EXIT_BUTTON_CLICKED = "[MAINMENU] Exit button clicked!";
    public static String SUCCESS_GAMEOBJECT_TOWER_CREATION = "_TOWER] Successfully created!";
    public static String SUCCESS_GAMEOBJECT_UNIT_CREATION = "_UNIT] Successfully created!";
    public static String SUCCESS_GAMEOBJECT_SHOT_CREATION = "_SHOT] Successfully created!";
    public static String SUCCESS_GAMEOBJECT_DESTROY = "_OBJECT] Successfully destroyed!";
    //ERROR_MESSAGES
    public static String ERROR_WINDOW_CREATION = "[ERROR][WINDOW] Some error ocoured while loading the window!";
    public static String ERROR_CALC_SHOT_VELOCITY = "[ERROR] Some error ocoured while calculating the shot's velocity!";

    //else
    public static String BUILD_MODE_ON = "[GAMEMODE] Building mode on!";
    public static String BUILD_MODE_OFF = "[GAMEMODE] Building mode off!";



    //Settings
    public static Boolean BasicMode = true;
    public static Boolean InputMode = true;
    public static Boolean CombatMode = false;
    public static Boolean GameObjectMode = true;
    public static Boolean GameObjectRemoveMode = false;
    public static Boolean GameObjectCreateMode = false;

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
    public static void LogCombat(String message) {
        if(CombatMode) {
            System.out.println(getTime() +  " [COMBAT] - " + message);
        }
    }

    public static void LogObject(String message) {
        if(GameObjectMode) {
            System.out.println(getTime() +  " [GAMEOBJECT] - " + message);
        }
    }

    public static void LogCreateObject(String message) {
        if(GameObjectCreateMode) {
            System.out.println(getTime() +  " [GAMEOBJECT_CREATE] - " + message);
        }
    }

    public static void LogRemoveObject(String message) {
        if(GameObjectRemoveMode) {
            System.out.println(getTime() +  " [GAMEOBJECT_REMOVE] - " + message);
        }
    }


    private static String getTime() {
        Date date = new Date();
        return formatter.format(date);
    }
}
