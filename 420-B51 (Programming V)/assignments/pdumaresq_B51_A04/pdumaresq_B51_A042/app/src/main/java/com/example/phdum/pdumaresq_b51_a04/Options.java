package com.example.phdum.pdumaresq_b51_a04;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Options extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] size = new String[20];
        for (int q = 0 ; q < 20 ; q++ ) {
            size[q] = String.valueOf((q+1)*5);
        }
        ((Spinner) findViewById(R.id.spnMaxDbEntries)).setAdapter(
                new ArrayAdapter<>(
                        this, android.R.layout.simple_spinner_item, size
                )
        );

        final SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ((Spinner)findViewById(R.id.spnMaxRows)).setSelection(settings.getInt("maxRows", 4)-1);
        ((Spinner)findViewById(R.id.spnMaxCols)).setSelection(settings.getInt("maxCols", 4)-1);
        ((Spinner)findViewById(R.id.spnMaxDbEntries)).setSelection((settings.getInt("maxEntries",50)/5)-1);

        findViewById(R.id.btnSaveMaxSize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = settings.edit();

                int rows = ((Spinner)findViewById(R.id.spnMaxRows)).getSelectedItemPosition()+1;
                int cols = ((Spinner)findViewById(R.id.spnMaxCols)).getSelectedItemPosition()+1;

                edit.putInt("maxRows", rows);
                edit.putInt("maxCols", cols);
                edit.apply();

                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                int numDeleted = db.removeLargeMatrices(rows, cols);
                if (numDeleted > 0) {
                    Toast.makeText(
                            getApplicationContext(),
                            "All matrices with more rows or columns have been deleted from your database.\n" +
                                    numDeleted + " matrices have been removed",
                            Toast.LENGTH_LONG
                    ).show();
                }
                else {
                    confirmChanges();
                }
                db.close();
            }
        });


        findViewById(R.id.btnSaveColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((Spinner)findViewById(R.id.spnColorScheme)).getSelectedItemPosition()) {
                    case 0: {

                    }
                    case 1: {

                    }
                    case 2: {

                    }
                }
                confirmChanges();
            }
        });


        findViewById(R.id.btnSaveDb).setOnClickListener(this);

        findViewById(R.id.btnDeleteDb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.resetDatabase();
                Toast.makeText(
                    getApplicationContext(), "The database has been reset.", Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    void confirmChanges() {
        Toast.makeText(
                getApplicationContext(), "Your changes have been saved.", Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void onClick(View view) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        final int newMax = (((Spinner)findViewById(R.id.spnMaxDbEntries)).getSelectedItemPosition()+1)*5;

        if (newMax < db.getNumMatrices()) {
            Toast.makeText(
                this, "The database's maximum entries has been changes, the oldest " +
                            (db.getNumMatrices() - newMax) + " matrices have been removed",
                Toast.LENGTH_LONG
            ).show();

            db.removeOldRows(db.getNumMatrices() - newMax);
        }
        else {
            confirmChanges();
        }

        SharedPreferences.Editor edit = settings.edit();
        edit.putInt("maxEntries", newMax);
        edit.apply();
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