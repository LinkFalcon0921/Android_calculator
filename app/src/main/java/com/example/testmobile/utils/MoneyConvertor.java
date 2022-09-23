package com.example.testmobile.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyConvertor {

    //    Change the amount for the actual in case to refactor.
    public static final double DOP_DOLLAR_AMOUNT = 53.38D;
    public static final double DOP_EURO_AMOUNT = 52.51D;
    public static final double DOP_FRANC_AMOUNT = 54.57D;

    public static final double DOLLAR_FRANC_AMOUNT = 0.97D;
    public static final double DOLLAR_EURO_AMOUNT = 1.01D;

    public static final double EURO_FRANC_AMOUNT = 1.03D;

    public MoneyConvertor() {
    }

    //    DOP conversion
    public BigDecimal DOPtoDollar(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(DOP_DOLLAR_AMOUNT));
    }

    public BigDecimal DOLLARtoDOP(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(DOP_DOLLAR_AMOUNT));
    }

    public BigDecimal DOPtoEURO(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(DOP_EURO_AMOUNT));
    }

    public BigDecimal EUROtoDOP(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(DOP_EURO_AMOUNT));
    }

    public BigDecimal DOPtoFRANC(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(DOP_FRANC_AMOUNT));
    }

    public BigDecimal FRANCtoDOP(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(DOP_FRANC_AMOUNT));
    }

//    DOLLAR conversion

    public BigDecimal DOLLARtoFRANC(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(DOLLAR_FRANC_AMOUNT));
    }

    public BigDecimal FRANCtoDOLLAR(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(DOLLAR_FRANC_AMOUNT));
    }

    public BigDecimal DOLLARtoEURO(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(DOLLAR_EURO_AMOUNT));
    }

    public BigDecimal EUROtoDOLLAR(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(DOLLAR_EURO_AMOUNT));
    }

    //    FRANC corversion
    public BigDecimal FRANCtoEURO(double amount) {
        return getBigDecimal(amount)
                .divide(getBigDecimal(EURO_FRANC_AMOUNT));
    }

    public BigDecimal EUROtoFRANC(double amount) {
        return getBigDecimal(amount)
                .multiply(getBigDecimal(EURO_FRANC_AMOUNT));
    }

    private BigDecimal getBigDecimal(double amount) {
        return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_EVEN);
    }

}
