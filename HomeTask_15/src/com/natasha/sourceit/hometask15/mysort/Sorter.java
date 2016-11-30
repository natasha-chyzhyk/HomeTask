package com.natasha.sourceit.hometask15.mysort;

import java.util.Comparator;

/**
 * Created by Stas on 27.11.2016.
 */
public class Sorter<T extends Number> {

    public void sort(T[] inArray, Comparator<T> comp) {
        for (int i=0; i<inArray.length-1; i++) {

            T minElement = inArray[i];
            int minElemIndex = i;
            for (int k = i; k<inArray.length; k++) {

                int cmpResult = comp.compare(inArray[k], minElement);
                // cmpResult<0  =>  inArray[i] < minElement
                // cmoResult>0  =>  inArray[i] > minElement
                // cmpResult=0  =>  inArray[i] = minElement

                if (cmpResult < 0) {
                    minElement = inArray[k];
                    minElemIndex = k;
                }

            }
            T tmp = inArray[i];
            inArray[i] = inArray[minElemIndex];
            inArray[minElemIndex] = tmp;

        }
    }


}
