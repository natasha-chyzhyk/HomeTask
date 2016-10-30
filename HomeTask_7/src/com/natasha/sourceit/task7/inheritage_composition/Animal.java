package com.natasha.sourceit.task7.inheritage_composition;

public abstract class Animal {
    private String livingArea;
    private float age;
    private String name;

    public Animal(String name, float age, String area) {
        this.name = name;
        this.age = age;
        livingArea = area;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public abstract void sleep();

    public abstract Noise makeNoise();
}
