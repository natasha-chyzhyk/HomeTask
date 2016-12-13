package com.natasha.sourceit.task17;

/**
 * Created by Stas on 05.12.2016.
 */
public class Child implements Runnable{
    private String name;
    private String likeIceCrem;
    private String IceCream;
    private Shop shop;

    @Override
    public void run() {
        shop.makeIceCream();
    }

    public void eatIceCream(){
        System.out.println("Child eat " +IceCream+ " . This is him " +likeIceCrem == likeIceCrem+ ? " favorite ice cream." : " not favorite ice cream");
    }
}
