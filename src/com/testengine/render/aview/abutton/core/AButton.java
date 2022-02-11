package com.testengine.render.aview.abutton.core;

public abstract class AButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private ABType buttonType;

    public AButton(int x, int y, int width, int height, ABType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonType = type;
    }

    public Boolean isClicked(int clickedX, int clickedY) {
        return (clickedX >= this.x && clickedX <= this.x + this.width) && (clickedY >= this.y && clickedY <= this.y + this.height);
    }

    public abstract void onClick();
}
