package com.natasha.sourceit.task_jdbc.model;

/**
 * Created by Stas on 17.01.2017.
 */
public class SubjectDbModel extends BaseDbModel{

    private String name;
    private int room_id;

    @Override
    public String toString() {
        return String.format("Subject:{id=%d, name=%s, room_id=%d}", getId(), name, room_id);
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

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
