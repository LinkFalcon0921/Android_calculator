package com.example.testmobile.utils;

import java.math.BigDecimal;

public class Calculator {
    private BigDecimal first, second;
    private TextCalculator resultText;

    public Calculator(TextCalculator resultText) {
        this.resultText = resultText;
    }

    public boolean evaluate(){
        if (!isPossible()) {
            this.resultText.clearResult();
            return false;
        }

        if(this.second == null){
            this.resultText.setText(this.first.toString());
            return false;
        }

        return true;
    }

    public void add(String value) {
//        Evaluate if the first
        if (this.first == null || this.first.equals(BigDecimal.ZERO) || this.second != null) {
            this.first = new BigDecimal(value);
            return;
        }
        second = new BigDecimal(value);
    }

    public void sum() {
        if (!evaluate()){
            return;
        }
        this.first = first.add(this.second);
        this.clearSecondField();
        this.resultText.setText(this.first.toString());
    }

    public void subtract() {
        if (!evaluate()){
            return;
        }
        first = first.subtract(second);
        this.clearSecondField();
        this.resultText.setText(first.toString());
    }

    public void multiply() {
        if (!evaluate()){
            return;
        }
        first = first.multiply(second);
        this.clearSecondField();
        this.resultText.setText(first.toString());
    }

    public void divide() {
        try {
            if (!evaluate()){
                return;
            }
            first = first.add(second);
            this.clearSecondField();
            this.resultText.setText(first.toString());
        } catch (ArithmeticException e) {
            this.resultText.setText("Syntax Error");
        }
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
