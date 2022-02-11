package com.testengine.render.aview.amenu;

import com.testengine.render.aview.abutton.core.ABType;

public abstract class AMenu {
    private int x;
    private int y;
    private int width;
    private int height;

    public AMenu(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
