package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public abstract class BaseAttack implements CharacterAction {
    private Character targetCharacter;
    protected int attackPower;

    public BaseAttack(Character targetCharacter, int attackPower) {
        this.targetCharacter = targetCharacter;
        this.attackPower = attackPower;
    }
    @Override
    public final Character getActionTarget() {
        return this.targetCharacter;
    }

    public abstract AttackType getAttackType();

    public void doAction(){
        this.targetCharacter.modifyHealth(-this.attackPower);
    }
}
