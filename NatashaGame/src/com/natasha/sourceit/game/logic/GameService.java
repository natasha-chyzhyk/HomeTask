package com.natasha.sourceit.game.logic;

import com.natasha.sourceit.game.character.BaseCharacter;
import com.natasha.sourceit.game.drawing.DrawingSurface;

import java.util.List;

/**
 * Main interface of the game logic
 */
public interface GameService {

    /**
     * PRovide screen for drawing
     * @param surface
     */
    void setDrawingSurface(DrawingSurface surface);

    /**
     * PRovide characters for game and place them on a GAME MAP randomly
     * @param characters
     */
    void populateCharacters(List<BaseCharacter> characters);

    /**
     * Do GAME!!!!!
     */
    void calculateNextStep();

    /**
     * Draw current state of the game - MAP and all characters
     */
    void drawScene();

}
