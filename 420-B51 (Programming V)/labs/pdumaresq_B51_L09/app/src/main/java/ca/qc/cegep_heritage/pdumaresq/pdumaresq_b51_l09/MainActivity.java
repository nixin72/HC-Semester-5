package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b51_l09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().getExtras() != null) {
            Toast.makeText(
                    getApplicationContext(),
                    getIntent().getExtras().getString("name") + "was added to the database.",
                    Toast.LENGTH_LONG
            ).show();
        }

        DatabaseHandler db = new DatabaseHandler(this);
        List<Person> people = db.getAllPeople();

        TableLayout tbl = (TableLayout)findViewById(R.id.tblPeople);

        for (Person person : people) {
            TableRow row = new TableRow(this);
            row.addView(createColumn(person.getFirstName()));
            row.addView(createColumn(person.getLastName()));
            row.addView(createColumn(person.getEmailAddress()));
            row.addView(createColumn(person.getPhoneNumber()));
            row.addView(createButton(person.getId()));
            tbl.addView(row);
        }

    }

    public TextView createColumn(String data) {
        TextView col = new TextView(this);
        col.setText(data);
        return col;
    }

    public Button createButton(final int id) {
        Button btn = new Button(this);
        btn.setText("Update");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UseInformation.class);
                i.putExtra("id", id);
                startActivity(i);

            }
        });

        return btn;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(item.getItemId()) {
            case R.id.mitmCreate: {
                startActivity(new Intent(this, GetInformation.class));
            } break;
            case R.id.mitmRetrieve: {
                startActivity(new Intent(this, MainActivity.class));
            } break;
        }

        return id == R.id.mitmCreate || super.onOptionsItemSelected(item);
    }
}
