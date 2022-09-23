package com.example.testmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testmobile.utils.operators.MoneyOperators;
import com.example.testmobile.utils.TextCalculator;

public class CalculatorActivity extends AppCompatActivity {

    private TextCalculator resultView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_design_body);


        TextView results = findViewById(R.id.tv_results);

//        Create the view manage the textView.
        resultView = new TextCalculator(results);

//        Money convertors buttons.
        Button[] buttonsConvertors = {
                findViewById(R.id.btn_dop),
                findViewById(R.id.btn_dollar),
                findViewById(R.id.btn_euro),
                findViewById(R.id.btn_franc)
        };

        MoneyOperators moneyOperators = new MoneyOperators(resultView, buttonsConvertors);
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


        Button btn_simple_clear = findViewById(R.id.btn_simple_clear);

        btn_simple_clear.setOnClickListener(v -> resultView.backspaceResult());

    }
}
