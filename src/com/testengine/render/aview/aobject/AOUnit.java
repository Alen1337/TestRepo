package com.testengine.render.aview.aobject;

import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.unit.UnitType;
import com.testengine.game.object.utils.Transform;
import com.testengine.utils.Debug;

import java.awt.*;

import static com.testengine.render.aview.aobject.AORenderer.camera;

public class AOUnit {
    private static float HEALTH_BAR_WIDTH = 80;
    private static float HEALTH_BAR_HEIGHT = 20;

    public static void render(Graphics g, Unit unit) {
        if(unit.getUnitType() == UnitType.SMALL) renderSmallUnit(g, unit);
        return;
    }

    private static void renderSmallUnit(Graphics g, Unit unit) {
        Transform u = unit.getTransform();
        Transform c = camera.getTransform();

        g.setColor(Color.BLUE);
        g.fillRect((int)u.getPosition().getX()+ (int)c.getPosition().getX(), (int)u.getPosition().getY() + (int)c.getPosition().getY(),
                (int)u.getPosition().getWidth(),(int)u.getPosition().getHeight());

        renderUnitHealthBar(g, unit);
        renderUnitName(g, unit);
    }

    private static void renderUnitName(Graphics g, Unit unit) {
        Transform u = unit.getTransform();
        Transform c = camera.getTransform();
        Font font = new Font("Courier", Font.PLAIN, 20);
        FontMetrics metrics = g.getFontMetrics(font);
        String text = "SmallUnit";
        int x = (int)u.getPosition().getX() + (((int)u.getPosition().getWidth() / 2)) - metrics.stringWidth(text) / 2;
        int y = (int)u.getPosition().getY() - 30;
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text, x + (int)c.getPosition().getX(), y + (int)c.getPosition().getY());
    }

    private static void renderUnitHealthBar(Graphics g, Unit unit) {
        Transform u = unit.getTransform();
        Transform c = camera.getTransform();
        int x = (int)(((int)u.getPosition().getX() + (int)u.getPosition().getWidth() / 2) - HEALTH_BAR_WIDTH / 2);
        int y = (int)u.getPosition().getY() - 25;
        g.setColor(Color.BLACK);
        g.fillRect(x + (int)c.getPosition().getX(), y + (int)c.getPosition().getY(), (int)HEALTH_BAR_WIDTH, (int)HEALTH_BAR_HEIGHT);

        if(unit.getUnitStat().getHealth() > 0) {
            if(unit.getUnitStat().getArmor() > 0) {
                int allHealth = (int)unit.getUnitStat().getHealth() + (int)unit.getUnitStat().getArmor() + (int)unit.getUnitStat().getShield();
                int hWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getHealth()));
                int aWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getArmor()));
                int sWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getShield()));
                g.setColor(Color.green);
                g.fillRect(x+2  + (int)c.getPosition().getX(), y+2  + (int)c.getPosition().getY(), hWidth-4, (int)HEALTH_BAR_HEIGHT-4);
                g.setColor(Color.YELLOW);
                g.fillRect(x + hWidth  + (int)c.getPosition().getX(), y+2  + (int)c.getPosition().getY(), aWidth-2, (int)HEALTH_BAR_HEIGHT-4);
                if(unit.getUnitStat().getShield() > 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x + hWidth + aWidth  + (int)c.getPosition().getX(), y+2  + (int)c.getPosition().getY(), sWidth-2, (int)HEALTH_BAR_HEIGHT-4);
                }
            } else {
                g.setColor(Color.green);
                g.fillRect(x+2  + (int)c.getPosition().getX(), y+2 + (int)c.getPosition().getY(), (int)(HEALTH_BAR_WIDTH * unit.getUnitStat().getHealth() / unit.getUnitStat().getMaxHealth()) -4, (int)HEALTH_BAR_HEIGHT-4);
            }
        }



    }

}
