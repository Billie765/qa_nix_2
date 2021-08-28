package org.example.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PlanetCalcImpl implements Planet{

    private final BigDecimal GRAVITYCONST = BigDecimal.valueOf(6.67 * Math.pow(10, -11));

    @Override
    public BigDecimal calculateAcceleration(BigDecimal diameter, BigDecimal weight) {
        BigDecimal radius = diameter.divide(BigDecimal.valueOf(2));
        BigDecimal acceleration = GRAVITYCONST.multiply(weight.divide(radius.pow(2), 2, RoundingMode.HALF_EVEN));
        return acceleration;
    }
}
