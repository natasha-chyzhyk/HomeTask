package com.natasha.sourceit.task5;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_4 {
    public void sequence(int[] a){
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < a.length; i++){
            a[i] = a[i - 1] + a[i - 2];
        }
        print(a);
    }

    public void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(i != (a.length - 1) ? a[i] + ", " : a[i]);
        }
    }
}
