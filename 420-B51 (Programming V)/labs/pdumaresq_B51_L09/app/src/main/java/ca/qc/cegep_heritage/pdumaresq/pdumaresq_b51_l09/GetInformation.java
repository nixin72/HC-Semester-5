package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b51_l09;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

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
    public void onClick(View view) {
        String fN = ((EditText)findViewById(R.id.edtFirstName)).getText().toString();
        String lN = ((EditText)findViewById(R.id.edtLastName)).getText().toString();
        String eA = ((EditText)findViewById(R.id.edtEmailAddress)).getText().toString();
        String pN = ((EditText)findViewById(R.id.edtPhoneExt)).getText().toString();

        DatabaseHandler db = new DatabaseHandler(this);
        db.addPerson(new Person(fN, lN, eA, pN));

        startActivity(new Intent(this, MainActivity.class).putExtra("name", fN + " " + lN));
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
