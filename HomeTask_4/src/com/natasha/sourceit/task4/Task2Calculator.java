package com.natasha.sourceit.task4;

/**
 * Created by Stas on 12.10.2016.
 */
public class Task2Calculator {

    private long num, denum;

    public Task2Calculator(long num, long denum) {
        if (denum >= num) {
            throw new IllegalArgumentException("Numerator must be greater denominator");
        }
        this.num = num;
        this.denum = denum;
    }

    public int nextDigit() {
        int digit = (int)(num / denum);
        num -= digit * denum;
        denum /= 10;
        return digit;
    }
}
