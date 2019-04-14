package com.example.phdum.pdumaresq_b52_a01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements  SeekBar.OnSeekBarChangeListener,
        View.OnClickListener, Switch.OnCheckedChangeListener {

    private int presOrFutu = 0; //0 == present ,  1 == future

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnCalculateValue).setOnClickListener(this);
        ((Switch)findViewById(R.id.swiPresentFuture)).setOnCheckedChangeListener(this);

        ((TextView) findViewById(R.id.txtInterestRateValue))
                .setText(String.valueOf(((SeekBar) findViewById(R.id.skbInterestRate)).getProgress()/10.0));
        ((TextView) findViewById(R.id.txtTimeInvestedValue)).setText("10");
        ((SeekBar) findViewById(R.id.skbInterestRate)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.skbTimeInvested)).setOnSeekBarChangeListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.frequency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculateValue: {
                try {
                    String value   = ((EditText) findViewById(R.id.edtValue)).getText().toString();
                    if (Double.parseDouble(value) <= 0)
                        throw new NumberFormatException("greater than 0");
                    String interestRate   = String.valueOf(((SeekBar) findViewById(R.id.skbInterestRate)).getProgress());
                    int timeInvested      = ((SeekBar) findViewById(R.id.skbTimeInvested)).getProgress();
                    int compoundFrequency = 12;
                    switch (((Spinner) findViewById(R.id.spinner)).getSelectedItemPosition()) {
                        case 1: compoundFrequency = 4;  break;
                        case 2: compoundFrequency = 2;  break;
                        case 3: compoundFrequency = 1;  break;
                    }

                    InvestmentCalculator i = new InvestmentCalculator(
                        presOrFutu == 0 ? Double.parseDouble(value) : 0, //present
                        presOrFutu == 1 ? Double.parseDouble(value) : 0, //future
                        Double.parseDouble(interestRate)/1000.0 , timeInvested, compoundFrequency
                    );

                    Intent calc = new Intent(this, presOrFutu != 0 ?
                                CalculatePresent.class : CalculateFuture.class);
                    Bundle data = new Bundle();
                    data.putSerializable("ic", i);
                    calc.putExtras(data);
                    startActivity(calc);
                }
                catch (NumberFormatException e) {
                    Toast.makeText(
                            this, "Please enter a value " +
                                (e.getMessage().equals("greater than 0") ? " " + e.getMessage() : "") + ".",
                            Toast.LENGTH_SHORT
                    ).show();
                    e.printStackTrace();
                }
            } break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        presOrFutu = isChecked ? 1 : 0;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId() == R.id.skbTimeInvested) {
            ((TextView) findViewById(R.id.txtTimeInvestedValue)).setText(String.valueOf(progress));
            if (progress < 1)
                ((SeekBar) findViewById(R.id.skbTimeInvested)).setProgress(1);
        }
        else if (seekBar.getId() == R.id.skbInterestRate) {
            ((TextView) findViewById(R.id.txtInterestRateValue)).setText(String.valueOf(progress / 10.0));
            if (progress < 5)
                ((SeekBar) findViewById(R.id.skbInterestRate)).setProgress(5);
        }
    }

    @Override //Seekbar
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override //Seekbar
    public void onStopTrackingTouch(SeekBar seekBar) {}
}