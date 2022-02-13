package com.testengine.render.aview.aobject;

import com.testengine.game.object.tower.species.SingleShotTower;
import com.testengine.game.object.tower.core.Tower;
import com.testengine.game.object.tower.core.TowerType;
import com.testengine.game.object.utils.Transform;

import java.awt.*;

public class AOTower {

    public static void render(Graphics g, Tower tower) {
        if(tower.getTowerType() == TowerType.SINGLE_SHOT) {
            renderSingleShot(g, (SingleShotTower)tower);
        } else if(tower.getTowerType() == TowerType.BOMBER) {

        } else if(tower.getTowerType() == TowerType.BUFF) {

        }

        return;
    }

    private static void renderSingleShot(Graphics g, SingleShotTower tower) {
        Transform t = tower.getTransform();

        g.setColor(Color.RED);
        g.fillRect((int)t.getPosition().getX(), (int)t.getPosition().getY(),
                (int)t.getPosition().getWidth(),(int)t.getPosition().getHeight());

        renderTowerName(g, tower);
    }

    private static String getTowerName(Tower tower) {
        if(tower.getTowerType() == TowerType.SINGLE_SHOT) return "SingleShotTower";

        return "TOWER_NAME_ERROR";
    }

    private static void renderTowerName(Graphics g, Tower tower) {
        Transform t = tower.getTransform();
        Font font = new Font("Courier", Font.PLAIN, 20);
        FontMetrics metrics = g.getFontMetrics(font);
        String text = getTowerName(tower) + " [Lvl: " + (int)((SingleShotTower)tower).getAttackTowerStat().getLevel() + "]";
        int x = (int)t.getPosition().getX() + (((int)t.getPosition().getWidth() / 2)) - metrics.stringWidth(text) / 2;
        int y = (int)t.getPosition().getY() - 20;
        g.setFont(font);
        g.drawString(text, x, y);
    }
}
