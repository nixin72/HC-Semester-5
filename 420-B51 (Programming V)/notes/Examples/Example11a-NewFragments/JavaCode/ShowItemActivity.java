package heritage.amcdonald.example11a_newfragments;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class ShowItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            //return;
        } else {
            setContentView(R.layout.fragment_fragment2);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String selColour = extras.getString("item");
                TextView tvDisplay = (TextView) findViewById(R.id.tvSelectedColour);
                tvDisplay.setText(getString(R.string.strSelected) + selColour);
            }
        }
    }
}
