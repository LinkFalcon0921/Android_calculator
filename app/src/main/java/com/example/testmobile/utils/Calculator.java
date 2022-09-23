package com.example.testmobile.utils;

import java.math.BigDecimal;

public class Calculator {
    public static final String EMPTY_STRING = "";
    private BigDecimal first, second;

    public Calculator() {
    }

    public void add(String amount){
        if(this.first == null){
            this.first = new BigDecimal(amount);
            return;
        }

        this.second = new BigDecimal(amount);
    }

    public String sum() {
        if (!isPossible()){
            return EMPTY_STRING;
        }

        this.first = first.add(this.second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String subtract() {
        if (!isPossible()){
            return EMPTY_STRING;
        }
        first = first.subtract(second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String multiply() {
        if (!isPossible()){
            return EMPTY_STRING;
        }
        first = first.multiply(second);
        this.clearSecondField();

        return this.first.toString();
    }

    public String divide() {
        try {
            if (!isPossible()){
                return EMPTY_STRING;
            }
            first = first.divide(second);
            this.clearSecondField();

            return this.first.toString();
        } catch (ArithmeticException e) {
        }

        return EMPTY_STRING;
    }

    private boolean isPossible() {
        return this.first != null && this.second != null;
    }

    private void clearSecondField(){
        this.second = null;
    }

    public void clearAllField(){
        this.first = null;
        this.second = null;
    }
}
