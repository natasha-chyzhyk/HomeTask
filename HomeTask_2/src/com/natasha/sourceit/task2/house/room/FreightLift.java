package com.natasha.sourceit.task2.house.room;

import com.natasha.sourceit.task2.house.Lift;

/**
 * Created by Stas on 08.10.2016.
 */
public class FreightLift extends Lift{
    private float bearingCapacity;

    public FreightLift (String mark, float volume, float bearingCapacity){
        super(mark, volume);
        this.bearingCapacity = bearingCapacity;
    }
}
