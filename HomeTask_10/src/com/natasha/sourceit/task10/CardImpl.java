package com.natasha.sourceit.task10;

/**
 * Created by denis.selutin on 04.11.2016.
 */
public class CardImpl implements Card {
    private Type type;
    private int value;
    private Mast mast;
    private UncommonName uncommonName;


    public static Card createCommonCard(Mast mast, int value) {
        CardImpl card = new CardImpl(Type.COMMON, mast);
        card.value = value;
        return card;
    }

    public static Card createUncommonCard(Mast mast, UncommonName name) {
        CardImpl card = new CardImpl(Type.UNCOMMON, mast);
        card.uncommonName = name;
        return card;
    }


    private CardImpl(Type type, Mast mast) {
        this.type = type;
        this.mast = mast;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getValue() {
        switch (type) {
            case COMMON:
                return value;
            case UNCOMMON:
                return uncommonName.getValue();
        }
        return 0;
    }

    @Override
    public Mast getMast() {
        return mast;
    }

    @Override
    public UncommonName getUncommonName() {
        return uncommonName;
    }

    @Override
    public String toString() {
        switch (type) {
            case COMMON:
                return "{" + type+", "+ mast +","+getValue()+"}";
            case UNCOMMON:
                return "{" + uncommonName+", "+ mast +","+getValue()+"}";
        }
        return null;
    }
}
