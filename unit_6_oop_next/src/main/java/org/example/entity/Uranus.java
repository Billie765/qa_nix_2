package org.example.entity;

import java.math.BigDecimal;

public class Uranus extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(86.8 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(51_118_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
