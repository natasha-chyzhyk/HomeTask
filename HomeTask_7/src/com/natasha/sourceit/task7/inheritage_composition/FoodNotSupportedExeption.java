package com.natasha.sourceit.task7.inheritage_composition;

/**
 * Created by Stas on 24.10.2016.
 */
public class FoodNotSupportedExeption extends Exception {
    private HerbalFood food;

    public FoodNotSupportedExeption(HerbalFood food) {
        super();
        this.food = food;
    }

    public HerbalFood getFood() {

        return food;
    }
}
