package com.natasha.students.model;

/**
 * Created by Stas on 15.01.2017.
 */
public abstract class BaseDbModel {
    private long id;

    public BaseDbModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
