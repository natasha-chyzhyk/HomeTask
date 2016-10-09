package com.natasha.sourceit.task2.cupboard;

/**
 * Created by Stas on 06.10.2016.
 */
public abstract class Box {
    private int volume;
    private Handle handle;

    public Box(int volume, Handle handle) {
        this.volume = volume;
        this.handle = handle;
    }

    public abstract void push();
    public abstract void pull();

    public int getVolume() {
        return volume;
    }

    public Handle getHandle() {
        return handle;
    }
}
