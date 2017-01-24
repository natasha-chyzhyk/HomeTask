package com.natasha.sourceit.task_jdbc1.model;


/**
 * Created by Stas on 18.01.2017.
 */
public class SubjectDbModel extends com.natasha.sourceit.task_jdbc.model.BaseDbModel {

    private String name;
    private RoomDbModel room;

    @Override
    public String toString() {
        return String.format("Subject:{id=%d, name=%s, room_id=%s}", getId(), name, room);
    }

    public SubjectDbModel(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomDbModel getRoom() {
        return room;
    }

    public void setRoom(RoomDbModel room) {
        this.room = room;
    }
}
