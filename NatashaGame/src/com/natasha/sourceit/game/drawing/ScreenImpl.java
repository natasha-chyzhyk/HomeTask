package com.natasha.sourceit.game.drawing;

import java.awt.*;
import java.io.IOException;

/**
 * The implementation of the DrawingSurface. See comments there!!!
 */
public class ScreenImpl implements DrawingSurface {

    private int width, height;

    /**
     * The video memory!!!!!!!!!!!!!!!!
     */
    private char[][] cells;

    public ScreenImpl(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new char[height][width];
        clear();
    }

    @Override
    public void clear() {
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Point position, char ch) {
        if ((position.x >= 0 && position.x < width) && (position.y >= 0 && position.y < height)) {
            cells[position.y][position.x] = ch;
        }
    }

    @Override
    public void draw(int left, int top, char ch) {
        if ((left >= 0 && left < width) && (top >= 0 && top < height)) {
            cells[top][left] = ch;
        }
    }

    @Override
    public void drawHorizontalLine(int left, int top, char[] src, int srcStart, int srcEnd) {
        if (top < 0 || top >= height) return;
        for (int i=srcStart; i<srcEnd; i++, left++) {
            if (left<0 || left >= width) return;
            cells[top][left] = src[i];
        }
    }

    @Override
    public void drawVerticalLine(int left, int top, char[] src, int srcStart, int srcEnd) {
        if (left<0 || left >= width) return;
        for (int i=srcStart; i<srcEnd; i++, top++) {
            if (top < 0 || top >= height) return;
            cells[top][left] = src[i];
        }
    }

    @Override
    public void printOnScreen() {
        clearScreen();
        for(int i=0; i<height; i++) {
            System.out.println(new String(cells[i]));
        }
    }

    @Override
    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}