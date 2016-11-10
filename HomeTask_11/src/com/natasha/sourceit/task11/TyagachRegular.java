package com.natasha.sourceit.task11;

/**
 * Created by Stas on 08.11.2016.
 */
public class TyagachRegular extends Tyagach<RegularCar> {

    public TyagachRegular(float weight, float maxLiftWeight){
        super(weight, maxLiftWeight);
    }

    public void pull(RegularCar car) throws WeightException{
        if(getMaxLiftWeight() > car.getWeight()) {
            System.out.println("pull regular car - " + car);
        }else {
            throw new WeightException();
        }
    }

    public void ride(){
        System.out.println("TyagachRegular can ride");
    }
}
