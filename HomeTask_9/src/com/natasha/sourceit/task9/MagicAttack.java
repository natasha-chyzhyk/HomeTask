package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public class MagicAttack extends BaseAttack{
    public MagicAttack(Character targetCharacter, int attackPower) {
        super(targetCharacter, attackPower);
    }

    @Override
    public AttackType getAttackType() {
        return AttackType.MAGIC;
    }
}
