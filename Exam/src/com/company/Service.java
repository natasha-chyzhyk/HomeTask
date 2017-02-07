package com.company;

import java.math.BigDecimal;

/**
 * Created by Stas on 02.02.2017.
 */
public interface Service {
    Long getCountryPopulation(String name);
    Country getOvercrowdedCountry();
    BigDecimal getCountrySquare(String name);
    BigDecimal getTotalDensityOfPeople(String name);
    BigDecimal getAverageDensityOfPeopleByStates(String name);
    String getOvercrowdedState(String name);
    String getBiggestState(String name);
}
