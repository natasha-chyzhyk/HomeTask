package com.natasha.sourceit.game.character.impl;

import com.natasha.sourceit.game.action.Attack;
import com.natasha.sourceit.game.action.AttackType;
import com.natasha.sourceit.game.character.BaseMovableMonster;

import java.awt.*;

/**
 * Created by Stas on 12.01.2017.
 */
public final class FinalCharacter extends BaseMovableMonster{

    private FinalCharacterType characterType;

    public FinalCharacter(int health, int attackPower, FinalCharacterType characterType){
        super(health, attackPower);
        this.characterType = characterType;
    }

    public FinalCharacter(int health, int attackPower, Point position, FinalCharacterType characterType){

        super(health, attackPower, position);
        this.characterType = characterType;
    }

    @Override
    protected Attack getAttack() {
        return new Attack(getAttackPower(), characterType.getType());
    }

    @Override
    public char getCharCode() {
        return characterType.getCode();
    }

    @Override
    public int getSpeed() {
        return characterType.getSpeed();
    }

    public enum FinalCharacterType{
        ANGEL(AttackType.MAGIC, 1, 'A'), FLYPIG(AttackType.REMOTE, 1, 'F'), PIG(AttackType.SMELLY, 2, 'P'), WARRIOR(AttackType.POWER, 3, 'W');
        private AttackType type;
        private int speed;
        private char code;

        private FinalCharacterType(AttackType type, int speed, char code){
            this.type = type;
            this.speed = speed;
            this.code = code;
        }

        public AttackType getType(){
            return type;
        }

        public int getSpeed() {
            return speed;
        }

        public char getCode(){
            return code;
        }
    }
}
