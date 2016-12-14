package com.natasha.sourceit.task17;

public class Main {

    public static void main(String[] args) {

        System.out.println("Thread "+Thread.currentThread().getName()+" has been started");

        IceCreamShop shop = new IceCreamShop();

        Child[] children = new Child[3];

        Child c1 = new Child("Vova", IceCream.Taste.CHOCOLATE);
        c1.setShop(shop);
        children[0] = c1;

        Child c2 = new Child("Shsha", IceCream.Taste.BLACKBERRY);
        c2.setShop(shop);
        children[1] = c2;

        Child c3 = new Child("Piter", IceCream.Taste.STRAWBERRY);
        c3.setShop(shop);
        children[2] = c3;

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {

        }

        killAll(children);

        System.out.println("Thread "+Thread.currentThread().getName()+" has been finished");
    }

    private static void killAll(Child[] children) {
        for (Child c : children) {
            c.kill();
        }
    }
}
