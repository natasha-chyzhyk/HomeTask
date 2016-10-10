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
        int vInt = (int)(value * 100);
        int digits = vInt % 10;
        int max = digits/1;
        digits = vInt % 100;
        int nextDigits = digits/10;
        if(nextDigits > max){
            max = nextDigits;
        }
        digits = vInt % 1000;
        nextDigits = digits/100;
        if(nextDigits > max){
            max = nextDigits;
        }
        return max;
    }

    public  int maxValue2(){
        int max = Integer.MIN_VALUE;
        int vInt = (int)(value * 100);
        for(int i =0, j = 1; i < 3; i++, j = j * 10){
            int digits = vInt % (j*10)/j;
            if(digits > max){
                max = digits;
            }
        }
        return max;
    }
}
