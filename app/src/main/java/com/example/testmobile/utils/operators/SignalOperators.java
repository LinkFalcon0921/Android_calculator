package com.example.testmobile.utils.operators;

import android.widget.Button;

import com.example.testmobile.utils.Calculator;
import com.example.testmobile.utils.TextCalculator;

import static com.example.testmobile.R.id.*;

public class SignalOperators extends SpecialButtonOperationsImpl {

    private Calculator calculator;

    public SignalOperators(TextCalculator resultView, Button[] buttons) {
        super(resultView, buttons);
        this.calculator = new Calculator(resultView);
    }

    @Override
    public void setAccessible(boolean accessible) {
        for (Button button : this.buttons) {
            button.setClickable(accessible);
        }
    }

    @Override
    public void setOnclickListener() {
        for (Button button : this.buttons) {
            switch (button.getId()){
                case btn_sum:
                    button.setOnClickListener(view -> {
                        this.calculator.sum();
                        this.calculate(button);
                    });
                    break;

                case btn_subtract:
                    button.setOnClickListener(view -> {
                        this.calculate(button);
                        this.calculator.subtract();
                    });
                    break;

                case btn_multiply:
                    button.setOnClickListener(view -> this.calculator.multiply());
                    break;

                case btn_divide:
                    button.setOnClickListener(view -> this.calculator.divide());
                    break;

                case btn_equals:
                    button.setOnClickListener(view -> {
                        this.lastSelectedButton.performClick();
                        this.calculator.clearAllField();
                        this.equalsAction();
                    });
                    break;
            }
        }
    }

    private void calculate(Button buttonSelected) {
        if (this.resultsView.isThrowSyntaxError()) {
            this.resultsView.clearResult();
        }
        if (getLastButtonSelected() == null) {
//            TODO SAVE AND THE CALCULATE VALUE.
            this.calculator.add(this.resultsView.getText());
//            TODO SAVE THE VALUE OF THE RESULT VIEW.
            this.resultsView.clearResult();
            return;
        }

        this.lastSelectedButton.performClick();
        this.lastSelectedButton = buttonSelected;
    }

    //Delete the last button when click equals button
    private void equalsAction() {
        this.lastSelectedButton = null;
    }


}
