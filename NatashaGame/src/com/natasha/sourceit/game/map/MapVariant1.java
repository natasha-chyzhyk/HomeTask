package com.natasha.sourceit.game.map;

import com.natasha.sourceit.game.drawing.DrawingSurface;
import com.natasha.sourceit.game.drawing.DrawingUtils;

import java.awt.*;
import java.util.Random;

/**
 * An implementation of the GAME MAP
 */
public class MapVariant1 implements GameField {
    private int playW = 46;
    private int playH = 26;
    private int drawingW = 50;
    private int drawingH = 30;

    private static final char[] markers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * Walls definition
     */
    private boolean[][] map = new boolean[][]{
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, true,  true,  true,  true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, true,  true,  true,  true,  true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true,  false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
            {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
    };

    @Override
    public Point getDrawingSize() {
        return new Point(drawingW, drawingH);
    }


    @Override
    public Point getPlaygroundSize() {
        return new Point(playW, playH);
    }

    @Override
    public int getPlaygroundW() {
        return playW;
    }

    @Override
    public int getPlaygroundH() {
        return playH;
    }

    @Override
    public Point getPlaygroundOffset() {
        return new Point(2, 2);
    }

    @Override
    public boolean isPositionFree(Point p) {
        return isPositionFree(p.x, p.y);
    }

    @Override
    public boolean isPositionFree(int x, int y) {
        try {
            return !map[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public void addWall(Point position) {
        map[position.y][position.x] = true;
    }

    private Random rnd = new Random();
    @Override
    public Point getRandomFreePosition() {
        int x, y;
        do {
            x = rnd.nextInt(playW);
            y = rnd.nextInt(playH);
        } while (map[y][x]);
        return new Point(x, y);
    }



    private static final char BORDER_HORIZONTAL = DrawingUtils.ASCII_205;
    private static final char BORDER_VERTICAL = DrawingUtils.ASCII_186;
    private static final char CORNER_LEFT_TOP = DrawingUtils.ASCII_201;
    private static final char CORNER_RIGHT_TOP = DrawingUtils.ASCII_187;
    private static final char CORNER_RIGHT_BOT = DrawingUtils.ASCII_188;
    private static final char CORNER_LEFT_BOT = DrawingUtils.ASCII_200;
    private static final char DRAWING_WALL_SYMBOL = DrawingUtils.ASCII_219;


    @Override
    public void drawSelf(DrawingSurface sf) {

        //---  Draw corners  ---
        sf.draw(1, 1, CORNER_LEFT_TOP);
        sf.draw(1+playW+1, 1, CORNER_RIGHT_TOP);
        sf.draw(1+playW+1, 1+playH+1, CORNER_RIGHT_BOT);
        sf.draw(1, 1+playH+1, CORNER_LEFT_BOT);

        //---  Drow horizontal borders  ---
        for(int i=2; i<drawingW-2; i++) {
            sf.draw(i, 1, BORDER_HORIZONTAL);
            sf.draw(i, 2+playH, BORDER_HORIZONTAL);
        }

        //---  Draw vertical borders  ----
        for(int i=2; i<drawingH-2; i++) {
            sf.draw(1, i, BORDER_VERTICAL);
            sf.draw(2+playW, i, BORDER_VERTICAL);
        }

        //---  Draw horizontal marks ---
        sf.drawHorizontalLine(2, 0, markers, 0, playW);
        sf.drawHorizontalLine(2, playH+3, markers, 0, playW);


        //--- Draw vertical marks ---
        sf.drawVerticalLine(0, 2, markers, 0, playH);
        sf.drawVerticalLine(playW+3, 2, markers, 0, playH);

        //---  Draw playground map ---
        for (int j=0; j<playH; j++) {
            drawLine(sf, j, 2, 2+j);
        }

    }


    /**
     * Draw single line of playground map
     * @param sf Instance of the DrawingSurface to draw on
     * @param lineIndex row index in the map
     * @param startX X-coordinate of start point on DrawingSurface
     * @param startY Y-coordinate of start point on DrawingSurface
     */
    private void drawLine(DrawingSurface sf, int lineIndex, int startX, int startY) {
        boolean[] line = map[lineIndex];
        for (int i=0; i<line.length; i++) {
            if (line[i]) {
                sf.draw(startX + i, startY, DRAWING_WALL_SYMBOL);
            }
        }
    }




}

