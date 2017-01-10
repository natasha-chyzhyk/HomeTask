package com.natasha.sourceit.game;

import com.natasha.sourceit.game.character.BaseCharacter;
import com.natasha.sourceit.game.character.impl.Angel;
import com.natasha.sourceit.game.character.impl.FlyPig;
import com.natasha.sourceit.game.character.impl.Pig;
import com.natasha.sourceit.game.character.impl.Warrior;
import com.natasha.sourceit.game.drawing.ScreenImpl;
import com.natasha.sourceit.game.logic.GameService;
import com.natasha.sourceit.game.logic.impl.DefaultGameController;
import com.natasha.sourceit.game.map.MapVariant1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GameService gameService = new DefaultGameController(new MapVariant1());
        gameService.setDrawingSurface(new ScreenImpl(60, 35));

        gameService.populateCharacters(createCharacters());


        try {


            //-----  MAIN GAME CYCLE ----
            for (int i = 0; i < 2000; i++) {
                gameService.drawScene();
                gameService.calculateNextStep();
                Thread.sleep(250);
            }
        } catch (InterruptedException e){}

    }


    private static List<BaseCharacter> createCharacters() {
        List<BaseCharacter> ccc = new ArrayList<>();
        ccc.add(new Angel(30, 4));
        ccc.add(new Angel(45, 5));
        ccc.add(new Warrior(26, 5));
        ccc.add(new Warrior(30, 3));
        ccc.add(new Pig(50, 1));
        ccc.add(new Pig(50, 1));
        ccc.add(new FlyPig(10, 2));

        return ccc;
    }
}
