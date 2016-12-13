package com.natasha.sourceit.task9;

import java.awt.*;

/**
 * Created by Stas on 30.11.2016.
 */
public interface Movable {
    void moveTo(Point point);
    boolean canMoveTo(Point point);
    Point getPosition();
}
