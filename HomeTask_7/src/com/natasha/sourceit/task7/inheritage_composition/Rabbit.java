package com.natasha.sourceit.task7.inheritage_composition;

import java.util.Arrays;

/**
 * Created by Stas on 25.10.2016.
 */
public class Rabbit extends Herbivorous{
    public Rabbit(float age, String area, HerbalFood[] supportedFoods){
        super("Rabbit", age, area, supportedFoods);
    }

    @Override
    public void sleep() {
        System.out.println(getName()+" sleep");
    }

    @Override
    public Noise makeNoise() {
        
        return Noise.FYR;
    }

    @Override
    public String toString() {
        return getClass().getName()+": {name="+getName()+", age="+getAge()+", area="+getLivingArea()+", supportedFoods="+ Arrays.toString(getSupportedFood())+"}";
    }
}
