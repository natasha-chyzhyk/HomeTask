package com.natasha.sourceit.task8;

/**
 * Created by Stas on 08.11.2016.
 */
public class RallyCar extends GonochnyCar {

    public RallyCar(float weight){
        super(weight);
    }

    public void ride(){
        System.out.println("RallyCar is rides");
    }

    public void doSomething(){
        System.out.println("RallyCar can drives");
    }
}
