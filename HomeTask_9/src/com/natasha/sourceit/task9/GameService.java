package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public interface GameService {
    public Character getUserCharacter();
    public Monster[] getMonsters();
    public void calculateNextStep();
}
