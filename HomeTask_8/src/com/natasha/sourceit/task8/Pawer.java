package com.natasha.sourceit.task8;

/**
 * Created by Stas on 09.11.2016.
 */
public class Pawer extends GonochnyCar implements Flying, AsphaltLaying{

    public Pawer(float weight){
        super(weight);
    }

    public void ride(){
        System.out.println("Pawer is rides");
    }

    public void doSomething(){
        System.out.println("Pawer can drives");
    }

    public void fly(){
        System.out.println("Pawer can fly");
    }

    public void asphaltLaying(){
        System.out.println("Pawer can be laid asphalt");
    }
}
