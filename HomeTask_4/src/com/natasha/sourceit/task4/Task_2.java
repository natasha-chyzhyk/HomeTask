package com.natasha.sourceit.task4;

/**
 * Created by Stas on 12.10.2016.
 */
/*
В переменной n хранится вещественное трёхзначное число с 5-мя знаками после запятой. Создайте программу, вычисляющую и выводящую на экран значение формулы:
цифра соте + цифра 10-ов - цифра единиц + цифра десятых - цифра сотых и т.д числа n.
Например есть число 563,25638. Нам надо будет вычислить такую формулу: 5+6-3+2-5+6-3+8
 */
public class Task_2 {
    private float value;
    private int nDigAfterPoint;

    public Task_2(int nDigAfterPoint) {
        this.nDigAfterPoint = nDigAfterPoint;
    }

    public void setValue(float value){
        this.value = value;
    }

    public float getValue(){
        return value;
    }

    public int summa1(){
        int intV1 = (int)value;
        int fV = Math.round((value - intV1) * 100000);
        int i1 = intV1 / 100;
        intV1 -= i1 * 100;
        int i2 = intV1 / 10;
        int i3 = intV1 % 10;
        int i4 = fV / 10000;
        fV -= i4 * 10000;
        int i5 = fV / 1000;
        fV -= i5 * 1000;
        int i6 = fV / 100;
        fV -= i6 * 100;
        int i7 = fV / 10;
        int i8 = fV % 10;
        int i = i1 + i2 - i3 + i4 - i5 + i6 - i7 + i8;
        return i;
    }

    public int summa2() {
        long intV = Math.round(value * Math.pow(10, nDigAfterPoint));
        int N = getNumDigitsBeforePoint() + nDigAfterPoint - 1;
        long denum = Math.round(Math.pow(10, N));
        int sum = (int)(intV / denum);
        intV -= sum * denum;
        denum /= 10;
        int k=1;
        for (int i=0; i<N; i++) {
            long digit = intV / denum;
            intV -= digit * denum;
            denum /= 10;
            sum += k * digit;
            k *= -1;
        }
        return sum;
    }

    public int summaOpt() {
        int N = getNumDigitsBeforePoint() + nDigAfterPoint - 1;
        Task2Calculator digCalculator = new Task2Calculator(Math.round(value * Math.pow(10, nDigAfterPoint)), Math.round(Math.pow(10, N)));

        int sum = digCalculator.nextDigit();
        int k=1;
        for (int i=0; i<N; i++) {
            sum += k * digCalculator.nextDigit();
            k *= -1;
        }
        return sum;
    }

    /**
     * Возвращает количество цифр в целой части дробного числа
     * @return
     */
    private int getNumDigitsBeforePoint() {
        int nDigits = 1;
        int denum = 10;
        int value = Math.round(this.value);
        while (value % denum != value) {
            denum *= 10;
            nDigits ++;
        }
        return nDigits;
    }


}
