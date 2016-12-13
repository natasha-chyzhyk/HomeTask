package com.natasha.sourceit.task9;

public class Main {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        for(int i = 0; i < 50; i++) {
            System.out.println("-----------Step " + i + "-----------");
            gameService.calculateNextStep();
        }
    }
}
