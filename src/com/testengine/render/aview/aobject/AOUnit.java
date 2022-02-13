package com.testengine.render.aview.aobject;

import com.testengine.game.object.unit.Unit;
import com.testengine.game.object.unit.UnitType;

import java.awt.*;

public class AOUnit {
    public static void render(Graphics g, Unit unit) {
        if(unit.getUnitType() == UnitType.SMALL) renderSmallUnit(g, unit);
        return;
    }

    private static void renderSmallUnit(Graphics g, Unit unit) {

    }

}
