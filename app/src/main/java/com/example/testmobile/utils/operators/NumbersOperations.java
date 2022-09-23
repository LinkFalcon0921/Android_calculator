package com.example.testmobile.utils.operators;

import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.TextCalculator;

import java.util.Arrays;

public class NumbersOperations extends OperationsImpl {
    private TextCalculator resultView;

    public NumbersOperations(Button[] numbersButtons, TextCalculator resultView) {
        super(resultView, numbersButtons);
    }

    @Override
    public void setOnclickListener(View.OnClickListener listener) {
        if (listener == null) {
            return;
        }
        for (Button button : this.buttons) {
            button.setOnClickListener(listener);
        }
    }

    @Override
    public void setOnclickListener() {
        View.OnClickListener listener = view -> {
            CharSequence buttonValue = ((Button) view).getText();
            this.resultView.addText(buttonValue);
        };

        this.setOnclickListener(listener);
    }
}
