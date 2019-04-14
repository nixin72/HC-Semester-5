package com.example.a1523066.pdumaresq_b51_l06;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class OtherSongs extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_songs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((Spinner) findViewById(R.id.spnOtherSongs)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] songs = getResources().getStringArray(R.array.SongSites);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(songs[position])));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}


