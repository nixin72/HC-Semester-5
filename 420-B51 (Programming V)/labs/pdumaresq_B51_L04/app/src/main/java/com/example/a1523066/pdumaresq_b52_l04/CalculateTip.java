package com.example.a1523066.pdumaresq_b52_l04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Locale;

public class CalculateTip extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private Double customTip = 15.0;

    private void doTheThing() {
        String amount = ((EditText) findViewById(R.id.editText)).getText().toString();

        if (!amount.equals("")) {
            Double amount2 = Double.parseDouble(amount);
            ((TextView) findViewById(R.id.txt15Tip)).setText(String.format(Locale.CANADA, "%.2f", amount2 * 0.15));
            ((TextView) findViewById(R.id.txt15Total)).setText(String.format(Locale.CANADA, "%.2f", amount2 * 1.15));
            ((TextView) findViewById(R.id.txtCustomTip)).setText(String.format(Locale.CANADA, "%.2f", amount2 * (customTip/100)));
            ((TextView) findViewById(R.id.txtCustomTotal)).setText(String.format(Locale.CANADA, "%.2f", amount2 * (1+(customTip/100))));
        }
        else {
            ((TextView) findViewById(R.id.txt15Tip)).setText("0");
            ((TextView) findViewById(R.id.txt15Total)).setText("0");
            ((TextView) findViewById(R.id.txtCustomTip)).setText("0");
            ((TextView) findViewById(R.id.txtCustomTotal)).setText("0");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_tip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnBack).setOnClickListener(this);
        ((SeekBar) findViewById(R.id.seekCustomPercent)).setOnSeekBarChangeListener(this);
        ((EditText) findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doTheThing();
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void afterTextChanged(Editable s) { }
        });

        findViewById(R.id.txt15Total).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retVal = new Intent();
                retVal.putExtra("tipAmount", ((TextView)findViewById(R.id.txt15Total)).getText().toString());
                setResult(RESULT_OK, retVal);
                finish();
            }
        });

        findViewById(R.id.txtCustomTotal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retVal = new Intent();
                retVal.putExtra("tipAmount", ((TextView)findViewById(R.id.txt15Total)).getText().toString());
                setResult(RESULT_OK, retVal);
                finish();
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        customTip = Double.parseDouble(String.valueOf(progress));
        ((TextView) findViewById(R.id.txtCustomPercent)).setText(String.valueOf(customTip));

        doTheThing();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBack)
            startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { }
}