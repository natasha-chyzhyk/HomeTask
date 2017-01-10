package com.natasha.sourceit.game.character.impl;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.action.AttackType;
import com.natasha.sourceit.game.character.BaseMovableMonster;
import com.natasha.sourceit.game.character.Swimming;

import java.awt.*;

/**
 * Final implementation of the Warrior character
 */
public final class Warrior extends BaseMovableMonster implements Swimming {

    public Warrior(int health, int attackPower){
        super(health, attackPower);
    }

    public Warrior(int health, int attackPower, Point position){
        super(health, attackPower, position);
    }

    @Override
    public char getCharCode() {
        return 'W';
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    protected Attack getAttack() {
        return new Attack(getAttackPower(), AttackType.POWER);
    }
}
