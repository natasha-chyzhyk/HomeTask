package com.natasha.sourceit.task4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Варианты заданий:\n 1.Вывод на экран;\n 2.Вычислить сумму цифр вещественного трёхзначного числа с 5-мя знаками после запятой;\n 3.Вывод на экран ежемесячного дохода.");


        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        switch (i){
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            default:
                System.out.println("Введено не корректное значение");
        }
    }

    public static void task1(){
        Output output = new Output();
        output.println();
    }

    public static void task2(){
        Task_2 task_2 = new Task_2(5);
        task_2.setValue(123.58896f);
        System.out.println("Сумма всех цифр числа " + task_2.getValue() + " равна:\n1.Первый вариант решения: " + task_2.summa1()+"\n2.Второй вариант решения: "+task_2.summa2()+"\n3.Третий вариант решения: "+task_2.summaOpt());
    }

    public static void task3(){
        Task_3 task_3 = new Task_3();
        task_3.setIncome(5000.8f);
        task_3.selection1();
        task_3.selection1_1();
        task_3.selection2();
        task_3.setIncome(10000f);
        task_3.selection1();
        task_3.selection1_1();
        task_3.selection2();
    }
}
