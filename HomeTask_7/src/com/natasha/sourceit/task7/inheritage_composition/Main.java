package com.natasha.sourceit.task7.inheritage_composition;

public class Main {

    public static void main(String[] args) throws FoodNotSupportedExeption {
        HerbalFood[] foods = new HerbalFood[3];
        foods[0] = HerbalFood.CARROT;
        foods[1] = HerbalFood.GRASS;
        foods[2] = HerbalFood.HAY;
        Rabbit rabbit = new Rabbit(2, "forest", foods);
        rabbit.sleep();
        System.out.println(rabbit.getName() + " makes a sound " + rabbit.makeNoise());
        rabbit.eat(HerbalFood.CARROT);
        //rabbit.eat(HerbalFood.APPLES);

        System.out.println("-----------");
        Wolf wolfs = new Wolf(5, "forest", 4);
        System.out.println(wolfs.getName() + " makes a sound " + wolfs.makeNoise());
        wolfs.eat(rabbit);
        System.out.println(wolfs.getName() + " lives in the " + wolfs.getLivingArea());
    }
}
