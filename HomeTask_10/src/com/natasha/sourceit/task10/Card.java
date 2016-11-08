package com.natasha.sourceit.task10;

/**
 * Created by Stas on 08.11.2016.
 */
public interface Card {

    Type getType();

    int getValue();

    SubType getSubType();

    enum Type {
        COMMON, UNCOMMON, JOKER;
    }

    enum SubType {
        HEART, DIAMOND, CLUB, SPADE;

    }
}
