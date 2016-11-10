package com.natasha.sourceit.task8;

public class Main {

    public static void main(String[] args) {
            TyagachGonochny tyagachGonochny = new TyagachGonochny(1500.5f, 501.8f);
            RallyCar rallyCar = new RallyCar(201.3f);
            TrackCar trackCar = new TrackCar(155f);
            tyagachGonochny.pull(rallyCar);
            tyagachGonochny.pull(trackCar);

            TyagachRegular tyagachRegular = new TyagachRegular(1400f, 350.7f);
            RegularCar regularCar = new RegularCar(320.1f);
            tyagachRegular.pull(regularCar);


    }
}
