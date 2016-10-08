package com.natasha.sourceit.task3;

/**
 * Created by Stas on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        Task task1 = new Task();
        task1.setValue(7.35f);
        printResult(task1);
        task1.setValue(2.54f);
        printResult(task1);
    }

    private static void printResult(Task task) {
        System.out.print("Value to process: "+task.getValue()+"  ");
        System.out.println("summa=" + task.summa() + "; summa1=" + task.summa1() + "; summa2=" + task.summa2());
    }

}
