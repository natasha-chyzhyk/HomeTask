package com.natasha.sourceit.task2.house;

import com.natasha.sourceit.task2.house.Lift;

public class PassengerLift extends Lift {
    private float massRate;

    public PassengerLift (String mark, float volume, float massRate){
        super(mark, volume);
        this.massRate = massRate;
    }
}
