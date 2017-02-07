package com.company;

/**
 * Created by Stas on 31.01.2017.
 */
import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface Country {
    String getName();
    Long getPopulation();
    BigDecimal getSquare();
    List<State> getStates();
}
