package com.natasha.sourceit.task10;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public interface Card {

    Type getType();

    int getValue();

    Mast getMast();

    UncommonName getUncommonName();

    enum Type {
        COMMON, UNCOMMON;
    }

    enum Mast {
        HEART, DIAMOND, CLUB, SPADE;
    }

    enum UncommonName {
        VALET(11), DAMA(12), KING(15), TUZ(20);

        private int value;

        private UncommonName(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
