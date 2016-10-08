package com.natasha.sourceit.task3;

/**
 * Created by Stas on 08.10.2016.
 */
public class Task {
    private float value;

    public void setValue(float value){
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public int summa(){
        int vInt = (int)(value * 100);
        int summa = 0;
        int rem = vInt % 10;
        summa = summa + rem/1;
        rem = vInt % 100;
        summa = summa + rem/10;
        rem = vInt % 1000;
        summa = summa + rem/100;
        return summa;
    }

    public int summa1() {
        int vInt = (int)(value * 100f);
        int rem = vInt % 10;
        int summa = rem;
        vInt = (vInt - rem) / 10;

        rem = vInt % 10;
        summa += rem;
        vInt = (vInt - rem) / 10;

        summa += vInt;
        return summa;
    }

    public  int summa2(){
        int summa = 0;
        for(int i =0, j = 1; i < 3; i++, j = j * 10){
            int vInt = (int)(value * 100);
            vInt = vInt % (j*10);
            summa = summa +(vInt/j);
        }
        return summa;
    }
}
