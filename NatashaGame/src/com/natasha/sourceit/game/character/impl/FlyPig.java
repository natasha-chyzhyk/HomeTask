package com.natasha.sourceit.game.character.impl;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.action.AttackType;
import com.natasha.sourceit.game.character.BaseMovableMonster;
import com.natasha.sourceit.game.character.Flying;

import java.awt.*;

/**
 * Final implementation of the Pig which can fly
 */
public final class FlyPig extends Pig implements Flying {

    public FlyPig(int health, int attackPower){
        super(health, attackPower);
    }

    public FlyPig(int health, int attackPower, Point position){
        super(health, attackPower, position);
    }


    @Override
    public char getCharCode() {
        return 'F';
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    protected Attack getAttack() {
        return new Attack(getAttackPower(), AttackType.REMOTE);
    }
}
