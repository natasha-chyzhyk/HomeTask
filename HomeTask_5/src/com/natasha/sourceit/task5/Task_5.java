package com.natasha.sourceit.task5;

import java.util.Arrays;

/**
 * Created by Stas on 19.10.2016.
 */
public class Task_5 {
    public void ticket(){
        int digits = 0;
        for(int j = 1; j <= 999999; j++) {
            int k1 = j / 100000;
            int k = j - k1 * 100000;
            int k2 = k / 10000;
            k = k - k2 * 10000;
            int k3 = k / 1000;
            k = k - k3 * 1000;
            int k4 = k / 100;
            k = k - k4 * 100;
            int k5 = k / 10;
            int k6 = k % 10;
            if ((k1 + k2 + k3) == (k4 + k5 + k6)) {
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


    public int getNumberOfLuckyTickent(int minSerialNumber, int maxSerialNumber) {

        int maxNumberOfDigits = getNumberOfDigits(maxSerialNumber);

        if (maxNumberOfDigits % 2 > 0) {
            System.out.println("Количество цифр должно быть четным");
            return 0;
        }

        int nLuckyTickets = 0;
        for (int currentNumber = minSerialNumber; currentNumber < maxSerialNumber; currentNumber++) {

            //Разбить на цифры и положить в массив
            int[] digits = splitNumberToDigits(currentNumber, maxNumberOfDigits);

            //Просуммировать верхнюю и нижнюю половины массива
            int sumPart1=0, sumPart2 = 0;
            for (int loIndex = 0, hiIndex = digits.length/2; hiIndex < digits.length; loIndex++, hiIndex++) {
                sumPart1 += digits[loIndex];
                sumPart2 += digits[hiIndex];
            }

            //Проверка на счастье
            if (sumPart1 == sumPart2) {
                nLuckyTickets ++;
                System.out.println(String.format("lucky ticket #%d - %s", nLuckyTickets, Arrays.toString(digits)));
            }
        }
        return nLuckyTickets;
    }

    private int[] splitNumberToDigits(int valueToSplit, int numberOfDigits) {
        int[] digits = new int[numberOfDigits];

        for(int index = digits.length-1, denum = 10; index >= 0; index--, denum *= 10) {
            int rem = (valueToSplit % denum);
            valueToSplit -= rem;
            digits[index] = rem * 10 / denum;
        }

        return digits;
    }

    private int getNumberOfDigits(int value) {
        int n = 1;
        int d = 10;

        // Когда остаток станет равен самому число, то в делителе количество нулей
        // будет равно количеству цифр в делимом (которое проверяется).
        // Соответственно счетчик будет содержать нужный результат
        while (value % d != value) {
            n ++;
            d *= 10;
        }

        return n;
    }



}
