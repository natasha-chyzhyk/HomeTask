package com.natasha.sourceit.task2.cupboard;
/**
 * Created by Stas on 06.10.2016.
 */
public class BoxOnTheRails extends Box {

    public BoxOnTheRails(int volume, Handle handle) {
        super(volume, handle);
    }

    @Override
    public void pull() {
        System.out.println("ящик с коробкой на рельсах выдвинут");
    }

    @Override
    public void push() {
        System.out.println("ящик с коробкой на рельсах задвинут");
    }
}
