package com.natasha.sourceit.task3;

/**
 * Created by Stas on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Task task1 = new Task();
        task1.setN(7.35f);
        System.out.println(task1.minValue());
        System.out.println(task1.minValue2());

        Task task2 = new Task();
        task2.setN(7.35f);
        System.out.println(task1.maxValue());
        System.out.println(task1.maxValue2());
    }
}
