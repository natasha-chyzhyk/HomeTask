package com.natasha.sourceit.game.map;

import com.natasha.sourceit.game.drawing.DrawingSurface;

import java.awt.*;

/**
 * The interface which defines GAME MAP
 */
public interface GameField {
    Point getDrawingSize();
    Point getPlaygroundSize();

    //-----  Real size of the playground. Must be lower the Drawing size  ------
    int getPlaygroundW();
    int getPlaygroundH();

    /**
     * Offcet of the playground from the whole map (0, 0) position
     * @return
     */
    Point getPlaygroundOffset();

    void addWall(Point position);

    boolean isPositionFree(Point p);
    boolean isPositionFree(int x, int y);

    Point getRandomFreePosition();

    /**
     * Draws this map on screen!!!!!!!
     * @param sf
     */
    void drawSelf(DrawingSurface sf);
}