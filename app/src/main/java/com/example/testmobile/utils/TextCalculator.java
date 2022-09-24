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
        if (this.isSpecialCharacterAlreadyExists(nextText)) {
            return;
        }
        this.add(nextText);
    }

    public void setResults(CharSequence result){
        this.setValue(result);
    }

    private void setValue(CharSequence nextText) {
        this.results.setText(nextText);
    }

    public String getValue() {
        return this.results.getText().toString();
    }

    public void backspaceResult() {
        if(this.isClear()){
            return;
        }
//        Variable
        int length = results.getText().length();

        if (length == ONE) {
            this.clearResult();
            return;
        }

        this.setValue(this.getValue().subSequence(ZERO, length - 1));


    }

    public void clearResult() {
        this.setValue(EMPTY_DEFAULT_TEXT);
    }

    private void add(CharSequence nextText) {
        if (this.isClear() && nextText.equals(EMPTY_DEFAULT_TEXT)) {
            return;
        }
//        Syntax error checker
        if (this.isThrowSyntaxError()) {
            this.clearResult();
        }

        if(this.isClear()){
            this.setValue(EMPTY);
        }

        this.setValue(String.join(EMPTY, this.getValue(), nextText));
    }

    //    Check in case throw a error when the calculator fails.
    public boolean isThrowSyntaxError() {
        return this.matchWith(DivisionByZeroException.SYNTAX_ERROR);
    }

//    Check if the text has been clear.
    public boolean isClear(){
        return this.matchWith(EMPTY_DEFAULT_TEXT);
    }

    public boolean matchWith(CharSequence value){
        return this.getValue().equals(value);
    }

    private boolean isSpecialCharacterAlreadyExists(CharSequence nextText) {
        return isSpecialCharacter(nextText.charAt(ZERO)) && this.getValue().contains(nextText);
    }

    private boolean isSpecialCharacter(char nextChar) {
        return !Character.isDigit(nextChar);
    }
}
