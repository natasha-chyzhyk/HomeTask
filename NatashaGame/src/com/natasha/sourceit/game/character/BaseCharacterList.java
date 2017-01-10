package com.natasha.sourceit.game.character;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to hold all characters of the game. It is used in the Game Controller.
 */
public class BaseCharacterList extends ArrayList<BaseCharacter> {

    public BaseCharacterList() {
        super();
    }

    /**
     * Get all characters which are near the requested one.
     * This is used in fight logic!
     * @param c
     * @param targets
     * @return
     */
    public List<BaseCharacter> getCharactersNear(BaseCharacter c, List<BaseCharacter> targets) {
        if (targets == null) {
            targets = new ArrayList<>();
        } else {
            targets.clear();
        }
        for(BaseCharacter car : this) {
            if (car.getPosition().equals(c.getPosition())) {
                continue;
            }

            int dx = car.getPosition().x - c.getPosition().x;
            int dy = car.getPosition().y - c.getPosition().y;
            if (Math.abs(dx)<=1 & Math.abs(dy)<=1) {
                targets.add(car);
            }

        }
        return targets;
    }

}
