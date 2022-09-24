package com.example.testmobile.utils.operators;

import android.widget.Button;

import com.example.testmobile.utils.calculator.Calculator;
import com.example.testmobile.utils.managers.TextCalculator;

import static com.example.testmobile.R.id.*;

/*Clear button actions manager.*/
public class ClearOperations extends OperationsImpl {
    private Calculator calculator;
    private final ExternalActions fullClearActions;

//    For action to map match external actions.
    @FunctionalInterface
    public interface ExternalActions{
        void make();
    }


    public ClearOperations(TextCalculator resultsView, Button[] buttons, Calculator calculator, ExternalActions fullClearActions) {
        super(resultsView, buttons);
        this.calculator = calculator;
        this.fullClearActions = fullClearActions;
    }

    @Override
    public void setOnclickListener() {
        this.setOnclickListener(view -> clear(((Button) view)));
    }

    private void clear(Button button) {
        switch (button.getId()) {
            case btn_simple_clear:
                this.resultsView.backspaceResult();
                break;
            case btn_full_clear:
                this.resultsView.clearResult();
                this.fullClearActions.make();

        }
    }
}
