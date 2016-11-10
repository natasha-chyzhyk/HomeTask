package com.natasha.sourceit.task11;

/**
 * Created by Stas on 08.11.2016.
 */
public class TrackCar extends GonochnyCar {

    public TrackCar(float weight){
        super(weight);
    }

    public void ride(){
        System.out.println("Trackcar is rides");
    }

    public void doSomething(){
        System.out.println("Trackcar can drives");
    }
}
