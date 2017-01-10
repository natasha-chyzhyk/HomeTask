package com.natasha.sourceit.game.move;

import com.natasha.sourceit.game.character.Locatable;


/**
 * Define objects which can move. The 'position' property is inherited
 * from the Locatable.
 * These objects also support 'direction' and 'speed' property
 *
 * The 'speed' is INVERSE value. For example, for seed = 1 an object moves each game cycle
 * for speed=3 an object moves every 3-d game cycle.
 *
 */
public interface Movable extends Locatable {

    /**
     * Movable objects cannot move in some cases (dead for example)
     * @return
     */
    boolean canMove();

    /**
     * Teleport an object to exact location
     * @param x
     * @param y
     */
    void moveToPosition(int x, int y);

    /**
     * Move an object a single step, based on its current speed and direction
     * @param mvr
     * @return
     */
    boolean moveOneStep(Mover mvr);

    /**
     * Current speed of an object
     * @return
     */
    int getSpeed();

    /**
     * Current direction on a object
     * @return
     */
    Direction getDirection();
}