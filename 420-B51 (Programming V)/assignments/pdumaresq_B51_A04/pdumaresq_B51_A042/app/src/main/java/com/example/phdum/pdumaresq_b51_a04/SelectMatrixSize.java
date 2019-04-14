package com.example.phdum.pdumaresq_b51_a04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectMatrixSize extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_matrix_size);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String[] rows = new String[settings.getInt("maxRows", 4)];
        String[] cols = new String[settings.getInt("maxCols", 4)];

        for (int r = 0 ; r < rows.length ; r++ ) {
            rows[r] = String.valueOf(r+1);
        }
        for (int c = 0 ; c < cols.length ; c++ ) {
            cols[c] = String.valueOf(c+1);
        }

        Spinner matrixRows = (Spinner) findViewById(R.id.spnMatrixRows);
        matrixRows.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, rows));

        Spinner matrixCols = (Spinner) findViewById(R.id.spnMatrixColumns);
        matrixCols.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cols));

        findViewById(R.id.btnCalculate).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_select_size, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmAbout: {
                startActivity(new Intent(this, About.class));
            } break;
            case R.id.mitmOptions: {
                startActivity(new Intent(this, Options.class));
            } break;
            case R.id.mitmStoredEquations: {
                startActivity(new Intent(this, ViewSavedEquations.class));
            } break;
        }

        int id = item.getItemId();
        return id == R.id.mitmCalculator || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculate) {
            Bundle b = new Bundle();

            int rows = ((Spinner)findViewById(R.id.spnMatrixRows)).getSelectedItemPosition();
            int cols = ((Spinner)findViewById(R.id.spnMatrixColumns)).getSelectedItemPosition();
            b.putSerializable("matrix", new Matrix(rows+1, cols+1));

            Intent i = new Intent(this, Calculator.class);
            i.putExtras(b);

            startActivity(i);
        }
    }
}
