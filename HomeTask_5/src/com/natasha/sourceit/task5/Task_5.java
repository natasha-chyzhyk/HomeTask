package com.natasha.sourceit.task5;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_5 {
    public void ticket(int[] a){
        int digits = 0;
        for(int j = 1, i = 0; i < a.length; i++, j++) {
            a[i] = j;
            int k1 = a[i] / 100000;
            int k = a[i] - k1 * 100000;
            int k2 = k / 10000;
            k = k - k2 * 10000;
            int k3 = k / 1000;
            k = k - k3 * 1000;
            int k4 = k / 100;
            k = k - k4 * 100;
            int k5 = k / 10;
            int k6 = k % 10;
            if (k1 + k2 + k3 == k4 + k5 + k6) {
                digits++;
            }
        }
        System.out.println("Сувениров потребуется " + digits + " штук");
    }

    public void ticket1(int[] a){
        int digits = 0;
        for (int i = 0, j = 1; i < a.length; i++, j++){
            a[i] = j;
            int k = a[i];
            int[] c = new int[6];
            for(int index = 0, b = 100000; index < c.length; index++, b /= 10){

                c[index] = k/b;
                k = k - c[index] * b;
            }
            if(c[0] + c[1] + c[2] == c[3] + c[4] + c[5]){
                digits++;
            }

        }
        System.out.println("Сувениров потребуется " + digits + " штук");
    }
}
