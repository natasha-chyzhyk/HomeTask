package com.natasha.sourceit.task_jdbc1.model;

/**
 * Created by Stas on 18.01.2017.
 */
public class SchoolDbModel extends BaseDbModel {

    private String address;
    private String number;
    private int floors;



    public SchoolDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("School:{id=%d, address=%s, number=%s, floors=%d}", getId(), address, number, floors);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }


}
