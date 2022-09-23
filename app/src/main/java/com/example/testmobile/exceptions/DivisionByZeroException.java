package com.example.testmobile.exceptions;

public class DivisionByZeroException extends ArithmeticException{

    public static final String SYNTAX_ERROR = "Syntax Error";

    public DivisionByZeroException(String s) {
        super(s);
    }

    public DivisionByZeroException() {
        this(SYNTAX_ERROR);
    }
}
