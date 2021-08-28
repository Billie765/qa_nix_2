package org.example.entity;

import java.math.BigDecimal;

public class Mars extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(0.642 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(6_792_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
