package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public class Pig extends BaseMonster implements Npc{
    public Pig(int health, int attackPower, int maxMoveDistance) {
        super(health, attackPower, maxMoveDistance);
    }

    @Override
    protected CharacterAction getAttack(Character character) {
        return new MaleAttack(character, attackPower);
    }
}
