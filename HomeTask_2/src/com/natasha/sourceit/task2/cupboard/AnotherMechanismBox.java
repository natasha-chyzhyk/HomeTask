package com.natasha.sourceit.task2.cupboard;

/**
 * Created by Stas on 06.10.2016.
 */
public class AnotherMechanismBox extends Box{

    public AnotherMechanismBox(int volume, Handle handle) {
        super(volume, handle);
    }

    @Override
    public void push() {
        System.out.println("ящик с другим механизмом выдвижени€ выдвинут");
    }

    @Override
    public void pull() {
        System.out.println("ящик с другим механизмом выдвижени€ задвинут");
    }
}
