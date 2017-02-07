package com.company;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stas on 02.02.2017.
 */
public class CountryImpl implements Country {
    private String name;
    private List<State> states;

    public CountryImpl(String name, State... states) {
        this.name = name;
        this.states = Arrays.asList(states);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getPopulation() {
        long population = 0;
        for (State st : states){
            population = st.getPopulation() + population;
        }
        return population;
    }

    @Override
    public BigDecimal getSquare() {
        BigDecimal square = new BigDecimal(0);
        for (State st : states) {
            square = square.add(st.getSquare());
        }
        return square;
    }

    @Override
    public List<State> getStates() {
        return states;
    }
}
