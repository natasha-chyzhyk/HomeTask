package com.natasha.sourceit.task17corrected;

import java.util.Random;

/**
 * Created by Stas on 15.12.2016.
 */
public class Child implements Runnable{
    private String name;
    private IceCream.Taste preferredTaste;
    private IceCreamShop shop;

    public Child(String name, IceCream.Taste preferredTaste) {
        this.name = name;
        this.preferredTaste = preferredTaste;
    }

    public String getName() {
        return name;
    }

    public void setShop(IceCreamShop shop) {
        this.shop = shop;
    }

    private Random rnd = new Random();
    @Override
    public void run() {
        try {
            System.out.println("------------------  " + name + "  ---------------------");

            if (shop != null) {
                IceCream.Size size = IceCream.Size.values()[rnd.nextInt(IceCream.Size.values().length)];
                System.out.println(String.format("Child %s wants %s %s Icecream.", name, size, preferredTaste));

                IceCream ice = shop.makeIceCream(preferredTaste, size);

                eatIceCream(ice);
            }
            System.out.println("~~~~~~~~~~  Child " + name + " is dead! ~~~~~~~~~~~~");
        } catch (InterruptedException e) {

        }
    }

    public void eatIceCream(IceCream ice){
        System.out.println("Child "+name+" eats IceCream - "+ice);
    }
}
