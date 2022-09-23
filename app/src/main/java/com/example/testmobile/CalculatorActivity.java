package com.example.testmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testmobile.utils.operators.MoneyOperators;
import com.example.testmobile.utils.TextCalculator;
import com.example.testmobile.utils.operators.NumbersOperations;
import com.example.testmobile.utils.operators.Operations;
import com.example.testmobile.utils.operators.SignalOperators;
import com.example.testmobile.utils.operators.SpecialButtonOperations;

public class CalculatorActivity extends AppCompatActivity {

    private TextCalculator resultView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_design_body);

//TextView
        TextView results = findViewById(R.id.tv_results);

//        Create the view manage the textView.
        this.resultView = new TextCalculator(results);

//        Money convertors buttons.
        Button dopDefaultButton = findViewById(R.id.btn_dop);
        Button[] buttonsConvertors = {
                dopDefaultButton,
                findViewById(R.id.btn_dollar),
                findViewById(R.id.btn_euro),
                findViewById(R.id.btn_franc)
        };
//      Manager to the MoneyConvertor
        SpecialButtonOperations moneyOperators = new MoneyOperators(this.resultView, buttonsConvertors, dopDefaultButton);
        moneyOperators.setOnclickListener();

        Button[] buttonsNumbers = {
                findViewById(R.id.btn_one),
                findViewById(R.id.btn_two),
                findViewById(R.id.btn_three),
                findViewById(R.id.btn_four),
                findViewById(R.id.btn_five),
                findViewById(R.id.btn_six),
                findViewById(R.id.btn_seven),
                findViewById(R.id.btn_eight),
                findViewById(R.id.btn_nine),
                findViewById(R.id.btn_zero)
        };
//      Manager to the numeric pad.
        Operations numbersOperations = new NumbersOperations(buttonsNumbers, this.resultView);
        numbersOperations.setOnclickListener();

//        Simple clear of the view.
        Button btn_simple_clear = findViewById(R.id.btn_simple_clear);
        btn_simple_clear.setOnClickListener(v -> this.resultView.backspaceResult());

//        Full clear of the view.
        Button btn_full_clear = findViewById(R.id.btn_full_clear);
        btn_full_clear.setOnClickListener(v -> this.resultView.clearResult());

//        Operations buttons
        Button[] buttonsSigns = {
                findViewById(R.id.btn_sum),
                findViewById(R.id.btn_subtract),
                findViewById(R.id.btn_multiply),
                findViewById(R.id.btn_divide)
        };
//      Manager of the operations calculator.
        SpecialButtonOperations signsOperations = new SignalOperators(buttonsSigns, this.resultView);
        signsOperations.setOnclickListener();
    }
}
