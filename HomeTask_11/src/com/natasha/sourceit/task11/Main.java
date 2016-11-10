package com.natasha.sourceit.task11;

public class Main {

    public static void main(String[] args) {
        try {
            TyagachGonochny tyagachGonochny = new TyagachGonochny(1500.5f, 501.8f);
            RallyCar rallyCar = new RallyCar(201.3f);
            tyagachGonochny.pull(rallyCar);

            TyagachRegular tyagachRegular = new TyagachRegular(1400f, 350.7f);
            RegularCar regularCar = new RegularCar(400.1f);
            tyagachRegular.pull(regularCar);


        }catch (WeightException ex){
            ex.printStackTrace(System.out);
        }

        try{
            Samosval samosval = new Samosval(980.7f, 500f, 200f);
            samosval.loadMore(100f);
            samosval.checkGrus();
            samosval.loadMore(200f);
            samosval.checkGrus();
            samosval.loadMore(200f);
            samosval.checkGrus();
        }catch (OverLoadException ex){
            ex.printStackTrace(System.out);
        }
    }
}
