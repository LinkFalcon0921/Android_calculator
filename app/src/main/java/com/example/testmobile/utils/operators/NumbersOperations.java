package com.example.testmobile.utils.operators;

import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.TextCalculator;

public class NumbersOperations extends OperationsImpl {

    public NumbersOperations(Button[] numbersButtons, TextCalculator resultView) {
        super(resultView, numbersButtons);
    }

    @Override
    public void setOnclickListener() {
        View.OnClickListener listener = view -> {
            CharSequence buttonValue = ((Button) view).getText();
            this.resultsView.addText(buttonValue);
        };

        this.setOnclickListener(listener);
    }
}
