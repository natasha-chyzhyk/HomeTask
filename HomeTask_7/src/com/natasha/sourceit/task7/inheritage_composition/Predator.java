package com.natasha.sourceit.task7.inheritage_composition;

/**
 * Created by Stas on 24.10.2016.
 */
public abstract class Predator extends Animal {
    private int fang;

    public Predator(String name, float age, String area, int fang) {
        super(name, age, area);
        this.fang = fang;
    }

    public int getFang() {
        return fang;
    }

    public void eat(Herbivorous herbivorous){

        System.out.println(herbivorous + " was eaten");
    }

}
