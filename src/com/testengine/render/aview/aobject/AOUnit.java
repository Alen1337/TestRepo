package com.testengine.render.aview.aobject;

import com.testengine.game.object.game.unit.Unit;
import com.testengine.game.object.game.unit.UnitType;
import com.testengine.game.object.utils.Transform;

import java.awt.*;


public class AOUnit {
    private static float HEALTH_BAR_WIDTH = 80;
    private static float HEALTH_BAR_HEIGHT = 20;

    public static void render(Graphics g, Unit unit, Transform camera) {
        if(unit.getUnitType() == UnitType.SMALL) renderSmallUnit(g, unit, camera);
        return;
    }

    private static void renderSmallUnit(Graphics g, Unit unit, Transform camera) {
        Transform u = unit.getTransform();

        g.setColor(Color.BLUE);
        g.fillRect((int)u.getPosition().getX()+ (int)camera.getPosition().getX(), (int)u.getPosition().getY() + (int)camera.getPosition().getY(),
                (int)u.getPosition().getWidth(),(int)u.getPosition().getHeight());

        renderUnitHealthBar(g, unit, camera);
        renderUnitName(g, unit, camera);
    }

    private static void renderUnitName(Graphics g, Unit unit, Transform camera) {
        Transform u = unit.getTransform();

        Font font = new Font("Courier", Font.PLAIN, 20);
        FontMetrics metrics = g.getFontMetrics(font);
        String text = "SmallUnit";
        int x = (int)u.getPosition().getX() + (((int)u.getPosition().getWidth() / 2)) - metrics.stringWidth(text) / 2;
        int y = (int)u.getPosition().getY() - 30;
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text, x + (int)camera.getPosition().getX(), y + (int)camera.getPosition().getY());
    }

    private static void renderUnitHealthBar(Graphics g, Unit unit, Transform camera) {
        Transform u = unit.getTransform();

        int x = (int)(((int)u.getPosition().getX() + (int)u.getPosition().getWidth() / 2) - HEALTH_BAR_WIDTH / 2);
        int y = (int)u.getPosition().getY() - 25;
        g.setColor(Color.BLACK);
        g.fillRect(x + (int)camera.getPosition().getX(), y + (int)camera.getPosition().getY(), (int)HEALTH_BAR_WIDTH, (int)HEALTH_BAR_HEIGHT);

        if(unit.getUnitStat().getHealth() > 0) {
            if(unit.getUnitStat().getArmor() > 0) {
                int allHealth = (int)unit.getUnitStat().getHealth() + (int)unit.getUnitStat().getArmor() + (int)unit.getUnitStat().getShield();
                int hWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getHealth()));
                int aWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getArmor()));
                int sWidth = (int)(HEALTH_BAR_WIDTH / (allHealth / unit.getUnitStat().getShield()));
                g.setColor(Color.green);
                g.fillRect(x+2  + (int)camera.getPosition().getX(), y+2  + (int)camera.getPosition().getY(), hWidth-4, (int)HEALTH_BAR_HEIGHT-4);
                g.setColor(Color.YELLOW);
                g.fillRect(x + hWidth  + (int)camera.getPosition().getX(), y+2  + (int)camera.getPosition().getY(), aWidth-2, (int)HEALTH_BAR_HEIGHT-4);
                if(unit.getUnitStat().getShield() > 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x + hWidth + aWidth  + (int)camera.getPosition().getX(), y+2  + (int)camera.getPosition().getY(), sWidth-2, (int)HEALTH_BAR_HEIGHT-4);
                }
            } else {
                g.setColor(Color.green);
                g.fillRect(x+2  + (int)camera.getPosition().getX(), y+2 + (int)camera.getPosition().getY(), (int)(HEALTH_BAR_WIDTH * unit.getUnitStat().getHealth() / unit.getUnitStat().getMaxHealth()) -4, (int)HEALTH_BAR_HEIGHT-4);
            }
        }



    }

}
