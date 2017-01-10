package com.natasha.sourceit.game.action;

import com.natasha.sourceit.game.character.Character;

/**
 * This is a general action definition, which can be done over target character
 */
public interface CharacterAction {

    /**
     * Do some action
     * @param character target character which an action is performed on
     */
    void doAction(Character character);
}
