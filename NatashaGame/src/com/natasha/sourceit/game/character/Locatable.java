package com.natasha.sourceit.game.character;

import java.awt.*;

/**
 * This interface defines a Type has Location property.
 * But this location cannot be changed after creation
 */
public interface Locatable {

    /**
     * Current position of an object
     * @return
     */
    Point getPosition();

    /**
     * This method can be called only once for each instance.
     * MOre calls result in IllegalStateException
     * @param position
     */
    void initPositionOnce(Point position);
}
