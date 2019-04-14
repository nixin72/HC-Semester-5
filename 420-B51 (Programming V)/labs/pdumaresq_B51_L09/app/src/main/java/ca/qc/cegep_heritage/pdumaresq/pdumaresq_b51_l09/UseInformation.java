package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b51_l09;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class UseInformation extends AppCompatActivity implements View.OnClickListener {
    Person curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int id = getIntent().getExtras().getInt("id");
        DatabaseHandler db = new DatabaseHandler(this);
        curr = db.getPerson(id);

        ((EditText)findViewById(R.id.edtFirstName)).setText(curr.getFirstName());
        ((EditText)findViewById(R.id.edtLastName)).setText(curr.getLastName());
        ((EditText)findViewById(R.id.edtEmailAddress)).setText(curr.getEmailAddress());
        ((EditText)findViewById(R.id.edtPhoneExt)).setText(curr.getPhoneNumber());

        findViewById(R.id.btnSubmit).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        DatabaseHandler db = new DatabaseHandler(this);
        switch (view.getId()) {
            case R.id.btnSubmit: {
                String fN = ((EditText)findViewById(R.id.edtFirstName)).getText().toString();
                String lN = ((EditText)findViewById(R.id.edtLastName)).getText().toString();
                String eA = ((EditText)findViewById(R.id.edtEmailAddress)).getText().toString();
                String pN = ((EditText)findViewById(R.id.edtPhoneExt)).getText().toString();

                curr.setFirstName(fN);
                curr.setLastName(lN);
                curr.setEmailAddress(eA);
                curr.setPhoneNumber(pN);

                db.updatePerson(curr);
            } break;
            case R.id.btnDelete: {
                db.deletePerson(curr);
            } break;
        }

        startActivity(new Intent(this, MainActivity.class));
    }
}
