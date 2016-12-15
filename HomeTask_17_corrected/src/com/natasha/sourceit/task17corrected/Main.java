package com.natasha.sourceit.task17corrected;

public class Main {

    public static void main(String[] args) {
        System.out.println("Thread "+Thread.currentThread().getName()+" has been started");

        IceCreamShop shop = new IceCreamShop();

        Child c1 = new Child("Vova", IceCream.Taste.CHOCOLATE);
        c1.setShop(shop);
        new Thread(c1, c1.getName()).start();

        Child c2 = new Child("Shsha", IceCream.Taste.BLACKBERRY);
        c2.setShop(shop);
        new Thread(c2, c2.getName()).start();

        Child c3 = new Child("Piter", IceCream.Taste.STRAWBERRY);
        c3.setShop(shop);
        new Thread(c3, c3.getName()).start();

        System.out.println("Thread "+Thread.currentThread().getName()+" has been finished");
    }
}
