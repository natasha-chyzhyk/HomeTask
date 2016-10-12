package com.natasha.sourceit.task2.house;

import com.natasha.sourceit.task2.house.items.Roof;
import com.natasha.sourceit.task2.house.room.Room;
import javafx.scene.paint.Material;

/**
 * Created by Stas on 08.10.2016.
 */
public class Home {
    private float commonUsingSquare;
    private Flat[] flats;
    private Material material;
    private Roof roof;
    private Lift lifts;

    public void setFlats(Flat... flats) {
        // Ёто плохо, потому что не соответствует принципу инкапсул€ции
        //this.rooms = rooms;

        if (flats != null) {
            this.flats = new Flat[flats.length];
            System.arraycopy(flats, 0, this.flats, 0, flats.length);
        } else {
            this.flats = null;
        }
    }

    public void setCommonUsingSquare(float square) {
        commonUsingSquare = square;
    }

    public  float getTotalSquare(){
        return getFlatTotalSquare() + commonUsingSquare;
    }

    public  float getFlatTotalSquare(){
        float square = 0;
        if(flats != null){
            for (Flat f : flats){
                square += f.getTotalSquare();
            }
        }
        return square;
    }

    public float getLivingSquare(){
        float square = 0;
        if(flats != null) {
            for (Flat f : flats) {
                square += f.getLivingSquare();
            }
        }
        return square;
    }
}
