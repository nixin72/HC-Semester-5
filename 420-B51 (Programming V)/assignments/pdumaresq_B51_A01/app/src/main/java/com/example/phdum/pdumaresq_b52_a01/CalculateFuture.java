package com.example.phdum.pdumaresq_b52_a01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import java.util.Locale;

public class CalculateFuture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_future);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        printValues((InvestmentCalculator) getIntent().getExtras().getSerializable("ic"));
    }

    private String format(double val) {
        return String.format(Locale.CANADA, "%.2f", val);
    }

    private void printValues(InvestmentCalculator i) {
        Double presentValue = i.getPresentValue();
        Double interestRate = i.getInterestRate();
        int timeInvested = i.getTimeInvested();
        int compoundFrequency = i.getCompoundFrequency();

        TextView values =  ((TextView) findViewById(R.id.txtTest));
        values.append("Initial Investment: $" + format(presentValue) + "\n");
        values.append("Interest Rate: " + format(interestRate*100) + "%\n");
        values.append("Years Invested: " + String.valueOf(timeInvested) + "\n");
        values.append("Compound Frequency: " + String.valueOf(compoundFrequency) + "\n\n");

        TextView years  =  ((TextView) findViewById(R.id.txtYear));
        TextView gather =  ((TextView) findViewById(R.id.txtGathered));
        TextView total  =  ((TextView) findViewById(R.id.txtTotal));
        double futureValue = presentValue;
        double interestGathered = 0;

        years.append("\r\n" + String.valueOf(0));
        gather.append("\r\n" + format(0));
        total.append("\r\n$" + format(futureValue));

        for (int x = 0 ; x < timeInvested ; x++) {
            for (int y = 0 ; y < compoundFrequency ; y++) {
                Double tmp = Math.pow(futureValue*(1+ (interestRate / compoundFrequency)), 1);
                interestGathered += tmp - futureValue;
                futureValue = tmp;
            }

            years.append("\r\n" + String.valueOf(x+1));
            gather.append("\r\n" + format(interestGathered));
            total.append("\r\n$" + format(futureValue));
            interestGathered = 0;
        }

        values.append("Final value: $" + format(futureValue));
    }
}
