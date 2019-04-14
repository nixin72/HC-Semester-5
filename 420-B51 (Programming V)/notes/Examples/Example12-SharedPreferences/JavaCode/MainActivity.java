package ca.heritage.amcdonald.example12_sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText ed1,ed2,ed3;
    Button b1;
    public static final String MYPREFERENCES = "MyPrefs" ;
    public static final String SAVENAME = "nameKey";
    public static final String SAVEPHONE = "phoneKey";
    public static final String SAVEEMAIL = "emailKey";
    SharedPreferences sharedPrefs, s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        sharedPrefs = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        s2 = getSharedPreferences("OtherPrefs", Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedPrefs.edit();

                editor.putString(SAVENAME, n);
                editor.putString(SAVEPHONE, ph);
                editor.putString(SAVEEMAIL, e);
                editor.apply();
                //editor.commit(); also possible, but this is immediate and blocks

                SharedPreferences.Editor s2Edit = s2.edit();
                s2Edit.putString(SAVENAME, n);
                s2Edit.putInt("newVal", 3213);
                s2Edit.commit();

                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
