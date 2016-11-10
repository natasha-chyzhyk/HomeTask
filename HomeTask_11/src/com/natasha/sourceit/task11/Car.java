package com.natasha.sourceit.task11;

/**
 * Created by Stas on 08.11.2016.
 */
public abstract class Car {
    private float weight;

    public Car(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String toString(){
        return getClass().getSimpleName();
    }
    public abstract void ride();
}
