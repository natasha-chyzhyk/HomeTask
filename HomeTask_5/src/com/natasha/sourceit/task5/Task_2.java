package com.natasha.sourceit.task5;

import java.util.Arrays;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_2 {
    public void change(int[] a){
        System.out.println(Arrays.toString(a));
        for(int i = 0, j = a.length - 1; i < a.length/2; i++, j--){
            int k = a[j];
            a[j] = a[i];
            a[i] = k;

        }

        System.out.println(Arrays.toString(a));
    }
}
