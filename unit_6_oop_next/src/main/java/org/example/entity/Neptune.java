package org.example.entity;

import java.math.BigDecimal;

public class Neptune extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(102 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(49_528_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
