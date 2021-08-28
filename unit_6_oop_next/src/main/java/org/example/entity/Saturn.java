package org.example.entity;

import java.math.BigDecimal;

public class Saturn extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(568 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(120_536_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
