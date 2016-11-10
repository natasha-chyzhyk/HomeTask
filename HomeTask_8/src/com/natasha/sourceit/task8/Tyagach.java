package com.natasha.sourceit.task8;

/**
 * Created by Stas on 08.11.2016.
 */
public abstract class Tyagach<BLABLA extends Car> extends GruzCar {

    public Tyagach(float weight, float maxLiftWeight){
        super(weight, maxLiftWeight);
    }

    public abstract void pull(BLABLA car);

}
