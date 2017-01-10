package com.natasha.sourceit.game.character.impl;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.action.AttackType;
import com.natasha.sourceit.game.character.BaseMovableMonster;
import com.natasha.sourceit.game.character.Flying;

import java.awt.*;

/**
 * Final implementation of the Angel character
 */
public final class Angel extends BaseMovableMonster implements Flying{

    public Angel(int health, int attackPower){
        super(health, attackPower);
    }

    public Angel(int health, int attackPower, Point position){
        super(health, attackPower, position);
    }

    @Override
    protected Attack getAttack() {
        return new Attack(getAttackPower(), AttackType.MAGIC);
    }

    @Override
    public char getCharCode() {
        return 'A';
    }

    @Override
    public int getSpeed() {
        return 1;
    }
}
