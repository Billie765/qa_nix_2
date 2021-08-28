package org.example.entity;

import java.math.BigDecimal;

public class Earth extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(5.97 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(12_756_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
