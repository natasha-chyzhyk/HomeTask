package com.natasha.sourceit.task11;

/**
 * Created by Stas on 08.11.2016.
 */
public abstract class GruzCar extends Car {
    private float maxLiftWeight;

    public GruzCar(float weight, float maxLiftWeight){
        super(weight);
        this.maxLiftWeight = maxLiftWeight;
    }

    public float getMaxLiftWeight() {
        return maxLiftWeight;
    }
}
