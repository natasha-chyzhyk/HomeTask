package com.company;

import java.math.BigDecimal;

/**
 * Created by Stas on 02.02.2017.
 */
public class StateImpl implements State {
    private String name;
    private BigDecimal square;
    private long population;

    public StateImpl(String name, BigDecimal square, long population) {
        this.name = name;
        this.square = square;
        this.population = population;
    }

    @Override
    public Long getPopulation() {
        return population;
    }

    @Override
    public BigDecimal getSquare() {
        return square;
    }

    @Override
    public String getName() {
        return name;
    }
}
