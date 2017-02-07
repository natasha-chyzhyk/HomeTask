package com.company;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Stas on 03.02.2017.
 */
public class ServiceImpl implements Service {
    private Map<String, Country> map = new HashMap<>();

    public ServiceImpl(Set<Country> countries) {
        for (Country c : countries) {
            map.put(c.getName(), c);
        }
    }

    @Override
    public Long getCountryPopulation(String name) { //OK
        Country country = map.get(name);
        return country.getPopulation();
    }

    @Override
    public Country getOvercrowdedCountry() { //OK
        BigDecimal maxDens = new BigDecimal(0);
        Country maxCountry = null;

        for (String cName : map.keySet()) {
            BigDecimal currDens = getTotalDensityOfPeople(cName);
            if (currDens.compareTo(maxDens) > 0) {
                maxCountry = map.get(cName);
                maxDens = currDens;
            }
        }
        return maxCountry;
    }

    @Override
    public BigDecimal getCountrySquare(String name) { //OK
        Country country = map.get(name);
        return country.getSquare();
    }

    @Override
    public BigDecimal getTotalDensityOfPeople(String name) {  //OK
        Country country = map.get(name);
        BigDecimal population = new BigDecimal(country.getPopulation());
        return population.divide(country.getSquare());
    }

    @Override
    public BigDecimal getAverageDensityOfPeopleByStates(String name) {  //OK
        int size = map.get(name).getStates().size();
        return getTotalDensityOfPeople(name).divide(new BigDecimal(size));
    }

    @Override
    public String getOvercrowdedState(final String countryName) { //OK
        List<State> states = map.get(countryName).getStates();
        BigDecimal maxDens = new BigDecimal(0);
        String stateName = null;
        for (State state : states){
            BigDecimal population = (new BigDecimal(state.getPopulation()));
            BigDecimal den = population.divide(state.getSquare());
            if(den.compareTo(maxDens) > 0){
                maxDens = den;
                stateName = state.getName();
            }
        }
        return stateName;
    }

    @Override
    public String getBiggestState(String name) {
        List<State> states = map.get(name).getStates();
        BigDecimal bigSt = new BigDecimal(0);
        String stateName = null;
        for (State state : states){
            BigDecimal maxSq = state.getSquare();
            if(maxSq.compareTo(bigSt) > 0){
                bigSt = maxSq;
                stateName = state.getName();
            }
        }
        return stateName;
    }
}
