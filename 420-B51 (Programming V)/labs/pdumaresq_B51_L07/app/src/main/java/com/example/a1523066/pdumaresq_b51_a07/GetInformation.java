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
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.R.attr.data;

public class GetInformation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnSubmit).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSubmit) {
             String fName = ((TextView) findViewById(R.id.edtFirstName)).getText().toString();
             String lName = ((TextView) findViewById(R.id.edtLastName)).getText().toString();
             String email = ((TextView) findViewById(R.id.edtEmailAddress)).getText().toString();
             String deptNum = ((TextView) findViewById(R.id.edtDeptNumber)).getText().toString();

            String user = fName + "#" + lName + "#" + email + "#" + deptNum;

            try {
                FileOutputStream fOut = getApplicationContext()
                        .openFileOutput("users.txt", MODE_APPEND);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fOut));
                writer.write(user);
                writer.newLine();
                writer.flush();
                writer.close();

                ((TextView) findViewById(R.id.edtFirstName)).setText("");
                ((TextView) findViewById(R.id.edtLastName)).setText("");
                ((TextView) findViewById(R.id.edtEmailAddress)).setText("");
                ((TextView) findViewById(R.id.edtDeptNumber)).setText("");
            }
            catch (FileNotFoundException e) {
                Toast.makeText(this, "The File could not be found", Toast.LENGTH_LONG).show();
            }
            catch (IOException e) {
                Toast.makeText(this, "The File could not be written to", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {
                Toast.makeText(this, "An unexpected error occured.", Toast.LENGTH_LONG).show();
            }
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
