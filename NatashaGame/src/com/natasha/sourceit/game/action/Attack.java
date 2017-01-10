package com.natasha.sourceit.game.action;

import com.natasha.sourceit.game.character.*;
import com.natasha.sourceit.game.character.Character;

import java.util.Random;

public class Attack implements CharacterAction {
    private int attackPower;
    private AttackType attackType;


    public Attack(int attackPower, AttackType attackType) {
        this.attackPower = attackPower;
        this.attackType = attackType;
    }

    public void doAction(Character character){

        int dHelth = 0;

        //--- Check attack type to make a decision. Add some randome behavior ----
        switch (attackType) {
            case POWER:
                if (character instanceof Flying){
                    System.out.println("Attack does not work");
                }else {
                    dHelth = attackPower;
                }
                break;
            case SMELLY:
                if (character instanceof Flying){
                    System.out.println("Attack does not work");
                }else {
                    Random gen = new Random();
                    float p = gen.nextFloat() * (1-0.7f) + 0.7f;
                    dHelth = Math.round(attackPower * p);
                }
                break;
            case MAGIC:
                dHelth = (character instanceof Flying) ? Math.round(attackPower * 0.5f) : attackPower;
                break;
            case REMOTE:
                Random gen = new Random();
                float p = gen.nextFloat() * (1 - 0.5f) + 0.5f;
                dHelth = Math.round(attackPower * p);
        }

        character.modifyHealth(-dHelth);
    }
}
