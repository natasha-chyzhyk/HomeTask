package com.natasha.sourceit.game.drawing;

import java.awt.*;

/**
 * Display abstraction where other parts on the program can draw something
 */
public interface DrawingSurface {
    int getWidth();
    int getHeight();

    /************************  These methods draw on virtual screen  *******************************/
    void draw(Point position, char ch);
    void draw(int left, int top, char ch);
    void drawHorizontalLine(int left, int top, char[] src, int srcStart, int srcEnd);
    void drawVerticalLine(int left, int top, char[] src, int srcStart, int srcEnd);
    void clear();

    /**
     * This method translates content created on virtual screen (video memory) to phisical screen
     */
    void printOnScreen();

    /**
     * Clears fisical screen
     */
    void clearScreen();
}

