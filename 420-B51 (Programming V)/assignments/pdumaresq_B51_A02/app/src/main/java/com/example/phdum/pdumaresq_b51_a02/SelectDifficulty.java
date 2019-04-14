package com.example.phdum.pdumaresq_b51_a02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SelectDifficulty extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnEasy).setOnClickListener(this);
        findViewById(R.id.btnMedium).setOnClickListener(this);
        findViewById(R.id.btnHard).setOnClickListener(this);
        findViewById(R.id.btnExpert).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int diff;
        switch (v.getId()) {
            case R.id.btnEasy: { diff = 0; }
                break;
            case R.id.btnMedium: { diff = 1; }
                break;
            case R.id.btnHard: { diff = 3; }
                break;
            case R.id.btnExpert: { diff = 5; }
                break;
            default: {
                diff = 0;
            }
        }

        Bundle b = new Bundle();
        b.putInt("diff", diff);
        Intent i = new Intent(this, PlayGame.class);
        i.putExtras(b);
        startActivity(i);
    }
}
