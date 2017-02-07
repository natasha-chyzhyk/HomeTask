package com.natasha.sourceit.communal_payment.model;

/**
 * Created by Stas on 28.01.2017.
 */
public class DoubleIdDbModel {
    private long idPart1;
    private long idPart2;

    public DoubleIdDbModel(long idPart1, long idPart2) {
        this.idPart1 = idPart1;
        this.idPart2 = idPart2;
    }

    public long getIdPart2() {
        return idPart2;
    }

    public long getIdPart1() {
        return idPart1;
    }
}
