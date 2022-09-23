package com.example.testmobile.utils.operators;

import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.TextCalculator;

import java.util.Arrays;
import java.util.List;

abstract class OperationsImpl implements Operations {
    protected final TextCalculator resultsView;
    protected final List<Button> buttons;

    public OperationsImpl(TextCalculator resultsView, Button[] buttons) {
        this.resultsView = resultsView;
        this.buttons = Arrays.asList(buttons);
    }

    /*Default action for the money button*/
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
    public void setAccessible(boolean accessible) {
        for (Button button : this.buttons) {
            button.setClickable(accessible);
        }
    }
}
