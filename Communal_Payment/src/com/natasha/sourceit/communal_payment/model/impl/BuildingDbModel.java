package com.natasha.sourceit.communal_payment.model.impl;

import com.natasha.sourceit.communal_payment.model.SingleIdDbModel;
import com.natasha.sourceit.communal_payment.model.StreetAddress;

/**
 * Created by Stas on 27.01.2017.
 */
public class BuildingDbModel extends SingleIdDbModel implements StreetAddress {

    private String city;
    private String street;
    private int house;

    public BuildingDbModel(long id, String city, String street, int house) {
        super(id);
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public int getHouse() {
        return this.house;
    }

    @Override
    public String toString() {
        return "[" + city + " " + street + " " + house + "]";
    }
}
