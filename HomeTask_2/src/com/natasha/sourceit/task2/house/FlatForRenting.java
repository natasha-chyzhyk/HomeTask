package com.natasha.sourceit.task2.house;

import com.natasha.sourceit.task2.house.room.Room;

/**
 * Created by Stas on 08.10.2016.
 */
public class FlatForRenting extends Flat{
    private float price;
    private int minPeriod;

    public FlatForRenting(Room[] rooms, float price, int minPeriod){
        super(rooms);
        this.price = price;
        this.minPeriod = minPeriod;
    }

    public void rent(){
        System.out.println("Flat rented: "+ price + "on minimum period" +minPeriod);
    }

    public void rented(){
        System.out.println("Flat is sold: "+ price + "on minimum period" +minPeriod);
    }
}
