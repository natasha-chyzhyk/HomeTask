package com.natasha.sourceit.task_jdbc.model;

/**
 * Created by Stas on 17.01.2017.
 */
public abstract class BaseDbModel {
    private int id;

    public BaseDbModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
