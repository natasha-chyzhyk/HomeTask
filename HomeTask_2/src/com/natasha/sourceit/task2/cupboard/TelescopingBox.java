package com.natasha.sourceit.task2.cupboard;

/**
 * Created by Stas on 06.10.2016.
 */
public class TelescopingBox extends Box {

    public TelescopingBox(int volume, Handle handle) {
        super(volume, handle);
    }

    @Override
    public void push() {
        System.out.println("���� � ��������������� ���������� ��������");
    }

    @Override
    public void pull() {
        System.out.println("���� � ��������������� ���������� ��������");
    }
}
