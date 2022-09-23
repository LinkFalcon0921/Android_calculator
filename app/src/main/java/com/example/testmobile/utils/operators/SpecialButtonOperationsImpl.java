package com.example.testmobile.utils.operators;

import android.widget.Button;

import com.example.testmobile.utils.TextCalculator;

abstract class SpecialButtonOperationsImpl extends OperationsImpl implements SpecialButtonOperations{

    protected Button lastSelectedButton;

    public SpecialButtonOperationsImpl(TextCalculator resultView, Button[] buttons) {
        super(resultView, buttons);
    }

    @Override
    public Button getLastButtonSelected() {
        return this.lastSelectedButton;
    }
}
