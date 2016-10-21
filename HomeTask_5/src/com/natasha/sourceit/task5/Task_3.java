package com.natasha.sourceit.task5;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_3 {
    public void array2d_1(){
        float[][] array2 = new float[10][10];
        Random ran = new Random();
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2.length; j++){
                array2[i][j] = ran.nextFloat();
            }
        }
        System.out.println(Arrays.deepToString(array2));
    }

    public void array2d_2(){
        int[][] dd =new int[5][];
        for (int i = 0, j = 1; i < dd.length; i++, j +=2){
            dd[i] = new int[j];
        }
        Random ran = new Random();
        for(int i = 0; i < dd.length; i++){
            for(int j = 0; j < dd[i].length; j++){
                dd[i][j] = ran.nextInt(100);
            }
        }
        System.out.println(Arrays.deepToString(dd));
    }
}
