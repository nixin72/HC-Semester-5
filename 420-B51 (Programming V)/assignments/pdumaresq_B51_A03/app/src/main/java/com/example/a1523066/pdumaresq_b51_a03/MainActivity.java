package com.example.a1523066.pdumaresq_b51_a03;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnPlayGame).setOnClickListener(this);
        findViewById(R.id.btnOptions).setOnClickListener(this);
        findViewById(R.id.btnAbout).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.btnPlayGame: { i = new Intent(this, SelectDifficulty.class); }
                break;
            case R.id.btnAbout: { i = new Intent(this, About.class); }
                break;
            case R.id.btnOptions: { i = new Intent(this, Options.class); }
                break;
            default:  i = new Intent(this, MainActivity.class);
        }

        startActivity(i);
    }
}
