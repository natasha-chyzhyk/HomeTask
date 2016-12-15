package com.natasha.sourceit.task17corrected;

/**
 * Created by Stas on 15.12.2016.
 */
public class IceCream {
    public enum Taste{
        CHOCOLATE, VANILLA, STRAWBERRY, CHERRY, BLACKBERRY
    }

    public enum Color{
        BROWN, YELLOW, RED, PINK, PURPLE
    }

    public enum Smell{
        CHOCOLATE, VANILLA, STRAWBERRY, CHERRY, BLACKBERRY
    }

    public enum Size {
        SMALL, MEDIUM, DOUBLE
    }


    @Override
    public String toString() {
        return " taste: " +getTaste()+" color: "+getColor()+" smell: "+getSmell()+" size: "+getSize();
    }

    private Taste taste;
    private Size size;

    public IceCream(Taste taste, Size size) {
        this.taste = taste;
        this.size = size;
    }

    public Taste getTaste() {
        return taste;
    }

    public Size getSize() {
        return size;
    }

    public Color getColor() {
        switch (taste) {
            case CHOCOLATE:
                return Color.BROWN;
            case VANILLA:
                return Color.YELLOW;
            case STRAWBERRY:
                return Color.RED;
            case CHERRY:
                return Color.PINK;
            case BLACKBERRY:
                return Color.PURPLE;
        }
        return null;
    }

    public Smell getSmell() {
        switch (taste) {
            case CHOCOLATE:
                return Smell.CHOCOLATE;
            case VANILLA:
                return Smell.VANILLA;
            case STRAWBERRY:
                return Smell.STRAWBERRY;
            case CHERRY:
                return Smell.CHERRY;
            case BLACKBERRY:
                return Smell.BLACKBERRY;
        }
        return null;
    }
}
