package com.natasha.sourceit.task4;

/**
 * Created by Stas on 12.10.2016.
 */
/*
Пускай в программе есть целочисленная переменная отвечающая за ежемесячеый доход.
Необходимо в зависимости от дохода вывести на экран:
от 0 до 1000 - критически малый доход
от 1000 до 5000 - средний доход
от 5000 до 100000 - высокий доход
от 100000 - миллионер
Это задание попытайтесь сделать как условиями так и оператором выбора.
 */
public class Task_3 {
    private float income;

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        if (income < 0) {
            throw new IllegalArgumentException("Доход не может быть отрицательным");
        }
        this.income = income;
    }

    public void selection1(){
        if(income < 1000){
            System.out.println("Ежемесячный доход " +income+ " критически мал");
        }else  if(income < 5000){
            System.out.println("Ежемесячный доход " +income+ " - средний");
        }else  if(income < 100000){
            System.out.println("Ежемесячный доход " +income+ " - высокий");
        }else{
            System.out.println("Ежемесячный доход " +income+ " - миллионер");
        }
    }

    public void selection1_1(){
        if(income < 1000) {
            System.out.println("Ежемесячный доход " +income+ " критически мал");
        } else  if(income < 5000){
            System.out.println("Ежемесячный доход " +income+ " - средний");
        }else  if(income < 100000) {
            System.out.println("Ежемесячный доход " +income+ " - высокий");
        }else {
            System.out.println("Ежемесячный доход " +income+ " - миллионер");
        }

    }

    public void selection2(){
        int i;
        if(income < 1000) {
            i = 0;
        }else if(income < 5000){
            i = 1;
        }else if(income < 100000){
            i = 2;
        }else{
            i = 3;
        }

        switch (i){
            case 0:
                    System.out.println("Ежемесячный доход " + income + " критически мал");
                break;
            case 1:
                    System.out.println("Ежемесячный доход " +income+ " - средний");
                break;
            case 2:
                    System.out.println("Ежемесячный доход " + income + " - высокий");
                break;
            case 3:
                    System.out.println("Ежемесячный доход " + income + " - миллионер");
                break;
            case 4:
                System.out.println("Ежемесячный убыток равен " +income);
                break;
        }
    }
}
