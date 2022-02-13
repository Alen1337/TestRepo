package com.testengine;

import com.testengine.game.core.GameEventHandler;
import com.testengine.game.core.GameMain;
import com.testengine.game.core.RenderEventHandler;
import com.testengine.render.core.Window;
import com.testengine.utils.Debug;

import static com.testengine.utils.Debug.*;

public class Main {

    public static void main(String[] args) {
        Debug.Log(START_APPLICATION);

        Window window = new Window("Test Window",600,300,700,600);
        RenderEventHandler.setWindow(window);

        GameMain gameMain = new GameMain();
        GameEventHandler.setGame(gameMain);



        Debug.Log(SUCCESS_APPLICATION_START);
    }
}
