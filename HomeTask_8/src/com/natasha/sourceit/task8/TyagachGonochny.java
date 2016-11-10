package com.natasha.sourceit.task8;

/**
 * Created by Stas on 08.11.2016.
 */
public class TyagachGonochny extends Tyagach<GonochnyCar> {

    public TyagachGonochny(float weight, float maxLiftWeight){
        super(weight, maxLiftWeight);
    }

    public void pull(GonochnyCar car){
            car.doSomething();
            System.out.println("pull gonochny car - " + car);
    }

    public void ride(){
        System.out.println("TyagachGonochny can ride");
    }
}
