package com.example.testmobile.utils.listeners;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.testmobile.utils.operators.Operations;

import java.util.Arrays;
import java.util.List;

public class EditorListenerImpl implements TextView.OnEditorActionListener {

    private List<Operations> buttonsOperations;

    public EditorListenerImpl(Operations[] buttonsOperations) {
        this.buttonsOperations = Arrays.asList(buttonsOperations);
        this.setAccessible(false);
    }

    @Override
    public boolean onEditorAction(TextView textView, int code, KeyEvent keyEvent) {
        boolean isValidated = !isValid(textView);

        InputMethodManager imm = (InputMethodManager) textView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(textView.getWindowToken(), 0);

        setAccessible(isValidated);
        return true;
    }

    private void setAccessible(boolean isValidated) {
        for (Operations operations : this.buttonsOperations) {
            operations.setAccessible(isValidated);
        }
    }

    private boolean isValid(TextView textView) {
        return textView.getText().length() < 1;
    }
}