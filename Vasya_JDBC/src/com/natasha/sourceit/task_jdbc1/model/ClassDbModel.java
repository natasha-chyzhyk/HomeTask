package com.natasha.sourceit.task_jdbc1.model;

/**
 * Created by Stas on 18.01.2017.
 */
public class ClassDbModel extends BaseDbModel {

    private String number;
    private RoomDbModel room;

    @Override
    public String toString() {
        return String.format("Class:{id=%d, number=%s, room=%s}", getId(), number, room);
    }

    public ClassDbModel(int id) {
        super(id);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public RoomDbModel getRoom() {
        return room;
    }

    public void setRoom(RoomDbModel room) {
        this.room = room;
    }
}
