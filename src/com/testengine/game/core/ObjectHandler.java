package com.testengine.game.core;

import com.testengine.game.object.core.GameObject;
import com.testengine.game.object.core.ObjectType;
import com.testengine.game.object.core.PlayerBasement;
import com.testengine.game.object.shot.Shot;
import com.testengine.game.object.tower.core.AttackTower;
import com.testengine.game.object.tower.core.Tower;
import com.testengine.game.object.tower.core.TowerType;
import com.testengine.game.object.tower.species.SingleShotTower;
import com.testengine.game.object.unit.Unit;
import com.testengine.utils.Debug;

import java.util.ArrayList;

public class ObjectHandler {
    public static void update(ArrayList<GameObject> gameObjects, float dt) {
        for(int i = 0;i< gameObjects.size();i++) {
            if     (gameObjects.get(i).getObjectType() == ObjectType.TOWER) {
                towerUpdate((Tower)gameObjects.get(i), gameObjects);
            }
            else if(gameObjects.get(i).getObjectType() == ObjectType.UNIT) {
                unitUpdate((Unit)gameObjects.get(i), gameObjects, dt);
            }
            else if(gameObjects.get(i).getObjectType() == ObjectType.SHOT) {
                shotUpdate((Shot)gameObjects.get(i), gameObjects, dt);
            }
            else if(gameObjects.get(i).getObjectType() == ObjectType.PLAYER_BASE) {
                playerBaseUpdate((PlayerBasement)gameObjects.get(i), gameObjects);
            }
        }
    }

    private static void towerUpdate(Tower tower, ArrayList<GameObject> gameObjects) {
        if(tower.getTowerType() == TowerType.SINGLE_SHOT && ((AttackTower)tower).isSearchingForTarget()) {
            for(int i = 0;i<gameObjects.size();i++) {
                if(gameObjects.get(i).getObjectType() == ObjectType.UNIT && tower.getTransform().getDistanceFrom(gameObjects.get(i).getTransform()) < tower.getRange()) {
                    ((SingleShotTower)tower).setTargetUnit((Unit)gameObjects.get(i));
                    return;
                }
            }
        }
    }

    private static void unitUpdate(Unit unit, ArrayList<GameObject> gameObjects, float dt) {
        unit.updateMovement(dt);
        for(int i = 0;i<gameObjects.size();i++) {
            if(gameObjects.get(i).getObjectType() == ObjectType.PLAYER_BASE && gameObjects.get(i).getTransform().getDistanceFrom(unit.getTransform()) < 5) {
                ((PlayerBasement)gameObjects.get(i)).setCurrentHealth(((PlayerBasement)gameObjects.get(i)).getCurrentHealth()-1);
                removeUnit(unit, gameObjects);
            }
        }
    }

    private static void shotUpdate(Shot shot, ArrayList<GameObject> gameObjects, float dt) {
        shot.updateMovement(dt);
        shot.calcVelocity();

        if(shot.getTowerFrom().getTowerType() == TowerType.SINGLE_SHOT) {
            for(int i = 0;i<gameObjects.size();i++) {
                if(gameObjects.get(i).getObjectType() == ObjectType.UNIT && gameObjects.get(i).getTransform().getDistanceFrom(shot.getTransform()) < 5) {
                    Debug.LogCombat(shot.getTarget().getUnitType() + "_UNIT stats before the shot: " + shot.getTarget().getUnitStat().getHealth() + " " + shot.getTarget().getUnitStat().getArmor() + " " + shot.getTarget().getUnitStat().getShield());
                    shot.getTarget().getUnitStat().takeDMG(shot.getDamage());
                    if(shot.getTarget().getUnitStat().getHealth() < 1) {
                        removeUnit(shot.getTarget(), gameObjects);
                    }
                    gameObjects.remove(shot);
                    Debug.LogCombat("[" + shot.getTowerFrom().getTowerType() + "_SHOT_OBJECT] Hitted " + shot.getTarget().getUnitType() + "_UNIT!");
                    Debug.LogRemoveObject(shot.getObjectType() + "Successfully removed!");
                    Debug.LogCombat(shot.getTarget().getUnitType() + "_UNIT stats after the shot: " + shot.getTarget().getUnitStat().getHealth() + " " + shot.getTarget().getUnitStat().getArmor() + " " + shot.getTarget().getUnitStat().getShield());
                }
            }
        }

    }

    private static void playerBaseUpdate(PlayerBasement playerBasement, ArrayList<GameObject> gameObjects) {

    }

    private static void removeUnit(Unit unit, ArrayList<GameObject> gameObjects) {
        for(int j = 0;j< gameObjects.size();j++) {
            if(gameObjects.get(j).getObjectType() == ObjectType.TOWER) {
                if(((Tower)gameObjects.get(j)).getTowerType() == TowerType.SINGLE_SHOT && ((SingleShotTower)gameObjects.get(j)).getTargetUnit() == unit) {
                    ((SingleShotTower)gameObjects.get(j)).clearTargetUnit();
                }
            }
        }
        unit.onDestroy();
        Debug.LogRemoveObject("[" + unit.getUnitType() + "_UNIT" + Debug.SUCCESS_GAMEOBJECT_DESTROY);
        gameObjects.remove((Object)unit);
    }
}
