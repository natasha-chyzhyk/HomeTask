package com.natasha.sourceit.task10;

/**
 * Created by Stas on 08.11.2016.
 */
public class CardImpl implements Card {
    private Type type;
    private int value;
    private SubType subType;

    public CardImpl(Type type, int value, SubType subType) {
        this.type = type;
        this.value = value;
        this.subType = subType;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public SubType getSubType() {
        return subType;
    }

    @Override
    public String toString() {
        return "{" + type+", "+subType+","+value+"}";
    }
}
