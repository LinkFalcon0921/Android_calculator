package com.example.testmobile.utils.operators;

import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.Calculator;
import com.example.testmobile.utils.ResultDefault;
import com.example.testmobile.utils.TextCalculator;

import static com.example.testmobile.R.id.*;
import static com.example.testmobile.utils.ResultDefault.EMPTY;

public class SignalOperators extends SpecialButtonOperationsImpl {

    private Calculator calculator;

    public SignalOperators(Button[] buttons, TextCalculator resultView) {
        super(resultView, buttons);
        this.calculator = new Calculator();
    }

    @Override
    public void setAccessible(boolean accessible) {
        for (Button button : this.buttons) {
            button.setClickable(accessible);
        }
    }

    @Override
    public void setOnclickListener() {
        View.OnClickListener listener = view -> this.calculate(((Button) view));

        this.setOnclickListener(listener);
    }

    private void calculate(Button buttonSelected) {
//        Do nothing if the has an Syntax
        if (this.resultsView.isThrowSyntaxError()) {
            return;
        }

        this.calculator.add(this.resultsView.getValue());

        if (getLastButtonSelected() == null) {
            this.lastSelectedButton = buttonSelected;
            this.resultsView.clearResult();
            return;
        }

        String valueResult = getResultBySign(buttonSelected);

        this.resultsView.setValue(valueResult);

    }

    private String getResultBySign(Button buttonSelected) {
        String valueResult;

        switch (buttonSelected.getId()) {
            case btn_sum:
                valueResult = this.calculator.sum();
                break;
            case btn_subtract:
                valueResult = this.calculator.subtract();
                break;
            case btn_multiply:
                valueResult = this.calculator.multiply();
                break;
            case btn_divide:
                valueResult = this.calculator.divide();
                break;
//                for equals button
            default:
                valueResult = this.getResultBySign(this.getLastButtonSelected());
                equalsAction();
        }

        return valueResult;
    }

    //Delete the last button when click equals button
    private void equalsAction() {
        this.lastSelectedButton = null;
        this.calculator.clearAllField();
    }


}
