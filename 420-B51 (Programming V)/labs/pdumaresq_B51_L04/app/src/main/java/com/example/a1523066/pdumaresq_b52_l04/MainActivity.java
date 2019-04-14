package com.example.a1523066.pdumaresq_b52_l04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Double tipAmount = 0.0;
    public enum codes {
        TIP(0), SHARE(1);
        private final int value;
        codes(int value) { this.value = value; }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnTip).setOnClickListener(this);
        findViewById(R.id.btnShare).setOnClickListener(this);
        findViewById(R.id.btnAbout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTip: startActivity(new Intent(this, CalculateTip.class));
                break;
            case R.id.btnShare: {
                Intent i = new Intent(this, Share.class);
                i.putExtra("tip", tipAmount);
                startActivityForResult(i, codes.SHARE.value);
            }
                break;
            case R.id.btnAbout: startActivity(new Intent(this, About.class));
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == codes.TIP.value) {
            tipAmount = Double.parseDouble(data.getStringExtra("tipAmount"));
        }
    }
}
