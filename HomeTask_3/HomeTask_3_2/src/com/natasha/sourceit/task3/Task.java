package com.natasha.sourceit.task3;

/**
 * Created by Stas on 08.10.2016.
 */
public class Task {
    private float value;

    public void setN(float value){
        this.value = value;
    }

    public int minValue(){
        int vInt = (int)(value * 100);
        int min = vInt % 10;

        int nextDigit = (vInt % 100)/10;
        if(nextDigit < min){
            min = nextDigit;
        }

        nextDigit = (vInt % 1000)/100;
        if(nextDigit < min){
            min = nextDigit;
        }
        return min;
    }

    public  int minValue2(){
        int min = Integer.MAX_VALUE;
        int vInt = (int)(value * 100);
        for(int i = 0, j = 1; i < 3; i++, j = j * 10){
            int digit = (vInt % (j*10)) / j;
            if (digit < min){
                min = digit;
            }
        }
        return min;
    }

    public int maxValue(){
        int a = (int)(value * 100);
        int c = a%10;
        int max = c/1;
        c = a%100;
        int d = c/10;
        if(d > max){
            max = d;
        }
        c = a%1000;
        d = c/100;
        if(d > max){
            max = d;
        }
        return max;
    }

    public  int maxValue2(){
        int d = 0;
        int max = 0;
        for(int i =0, j = 1; i < 3; i++, j = j * 10){
            int a = (int)(value * 100);
            a = a % (j*10);
            d = a/j;
            if(max == 0 || d > max){
                max = d;
            }
        }
        return max;
    }
}
