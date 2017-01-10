package com.natasha.sourceit.game.character;

/**
 * Interface for Monster which is the Character which can attack other characters
 */
public interface Monster extends Character{
    void attack(Character character);
    int getAttackPower();
}
