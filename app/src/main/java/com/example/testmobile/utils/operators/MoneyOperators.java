package com.example.testmobile.utils.operators;

import static com.example.testmobile.R.color.*;
import static com.example.testmobile.R.id.*;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.MoneyConvertor;
import com.example.testmobile.utils.TextCalculator;

import java.math.BigDecimal;

public class MoneyOperators extends SpecialButtonOperationsImpl {

    private final Resources resources;
    //    Class to convert the value from the Currency selected.
    private final MoneyConvertor moneyConvertor;

    public MoneyOperators(TextCalculator resultView, Button[] buttons) {
        super(resultView, buttons);
        resources = buttons[0].getResources();
        this.moneyConvertor = new MoneyConvertor();
    }



    public void setOnclickListener() {
        View.OnClickListener listenerDefault = getOnClickListenerDefault();
        this.setOnclickListener(listenerDefault);
    }

    private void setLastButtonSelected(Button button) {
        if (buttons.contains(button)) {
            this.lastSelectedButton.setBackgroundColor(resources.getColor(button_default_color));
            this.lastSelectedButton = button;
            this.lastSelectedButton.setBackgroundColor(resources.getColor(selected_money_color));
        }
    }

    private View.OnClickListener getOnClickListenerDefault() {
        return view -> {
            Button buttonSelected = (Button) view;
            if (!this.resultsView.getText().isEmpty()) {
                getCalculateResult(buttonSelected);
            }
            this.setLastButtonSelected(buttonSelected);
        };
    }

    private void getCalculateResult(Button buttonSelected) {
        if (this.getLastButtonSelected() == buttonSelected) {
            return;
        }

        final BigDecimal resultDecimal;
        final double value;

        switch (this.lastSelectedButton.getId()) {

            case btn_dop:

                switch (buttonSelected.getId()) {
                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoDollar(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoFRANC(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoEURO(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;
                }

            case btn_dollar:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoDOP(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoFRANC(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoEURO(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;
                }

            case btn_euro:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoDOP(value);
                        resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoDOLLAR(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoFRANC(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;
                }

            case btn_franc:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoDOP(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoDOLLAR(value);
                        this.resultsView.setText(resultDecimal.toString());
                        return;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoEURO(value);
                        this.resultsView.setText(resultDecimal.toString());
//                        End of the inner decision.

                }
//                End of the super decision.
        }

    }

    private double getDoubleValue() {
        return Double.parseDouble(this.resultsView.getText());
    }


}