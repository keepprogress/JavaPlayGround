package com.nick.playground.mainmethods;

import java.math.BigDecimal;

public class SubtractionOfBigDecimal {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("50");
        BigDecimal c = a.subtract(b);
        System.out.println(c);
    }
}
