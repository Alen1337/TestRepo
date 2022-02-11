package com.testengine;

import com.testengine.game.core.GameHandler;
import com.testengine.game.core.GameMain;
import com.testengine.game.core.RenderHandler;
import com.testengine.render.Window;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.*;

public class Main {

    public static void main(String[] args) {
        Debug.Log(START_APPLICATION);

        Window window = new Window("Test Window",600,300,700,600);
        RenderHandler.setWindow(window);

        GameMain gameMain = new GameMain();
        GameHandler.setGame(gameMain);



        Debug.Log(SUCCESS_APPLICATION_START);
    }
}
