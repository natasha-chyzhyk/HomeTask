package com.natasha.sourceit.task9;

import java.awt.*;

/**
 * Created by Stas on 30.11.2016.
 */
public abstract class BaseMonster extends BaseCharacter implements Monster, Movable {
    protected int attackPower;
    private int maxMoveDistance;
    private int attackDistance;
    private Point coordinates;

    public BaseMonster(int health, int attackPower, int maxMoveDistance) {
        this(health, attackPower, maxMoveDistance, 1);
    }

    public BaseMonster(int health, int attackPower, int maxMoveDistance, int attackDistance) {
        super(health);
        this.attackPower = attackPower;
        this.maxMoveDistance = maxMoveDistance;
        this.attackDistance = attackDistance;
    }

    @Override
    public final boolean canDoAction(CharacterAction action) {
        if(canFly(action.getActionTarget()) && ! canFly(this)) {
            return false;
        }
        return true;
    }

    public final void attack(Character character) {
        getAttack(character).doAction();
    }

    protected abstract CharacterAction getAttack(Character character);

    public final void moveTo(Point point) {
        this.coordinates = point;
    }

    public final boolean canMoveTo(Point point) {
        if(this.coordinates == null) {
            return true;
        } else {
            return this.coordinates.distance(point.getX(), point.getY()) < this.maxMoveDistance;
        }
    }

    @Override
    public int getAttackDistance() {
        return this.attackDistance;
    }

    @Override
    public Point getPosition() {
        return this.coordinates;
    }
}
