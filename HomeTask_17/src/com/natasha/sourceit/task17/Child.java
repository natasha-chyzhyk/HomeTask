package com.natasha.sourceit.task17;

import java.util.Random;

/**
 * Created by Stas on 05.12.2016.
 */
public class Child{

    private String name;
    private IceCream.Taste preferredTaste;

    private final Object shopLock = new Object();
    private IceCreamShop shop;

    private Thread eaterThread;


    private boolean isAlive = true;


    public Child(String name, IceCream.Taste preferredTaste) {
        this.name = name;
        this.preferredTaste = preferredTaste;

        eaterThread = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    myRun();
                } catch (InterruptedException e) {

                }
            }
        }, name);
        eaterThread.start();
    }

    public void setShop(IceCreamShop shop) {
        synchronized (shopLock) {
            this.shop = shop;
        }
    }

    public void kill() {
        isAlive = false;
        System.out.println("Kill "+name+" from Thread - "+Thread.currentThread().getName());
    }




    private Random rnd = new Random();
    private void myRun() throws InterruptedException {
        while (isAlive) {
            System.out.println("------------------  "+name+"  ---------------------");

            IceCreamShop localShop;
            synchronized (shopLock) {
                localShop = shop;
            }

            if (localShop != null) {
                IceCream.Size size = IceCream.Size.values()[rnd.nextInt(IceCream.Size.values().length)];
                System.out.println(String.format("Child %s wants %s %s Icecream.", name, size, preferredTaste));

                IceCream ice = localShop.makeIceCream(preferredTaste, size);

                eatIceCream(ice);
            } else {
                Thread.sleep(100);
            }
        }

        System.out.println("~~~~~~~~~~  Child "+name+" is dead! ~~~~~~~~~~~~");
    }





    public void eatIceCream(IceCream ice){
        System.out.println("Child "+name+" eats IceCream - "+ice);
    }
}
