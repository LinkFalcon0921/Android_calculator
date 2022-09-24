package com.example.testmobile.utils.operators;

import static com.example.testmobile.R.id.*;
import static com.example.testmobile.R.drawable.*;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;

import com.example.testmobile.utils.convertors.MoneyConvertor;
import com.example.testmobile.utils.managers.TextCalculator;

import java.math.BigDecimal;

public class MoneyOperations extends SpecialButtonOperationsImpl {

    private final Resources resources;
    //    Class to convert the value from the Currency selected.
    private final MoneyConvertor moneyConvertor;

    public MoneyOperations(TextCalculator resultView, Button[] buttons, Button lastSelectedButton) {
        super(resultView, buttons);
        resources = buttons[0].getResources();
        this.moneyConvertor = new MoneyConvertor();
        this.lastSelectedButton = lastSelectedButton;
    }


    public void setOnclickListener() {
        View.OnClickListener listenerDefault = getOnClickListenerDefault();
        this.setOnclickListener(listenerDefault);
    }

    private void setLastButtonSelected(Button button) {
        if (buttons.contains(button)) {
            this.lastSelectedButton.setBackgroundResource(btn_circle);
            this.lastSelectedButton = button;
            this.lastSelectedButton.setBackgroundResource(btn_circle_selected);
        }
    }

    private View.OnClickListener getOnClickListenerDefault() {
        return view -> {
            Button buttonSelected = (Button) view;
            if (!this.resultsView.getValue().isEmpty()) {
                getCalculateResult(buttonSelected);
            }
            this.setLastButtonSelected(buttonSelected);
        };
    }

    private void getCalculateResult(Button buttonSelected) {
        if (this.getLastButtonSelected() == null || this.getLastButtonSelected() == buttonSelected) {
            return;
        }

        BigDecimal resultDecimal = BigDecimal.ZERO;
         double value;

        switch (this.getLastButtonSelected().getId()) {

            case btn_dop:

                switch (buttonSelected.getId()) {
                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoDollar(value);
                        break;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoFRANC(value);
                        break;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOPtoEURO(value);
                        break;
                }
                break;

            case btn_dollar:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoDOP(value);
                        break;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoFRANC(value);
                        break;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.DOLLARtoEURO(value);
                        break;
                }
                break;

            case btn_euro:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoDOP(value);
                        break;

                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoDOLLAR(value);
                        break;

                    case btn_franc:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.EUROtoFRANC(value);
                        break;
                }
                break;

            case btn_franc:

                switch (buttonSelected.getId()) {
                    case btn_dop:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoDOP(value);
                        break;

                    case btn_dollar:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoDOLLAR(value);
                        break;

                    case btn_euro:
                        value = getDoubleValue();
                        resultDecimal = this.moneyConvertor.FRANCtoEURO(value);
                        break;

//                        End of the inner decision.
                }
                break;
        }
//                End of the super decision.

        this.resultsView.setResults(resultDecimal.toString());

    }

    private double getDoubleValue() {
        return Double.parseDouble(this.resultsView.getValue());
    }


}
