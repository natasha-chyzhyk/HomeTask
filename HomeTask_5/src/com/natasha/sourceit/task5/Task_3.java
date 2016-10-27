package com.natasha.sourceit.task5;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_3 {
    private Random randomGenerator = new Random();
    private int arrayMinValue, arrayMaxValue;

    public Task_3(int arrayMinValue, int arrayMaxValue) {
        this.arrayMinValue = arrayMinValue;
        this.arrayMaxValue = arrayMaxValue;
    }

    public void array2d_2(int nRows, int minRowLength, int maxRowLength) {

        int[][] array2d = create2DArray(nRows, minRowLength, maxRowLength);

        System.out.println(Arrays.deepToString(array2d));
    }

    private int[][] create2DArray(int nRows, int minRowLength, int maxRowLength) {
        int[][] array = new int[nRows][];
        for (int i = 0; i < array.length; i++){
            array[i] = fillRow( createRandomLengthRow(minRowLength, maxRowLength) );
        }
        return array;
    }




    private int[] createRandomLengthRow(int minRowLength, int maxRowLength) {
        return new int[getRandomIntFromMinToMax(minRowLength, maxRowLength)];
    }

    private int[] fillRow(int[] row) {
        for (int i=0; i<row.length; i++) {
            row[i] = getRandomIntFromMinToMax(arrayMinValue, arrayMaxValue);
        }
        return row;
    }



    private int getRandomIntFromMinToMax(int min, int max) {
        if (max > min) {
            return min + randomGenerator.nextInt(max - min);
        } else {
            throw new IllegalArgumentException("Minimum must be less then maximum");
        }
    }
}
