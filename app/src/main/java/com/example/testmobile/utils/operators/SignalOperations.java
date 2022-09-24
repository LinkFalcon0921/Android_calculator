package com.example.testmobile.utils.operators;

import android.widget.Button;

import com.example.testmobile.utils.calculator.Calculator;
import com.example.testmobile.utils.managers.TextCalculator;

import static com.example.testmobile.R.id.*;

public class SignalOperations extends SpecialButtonOperationsImpl {

    private Calculator calculator;

    public SignalOperations(Button[] buttons, TextCalculator resultView, Calculator calculator) {
        super(resultView, buttons);
        this.calculator = calculator;
    }

    @Override
    public void setAccessible(boolean accessible) {
        for (Button button : this.buttons) {
            button.setClickable(accessible);
        }
    }

    @Override
    public void setOnclickListener() {
        this.setOnclickListener(view -> this.calculate(((Button) view)));
    }

    private void calculate(Button buttonSelected) {
        //        Do nothing if the has an Syntax
        if (this.resultsView.isThrowSyntaxError()
                || buttonSelected.equals(this.getLastButtonSelected())) {
            return;
        }

        this.calculator.add(this.resultsView.getValue());
        this.resultsView.clearResult();

        if (getLastButtonSelected() == null && buttonSelected.getId() != btn_equals) {
            setLastSelectedButton(buttonSelected);
            return;
        }

        String valueResult = getResultBySign(buttonSelected);

        this.resultsView.setResults(valueResult);
    }

    private void setLastSelectedButton(Button buttonSelected) {
        this.lastSelectedButton = buttonSelected;
        this.resultsView.clearResult();
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
                clearComponentsActions();
        }

        return valueResult;
    }

    //Delete the last button when click equals button
    public void clearComponentsActions() {
        this.lastSelectedButton = null;
        this.calculator.clearAllField();
    }


}
