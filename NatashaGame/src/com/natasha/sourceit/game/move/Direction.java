package com.natasha.sourceit.game.move;

/**
 * Set of supported directions with {dx, dy} - deltas to change position when move a single step!
 */
public enum Direction {
    DIR_N(0, -1), DIR_NE(1, -1), DIR_E(1, 0), DIR_SE(1, 1), DIR_S(0, 1), DIR_SW(-1, 1), DIR_W(-1, 0), DIR_NW(-1, -1);

    private int dx, dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}
