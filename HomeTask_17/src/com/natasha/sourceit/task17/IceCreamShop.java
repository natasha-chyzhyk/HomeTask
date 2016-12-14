package com.natasha.sourceit.task17;

/**
 * Created by Stas on 05.12.2016.
 */
public class IceCreamShop {

    public synchronized IceCream makeIceCream(IceCream.Taste taste, IceCream.Size portionSize) throws InterruptedException {
        String text = String.format("Shop is making %s %s Icecream for Thread - %s", portionSize, taste, Thread.currentThread().getName());
        System.out.println(text);

        long tProduce = 0;
        switch (portionSize) {
            case SMALL:
                tProduce = 5000;
                break;
            case MEDIUM:
                tProduce = 6000;
                break;
            case DOUBLE:
                tProduce = 8000;
                break;
        }
        Thread.sleep(tProduce);
        return new IceCream(taste, portionSize);
    }
}
