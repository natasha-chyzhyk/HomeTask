package com.natasha.sourceit.game.character;

/**
 * General character interface which supports Health feature and Alive status
 */
public interface Character {

    int getHealth();
    boolean isAlive();
    boolean canMove();
    void modifyHealth(int val);

}
