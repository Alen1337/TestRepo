package com.testengine.render.aview.aobject;

import com.testengine.game.object.game.core.BuildTile;
import com.testengine.game.object.utils.Transform;

import java.awt.*;

public class AOBuildTile {
    public static void render(Graphics g, BuildTile buildTile, Transform camera) {
        Transform bt = buildTile.getTransform();
        g.setColor(Color.GREEN);
        g.drawRect((int)bt.getPosition().getX() + (int)camera.getPosition().getX(), (int)bt.getPosition().getY() + (int)camera.getPosition().getY(),
                (int)bt.getPosition().getWidth(),(int)bt.getPosition().getHeight());
    }
}
