package org.example.entity;

import java.math.BigDecimal;

public class Mercury extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(0.330 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(4_879_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
