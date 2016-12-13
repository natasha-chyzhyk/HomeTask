package com.natasha.sourceit.task17;

/**
 * Created by Stas on 05.12.2016.
 */
public class Shop {
    public synchronized IceCream makeIceCream(IceCream iceCream) throws InterruptedException {
        Thread.sleep(5000);
        return iceCream;
    }
}
