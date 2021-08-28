package org.example.entity;

import java.math.BigDecimal;

public class Jupyter extends BasePlanet{

    private BigDecimal weight = BigDecimal.valueOf(1898 * Math.pow(10,24));
    private BigDecimal diameter = BigDecimal.valueOf(142_984_000);

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getDiameter() {
        return diameter;
    }
}
