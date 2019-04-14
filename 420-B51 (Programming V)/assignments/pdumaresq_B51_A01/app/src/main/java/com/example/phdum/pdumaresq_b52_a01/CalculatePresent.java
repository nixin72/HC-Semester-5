package com.example.phdum.pdumaresq_b52_a01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import java.util.Locale;

public class CalculatePresent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_present);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        printValues((InvestmentCalculator) getIntent().getExtras().getSerializable("ic"));
    }

    private String format(double val) {
        return String.format(Locale.CANADA, "%.2f", val);
    }

    private void printValues(InvestmentCalculator i) {
        Double futureValue = i.getFutureValue();
        Double interestRate = i.getInterestRate();
        int timeInvested = i.getTimeInvested();
        int compoundFrequency = i.getCompoundFrequency();

        TextView values =  ((TextView) findViewById(R.id.txtValues));
        values.append("Future Value: $" + format(futureValue) + "\n");
        values.append("Interest Rate: " + format(interestRate*100) + "%\n");
        values.append("Years Invested: " + String.valueOf(timeInvested) + "\n");
        values.append("Compound Frequency: " + String.valueOf(compoundFrequency) + "\n\n");

        TextView years  =  ((TextView) findViewById(R.id.txtPresentYear));
        TextView gather =  ((TextView) findViewById(R.id.txtPresentGathered));
        TextView total  =  ((TextView) findViewById(R.id.txtPresentTotal));
        double presentValue = futureValue;
        double interestGathered = 0;
        double last = 0;
        for (int x = 0 ; x < timeInvested ; x++) {
            for (int y = 0 ; y < compoundFrequency ; y++) {
                Double tmp = Math.pow(presentValue/(1+ (interestRate / compoundFrequency)), 1);
                interestGathered += tmp - presentValue;
                presentValue = tmp;
            }

            years.setText(String.valueOf(timeInvested-x-1) + "\n" + years.getText());
            gather.setText(format(interestGathered*-1.0) + "\n" + gather.getText());
            total.setText("$" + format(presentValue) + "\n" + total.getText());
            interestGathered = 0;
            if (x == 0) last = presentValue;
        }

        values.append("You must invest $" + format(presentValue));
        years.append(String.valueOf(timeInvested));
        gather.append(format(futureValue-last));
        total.append("$" + format(futureValue));
    }
}
