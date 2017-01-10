package com.natasha.sourceit.game.move;

import java.awt.*;

/**
 * Interface which assists character to move.
 * It knows a game map and location of other characters
 */
public interface Mover {

    /**
     * Checks of not wall in the requested position
     * @param x
     * @param y
     * @return
     */
    boolean isPositionAvailable(int x, int y);

    /**
     * Checks is an enemy in the requested position
     * @param mObj
     * @return
     */
    boolean isEnemyNear(Movable mObj);

    /**
     * Gives set of available directions from a position and moving direction
     * @param currentPosition
     * @param currentDirection
     * @return
     */
    DirectionOption[] getAvailableDirections(Point currentPosition, Direction currentDirection);
}