package com.natasha.sourceit.task2.cupboard;

/**
 * Created by Stas on 06.10.2016.
 */
public class Door {
    private float width;
    private float height;
    private Handle handle;
    private Material material;

    public Door(float w, float h, Material material) {
        width = w;
        height = h;
        this.material = material;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }
}
