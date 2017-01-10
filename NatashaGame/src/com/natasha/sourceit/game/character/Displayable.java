package com.natasha.sourceit.game.character;

import com.natasha.sourceit.game.drawing.DrawingSurface;

import java.awt.*;

/**
 * Definition of classes which can be shown on display
 */
public interface Displayable extends Locatable {

    /**
     * Draw an object on screen
     * @param sf
     * @param playgroundOffset
     */
    void drawOnMap(DrawingSurface sf, Point playgroundOffset);

    /**
     * An object returns the symbol which is used to display
     * itself on screen
     * @return
     */
    char getCharCode();
}
