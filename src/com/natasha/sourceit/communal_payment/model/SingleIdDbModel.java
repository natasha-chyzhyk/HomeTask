package com.natasha.sourceit.communal_payment.model;

/**
 * Created by Stas on 27.01.2017.
 */
public abstract class SingleIdDbModel extends BaseDbModel {
    private long id;

    public SingleIdDbModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
