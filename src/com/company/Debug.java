package com.company;

public class Debug {
    //STARTING_MESSAGES
    public static String START_WINDOW_CREATION = "[WINDOW] Creating window...";

    //SUCCESS_MESSAGES
    public static String SUCCESS_WINDOW_CREATION = "[WINDOW] Window succesfully created!";

    //ERROR_MESSAGES
    public static String ERROR_WINDOW_CREATION = "[ERROR][WINDOW] Some error ocoured while loading the window!";


    public static void Log(String message) {
        System.out.println(message);
    }
}
