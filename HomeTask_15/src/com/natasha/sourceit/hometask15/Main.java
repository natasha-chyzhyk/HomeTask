package com.natasha.sourceit.hometask15;

import com.natasha.sourceit.hometask15.mysort.Sorter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    CollectionArrayList.sortArrayList();
        CollectionMap.sortMap();



        System.out.println("-----------------  My implementation for sort list  -------------------------");
        Sorter<Long> mySorter = new Sorter<>();
        Long[] arr = createLongArray(10);
        System.out.println("before obj sort: "+ Arrays.toString(arr));
        mySorter.sort(arr, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                // o1 < o2  =>  -1
                // o1 > o2  =>  +1
                // o1 = o2  =>  0

                return o2.compareTo(o1);

                /*if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }*/
            }
        });
        System.out.println("after obj sort: "+ Arrays.toString(arr));
    }


    private static Long[] createLongArray(int nElements) {
        Random rnd = new Random();
        Long[] arr = new Long[nElements];
        for (int i=0; i<nElements; i++) {
            arr[i] = rnd.nextLong();
        }
        return arr;
    }


}
