package org.example.entity;

import java.math.BigDecimal;

public class Venus extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(4.87 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(12_104_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
