package com.example.a1523066.pdumaresq_b51_l06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((ListView) findViewById(R.id.lstActivities)).setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class c;
        switch (position) {
            case 0: c = BrowseInternet.class; break;
            case 1: c = PlayMusic.class; break;
            case 2: c = OtherSongs.class; break;
            case 3: c = About.class; break;
            default: {
                c = MainActivity.class;
            }
        }

        Intent i = new Intent(this, c);
        startActivity(i);
    }
}
