package com.natasha.sourceit.task9;

/**
 * Created by Stas on 30.11.2016.
 */
public interface Character {
    public boolean canDoAction(CharacterAction action);
    public void doAction(CharacterAction action);
    public int getHealth();
    public void modifyHealth(int val);
    public boolean isNpc();
    public boolean canMove();
}
