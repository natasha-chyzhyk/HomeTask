package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public class FlyPig extends Pig implements Flying{
    public FlyPig(int health, int attackPower, int maxMoveDistance) {
        super(health, attackPower, maxMoveDistance);
    }

    @Override
    protected CharacterAction getAttack(Character character) {
        return new RangeAttack(character, this.attackPower);
    }
}
