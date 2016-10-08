package com.natasha.sourceit.task2.house.room;

import com.natasha.sourceit.task2.house.items.Window;

public abstract class Room {
    private float square;
    private float height;
    private Window[] windows;

    public Room(float square, float height) {
        this.square = square;
        this.height = height;
    }

    public float getHeight() {
        return height;
    }

    public float getSquare() {
        return square;
    }
}
