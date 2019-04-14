package com.example.phdum.pdumaresq_b51_a04;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmAbout: {
                startActivity(new Intent(this, About.class));
            } break;
            case R.id.mitmCalculator: {
                startActivity(new Intent(this, SelectMatrixSize.class));
            } break;
            case R.id.mitmOptions: {
                startActivity(new Intent(this, Options.class));
            } break;
            case R.id.mitmStoredEquations: {
                startActivity(new Intent(this, ViewSavedEquations.class));
            } break;
        }

        return item.getItemId() == R.id.mitmCalculator || super.onOptionsItemSelected(item);
    }

}
