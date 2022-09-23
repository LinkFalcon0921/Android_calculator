package com.example.testmobile.utils;

import android.widget.TextView;
import static com.example.testmobile.utils.ResultDefault.*;

import com.example.testmobile.exceptions.DivisionByZeroException;

/*Class to manage the textView for add numbers for calculator.*/
public class TextCalculator {

    private final TextView results;

    public TextCalculator(TextView view) {
        this.results = view;
    }

    public void addText(CharSequence nextText) {
        if (!this.isSpecialCharacterAlreadyExists(nextText)) {
            this.add(nextText);
        }
    }

    public void setValue(CharSequence nextText) {
        results.setText(nextText);
    }

    public String getValue() {
        return results.getText().toString();
    }

    public void backspaceResult() {
        int length = results.getText().length();
        if (length > ONE) {
            results.setText(results.getText().subSequence(ZERO, length - 1));
        }
        if (length == ONE) {
            setEmpty();
        }
    }

    public void clearResult() {
        results.setText(EMPTY_DEFAULT_TEXT);
    }

    private void setEmpty() {
        add(EMPTY_DEFAULT_TEXT);
    }

    private void add(CharSequence nextText) {
        if (!results.getText().equals(EMPTY_DEFAULT_TEXT) && this.getValue().equals(nextText)) {
            return;
        }
//        Syntax error checker
        if (isThrowSyntaxError()) {
            clearResult();
        }

        this.results.setText(String.join(EMPTY, results.getText(), nextText));
    }

//    Check in case throw a error when the calculator fails.
    public boolean isThrowSyntaxError() {
        return this.getValue().equals(DivisionByZeroException.SYNTAX_ERROR);
    }

    private boolean isSpecialCharacterAlreadyExists(CharSequence nextText) {
        return isSpecialCharacter(nextText.charAt(ZERO)) && results.getText().toString().contains(nextText);
    }

    private boolean isSpecialCharacter(char nextChar) {
        return !Character.isDigit(nextChar);
    }
}
