package com.natasha.sourceit.task7.inheritage_composition;

/**
 * Created by Stas on 24.10.2016.
 */
public abstract class Herbivorous extends Animal {

    private HerbalFood[] supportedFood;

    public Herbivorous(String name, float age, String area, HerbalFood[] food) {
        super(name, age, area);
        this.supportedFood = food;
    }

    public HerbalFood[] getSupportedFood() {
        return supportedFood;
    }

    public void eat(HerbalFood food) throws FoodNotSupportedExeption {
        if (checkFoodSupported(food)) {
            System.out.println(getName()+ " eat " + food);
        } else {
            throw new FoodNotSupportedExeption(food);
        }
    }

    private boolean checkFoodSupported(HerbalFood food) {
        for(int i = 0; i < supportedFood.length; i++){
            if(supportedFood[i] == food){
                return true;
            }
        }
        return false;
    }


}
