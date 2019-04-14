package com.example.a1523066.pdumaresq_b51_a03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Options extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences spOptions;
        spOptions = getSharedPreferences("1523066", 0);
        ((SeekBar)findViewById(R.id.sbkMin)).setProgress(spOptions.getInt("minLength", 3));
        ((SeekBar)findViewById(R.id.sbkMax)).setProgress(spOptions.getInt("maxLength", 10));
        ((TextView)findViewById(R.id.txtMinLen)).setText("Minimum word length: " + spOptions.getInt("minLength", 3));
        ((TextView)findViewById(R.id.txtMaxLen)).setText("Maximum word length: " + spOptions.getInt("maxLength", 10));
        ((SeekBar)findViewById(R.id.sbkMin)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.sbkMax)).setOnSeekBarChangeListener(this);
        findViewById(R.id.btnSaveChanges).setOnClickListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sbkMin: {
                if (progress < 3) {
                    seekBar.setProgress(3);
                    Toast.makeText(getApplicationContext(), "Cannot have a word length of less than 3", Toast.LENGTH_SHORT).show();
                }
                if (progress > ((SeekBar)findViewById(R.id.sbkMax)).getProgress()) {
                    seekBar.setProgress(((SeekBar)findViewById(R.id.sbkMax)).getProgress());
                    Toast.makeText(getApplicationContext(), "Minimum word length must be less than maximum length", Toast.LENGTH_SHORT).show();
                }

                ((TextView)findViewById(R.id.txtMinLen)).setText("Minimum word length: " + seekBar.getProgress());
            } break;
            case R.id.sbkMax: {
                if (progress < 3) {
                    seekBar.setProgress(3);
                    Toast.makeText(getApplicationContext(), "Cannot have a word length of less than 3", Toast.LENGTH_SHORT).show();
                }
                if (progress < ((SeekBar)findViewById(R.id.sbkMin)).getProgress()) {
                    seekBar.setProgress(((SeekBar)findViewById(R.id.sbkMin)).getProgress());
                    Toast.makeText(getApplicationContext(), "Minimum word length must be less than maximum length", Toast.LENGTH_SHORT).show();
                }

                ((TextView)findViewById(R.id.txtMaxLen)).setText("Maximum word length: " + seekBar.getProgress());
            } break;
            default: {}
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        SharedPreferences spOptions;
        SharedPreferences.Editor spOptionEditor;
        spOptions = getSharedPreferences("1523066", 0);
        spOptionEditor = spOptions.edit();
        spOptionEditor.putInt("minLength", ((SeekBar)findViewById(R.id.sbkMin)).getProgress());
        spOptionEditor.putInt("maxLength", ((SeekBar)findViewById(R.id.sbkMax)).getProgress());
        spOptionEditor.commit();

        startActivity(new Intent(this, MainActivity.class));
    }
}
