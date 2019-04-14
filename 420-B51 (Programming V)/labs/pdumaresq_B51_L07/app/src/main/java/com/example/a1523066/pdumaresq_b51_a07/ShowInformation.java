package com.example.a1523066.pdumaresq_b51_a07;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            FileInputStream fin = getApplicationContext().openFileInput("users.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            TextView inString = (TextView) findViewById(R.id.txtUsers);
            String line, data="";
            while((line = reader.readLine()) != null){
                String[] uInfo = line.split("#");
                data += uInfo[0] + " " + uInfo[1] + "\n";
                data += "Email: " + uInfo[2] + "\n";
                data += "Dept. size: " + uInfo[3] + "\n";
                data += "\n";
            }
            inString.setText(data);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
