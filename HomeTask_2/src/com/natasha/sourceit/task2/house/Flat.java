package com.natasha.sourceit.task2.house;

import com.natasha.sourceit.task2.house.room.Room;
import com.natasha.sourceit.task2.house.room.RoomLiving;

/**
 * Created by Stas on 08.10.2016.
 */
public class Flat {
    private  Room[] rooms;

    public  Flat(Room... rooms) {
        setRooms(rooms);
    }

    public void setRooms(Room... rooms){
        // Это плохо, потому что не соответствует принципу инкапсуляции
        //this.rooms = rooms;

        if(rooms != null) {
            this.rooms = new Room[rooms.length];
            System.arraycopy(rooms, 0, this.rooms, 0, rooms.length);
        }else {
            this.rooms = null;
        }
    }
    /**
     * Тоже плохо. Не соответствует принципу инкапсуляции
     * @return
     */
    public Room[] getRooms() {
        return rooms;
    }

    public Room getRoom(int index){
        if(rooms != null){
            return (index>=0 && index<rooms.length) ? rooms[index] : null;
        }else{
            return null;
        }
    }
    public float getTotalSquare() {
        float square =0;
        if (rooms != null) {
            for (Room r : rooms) {
                square += r.getSquare();
            }
        }
        return square;
    }

    public float getLivingSquare(){
        float square = 0;
        if (rooms != null) {
            for (Room r : rooms) {
                if (r instanceof RoomLiving) {
                    square += r.getSquare();
                }
            }
        }
        return square;
    }
}
