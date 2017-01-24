package com.natasha.sourceit.task_jdbc.model;

import com.natasha.sourceit.task_jdbc1.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 17.01.2017.
 */
public class SchoolDbModel extends BaseDbModel {

    private String address;
    private String number;
    private int floors;
    private final List<RoomDbModel> rooms;

    public SchoolDbModel(int id) {
        super(id);
        rooms = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("School:{id=%d, address=%s, number=%s, floors=%d, rooms=%s}", getId(), address, number, floors, getString(rooms));
    }

    private String getString(List<RoomDbModel> rooms) {
        StringBuilder sb = new StringBuilder('(');
        for (int i=0; i<rooms.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(rooms.get(i));
        }
        sb.append(")");
        return sb.toString();
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

    public List<RoomDbModel> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDbModel> rooms) {
        this.rooms.clear();
        if (rooms != null) {
            this.rooms.addAll(rooms);
        }
    }
}
