package com.natasha.sourceit.task5;

import java.util.Arrays;

/**
 * Created by Stas on 18.10.2016.
 */
public class Task_1 {
    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i * i * i;
        }
        System.out.print(Arrays.toString(a));
    }

}
