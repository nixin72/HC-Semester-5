package com.example.phdum.pdumaresq_b51_a02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnPlayGame).setOnClickListener(this);
        findViewById(R.id.btnAbout).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnPlayGame: { i = new Intent(this, SelectDifficulty.class); }
                break;
            case R.id.btnAbout: { i = new Intent(this, About.class); }
                break;
            default:  i = new Intent(this, MainActivity.class);
        }

        startActivity(i);
    }
}
