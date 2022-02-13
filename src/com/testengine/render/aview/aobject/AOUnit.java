package com.testengine.render.aview.aobject;

import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.unit.UnitType;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.Debug;

import java.awt.*;

public class AOUnit {
    public static void render(Graphics g, Unit unit) {
        if(unit.getUnitType() == UnitType.SMALL) renderSmallUnit(g, unit);
        return;
    }

    private static void renderSmallUnit(Graphics g, Unit unit) {
        Transform u = unit.getTransform();

        g.setColor(Color.BLUE);
        g.fillRect((int)u.getPosition().getX(), (int)u.getPosition().getY(),
                (int)u.getPosition().getWidth(),(int)u.getPosition().getHeight());

        renderUnitName(g, unit);
    }

    private static void renderUnitName(Graphics g, Unit unit) {
        Transform u = unit.getTransform();
        Font font = new Font("Courier", Font.PLAIN, 20);
        FontMetrics metrics = g.getFontMetrics(font);
        String text = "SmallUnit";
        int x = (int)u.getPosition().getX() + (((int)u.getPosition().getWidth() / 2)) - metrics.stringWidth(text) / 2;
        int y = (int)u.getPosition().getY() - 20;
        g.setFont(font);
        g.drawString(text, x, y);
    }

}
