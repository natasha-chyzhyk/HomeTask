package com.natasha.sourceit.game.character.impl;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.action.AttackType;
import com.natasha.sourceit.game.character.*;

import java.awt.*;

/**
 * Final implementation of the Pig character
 */
public class Pig extends BaseMovableMonster{

    public Pig(int health, int attackPower){
        super(health, attackPower);
    }

    public Pig(int health, int attackPower, Point position){
        super(health, attackPower, position);
    }

    @Override
    public char getCharCode() {
        return 'P';
    }

    @Override
    public int getSpeed() {
        return 2;
    }

    @Override
    protected Attack getAttack() {
        return new Attack(getAttackPower(), AttackType.SMELLY);
    }
}
