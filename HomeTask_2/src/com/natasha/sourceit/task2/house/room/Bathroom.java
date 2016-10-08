package com.natasha.sourceit.task2.house.room;

import com.natasha.sourceit.task2.house.items.Mirror;
import com.natasha.sourceit.task2.house.Washbasin;
import com.natasha.sourceit.task2.house.items.Bath;

/**
 * Created by Stas on 08.10.2016.
 */
public class Bathroom extends RoomNonLiving {
    private Bath bath;
    private Washbasin washbasin;
    private Mirror mirror;

    public Bathroom(float square, float height) {
        super(square, height);
    }
}
