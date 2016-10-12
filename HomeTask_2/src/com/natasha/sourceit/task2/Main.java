package com.natasha.sourceit.task2;

import com.natasha.sourceit.task2.cupboard.Cupboard;
import com.natasha.sourceit.task2.cupboard.Door;
import com.natasha.sourceit.task2.cupboard.Material;
import com.natasha.sourceit.task2.house.Flat;
import com.natasha.sourceit.task2.house.Home;
import com.natasha.sourceit.task2.house.room.*;

public class Main {

    public static void main(String[] args) {
        Cupboard cupboard = new Cupboard();
        cupboard.setDoors(new Door(1.5f, 1.2f, Material.WOOD), new Door(2.2f, 1.2f, Material.DSP), new Door(2.5f, 1.5f, Material.GLASS));

        cupboard.setDoors(new Door[]{ new Door(2.5f, 1.2f, Material.WOOD), new Door(2.5f, 1, Material.WOOD), new Door(2.5f, 1.2f, Material.WOOD)});

        for (int i=0; i<cupboard.getDoorsNumber(); i++) {
            System.out.println("Высота "+i+" двери шкафа: " +cupboard.getDoor(i).getHeight()+ " ширина: " +cupboard.getDoor(i).getWidth());
        }

        Home home = new Home();
        home.setCommonUsingSquare(25000);
        Flat[] flats = new Flat[3];
        flats[0] = createDoubleRoomFlat();
        flats[1] = createOneRoomFlat();
        flats[2] = createTreeRoomFlat();
        home.setFlats(flats);

        System.out.println("--------------------------------");
        System.out.println("Общая площадь дома составляет " + home.getTotalSquare() + " кв.м, общая площадь квартир - " +home.getFlatTotalSquare()+ ", жилая площадь - " +home.getLivingSquare()+ " кв.м.");

    }


    private static Flat createOneRoomFlat() {
        Room[] room = new Room[4];
        room[0] = new Bathroom(6f, 2.8f);
        room[1] = new BedRoom(19f, 2.8f);
        room[2] = new Kitchen(10f, 2.8f);
        room[3] = new Corridor(12f, 2.8f);
        Flat flat = new Flat(room);
        return flat;
    }

    private static Flat createDoubleRoomFlat() {
        Room[] room = new Room[5];
        room[0] = new Bathroom(6f, 2.8f);
        room[1] = new BedRoom(19f, 2.8f);
        room[2] = new BedRoom(27f, 2.8f);
        room[3] = new Kitchen(10f, 2.8f);
        room[4] = new Corridor(12f, 2.8f);
        Flat flat = new Flat(room);
        return flat;
    }

    private static Flat createTreeRoomFlat() {
        Room[] room = new Room[6];
        room[0] = new Bathroom(6f, 2.8f);
        room[1] = new BedRoom(19f, 2.8f);
        room[2] = new BedRoom(27f, 2.8f);
        room[3] = new BedRoom(25f, 2.8f);
        room[4] = new Kitchen(10f, 2.8f);
        room[5] = new Corridor(12f, 2.8f);
        Flat flat = new Flat(room);
        return flat;
    }

}
