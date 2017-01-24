package com.natasha.sourceit.task_jdbc1.model;


import java.util.List;

/**
 * Created by Stas on 18.01.2017.
 */
public class RoomDbModel extends BaseDbModel {

    private String number;
    private int floor;
    private int amount;
    private SchoolDbModel school;

    public RoomDbModel(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("Room:{id=%d, number=%s, floor=%d, amount=%d, school=%s}", getId(), number, floor, amount, school);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public SchoolDbModel getSchool() {
        return school;
    }

    public void setSchool(SchoolDbModel school) {
        this.school = school;
    }

}
