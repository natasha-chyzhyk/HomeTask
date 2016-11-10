package com.natasha.sourceit.task11;

/**
 * Created by Stas on 09.11.2016.
 */
public class Samosval extends GruzCar{
    private float currentGruz;

    public Samosval(float weight, float maxLiftWeight, float currentGruz) {
        super(weight, maxLiftWeight);
        this.currentGruz = currentGruz;
    }

    public void ride(){
        System.out.println("Samosval can ride");
    }

    public float loadMore(float moreWeight) throws OverLoadException{
        System.out.println("Samosval uploaded " + moreWeight);
        currentGruz += moreWeight;
        if (currentGruz > getMaxLiftWeight()) {
            throw new OverLoadException(this);
        }

        return currentGruz;
    }

    public float checkGrus(){
        System.out.println("Samosval have load = " + currentGruz);
        return currentGruz;
    }

    public float unload(){
        System.out.println("Samosval unloaded");
        //float a = currentGruz;
        //currentGruz = 0;
        //return a;

        try {
            return currentGruz;
        } finally {
            currentGruz = 0;
        }

    }
}
