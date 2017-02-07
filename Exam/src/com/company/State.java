package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 31.01.2017.
 */
public interface State {
    Long getPopulation();
    BigDecimal getSquare();
    String getName();
}
