package com.example.a1523066.clevercalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnCelToFahr).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double val = Double.parseDouble(((TextView)findViewById(R.id.txtEnterVal)).getText().toString());
                setLblText("C", val, "F", ((val*9)/5)+32);
            }
        });

        findViewById(R.id.btnCmToInch).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double val = Double.parseDouble(((TextView)findViewById(R.id.txtEnterVal)).getText().toString());
                setLblText("cm", val, "in", val*2.54);
            }
        });

        findViewById(R.id.btnGramToOz).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double val = Double.parseDouble(((TextView)findViewById(R.id.txtEnterVal)).getText().toString());
                setLblText("g", val, "oz", val/28.35);
            }
        });

        findViewById(R.id.btnKgToLbs).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Double val = Double.parseDouble(((TextView)findViewById(R.id.txtEnterVal)).getText().toString());
                setLblText("Kg", val, "lbs", val*2.2);
            }
        });

    }

    protected void setLblText(String unit1, Double value1, String unit2, Double value2) {
        ((TextView) findViewById(R.id.lblAnswer)).setText(value1.toString() + " " + unit1 + " = " + value2.toString() + " " + unit2);
    }

}
