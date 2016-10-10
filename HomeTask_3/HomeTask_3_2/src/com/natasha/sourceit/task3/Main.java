package com.natasha.sourceit.task3;

/**
 * Created by Stas on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Task task1 = new Task();
        task1.setValue(7.35f);
        printResult(task1);

        task1.setValue(2.71f);
        printResult(task1);


        Task task2 = new Task();
        task2.setValue(5.98f);
        printResult(task2);

    }
    private static void printResult(Task task1) {
        System.out.println("Value to process: "+task1.getValue()+"  ");
        System.out.println("Minimum value = " + task1.minValue() + "; minimum value1=" + task1.minValue2());
        System.out.println("Maximum value = " + task1.maxValue() + "; maximum value1=" + task1.maxValue2());
    }
}
