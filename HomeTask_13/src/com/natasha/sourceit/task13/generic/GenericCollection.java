package com.natasha.sourceit.task13.generic;

import java.lang.reflect.Array;

/**
 * Created by Stas on 24.11.2016.
 */
public class GenericCollection<BLA_BLA> {
    private BLA_BLA[] array;
    private final int initialSize;


    public GenericCollection(int size){
        this.initialSize = size;
        this.array =  (BLA_BLA[]) new Object[size];
    }

    public void add(BLA_BLA o) {
        int nElements = size();
        if (nElements < array.length) {
            array[nElements] = o;
        } else {
            BLA_BLA[] nArray = (BLA_BLA[]) new Object[array.length + 1];
            System.arraycopy(array, 0, nArray, 0, array.length);
            nArray[array.length] = o;
            this.array = nArray;
        }

        /*for(int i = 0; i < array.length; i++){
            if(i == array.length - 1 && array[i] != null) {
                BLA_BLA[] array1 = new BLA_BLA[array.length+1];
                for (int k = 0, j = 0; k < array.length; k++, j++){
                    array1[j] = array[k];
                }
                array1[array1.length - 1] = o;
                this.array = array1;
                return;
            }
            if(array[i] == null){
                array[i] = o;
                break;
            }
        }*/
    }

    public BLA_BLA removeLast() {
        if(array.length == 0) return null;
        int index = array.length-1;
        while ((index >= 0) && array[index] == null) {
            index --;
        }

        BLA_BLA removed = null;
        if (index >= 0) {
            removed = array[index];
            array[index] = null;
            if (index >= initialSize) {
                BLA_BLA[] nArray = (BLA_BLA[]) new Object[index];
                System.arraycopy(array, 0, nArray, 0, nArray.length);
                array = nArray;
            }
        }
        return removed;
    }

    public int size(){
        /*int digits = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] != null){
                digits++;
            } else {
                break;
            }
        }
        return digits;*/

        int nElements = 0;
        while (nElements < array.length && array[nElements] != null) {
            nElements ++;
        }
        return nElements;

    }

    public int internalBufferSize() {
        return array.length;
    }

    public static class EmptyException extends RuntimeException {
    }

    public int max() {
        if (size() == 0) throw new EmptyException();
        /*int max = array[0].hashCode();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) {
                break;
            } else if (array[i].hashCode() > max) {
                max = array[i].hashCode();
            }
        }*/
        int max = Integer.MIN_VALUE;
        int i=0;
        while((i < array.length) && (array[i] != null)) {
            if (array[i].hashCode() > max) {
                max = array[i].hashCode();
            }
            i++;
        }
        return max;
    }

    public int min(){
        if (size() == 0) throw new EmptyException();
        int min = Integer.MAX_VALUE;
        int i=0;
        while((i < array.length) && (array[i] != null)) {
            if (array[i].hashCode() < min) {
                min = array[i].hashCode();
            }
            i++;
        }
        return min;
    }

    public double avg(){
        if (size() == 0) throw new EmptyException();
        double avg = 0;
        int i=0;
        while((i < array.length) && (array[i] != null)) {
            avg += array[i].hashCode();
            i++;
        }
        return avg/i;
    }
}
