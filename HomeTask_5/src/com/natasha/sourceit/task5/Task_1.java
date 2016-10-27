package com.natasha.sourceit.task5;

import java.util.Arrays;

/**
 * Created by Stas on 18.10.2016.
 */
public class Task_1 {

    public void printNumberOfMaxElement(int[] inArray) {
        int maxValue = Integer.MIN_VALUE;
        int digest = 1;
        for (int i = 1; i < inArray.length; i++) {
            if(inArray[i] > maxValue){
                maxValue = inArray[i];
                digest = 1;
            } else if( inArray[i] == maxValue){
                digest ++;
            }
        }
        System.out.print(Arrays.toString(inArray));
        System.out.println(String.format(" MAx value=%d, Nmax = %d", maxValue, digest));
    }

}
