package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b52_l05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, java.io.Serializable {
    private int currPlayer = 0;
    private Button[][] btnArrs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnArrs = new Button[][] {
            { (Button)findViewById(R.id.btn00), (Button)findViewById(R.id.btn01), (Button)findViewById(R.id.btn02) },
            { (Button)findViewById(R.id.btn10), (Button)findViewById(R.id.btn11), (Button)findViewById(R.id.btn12) },
            { (Button)findViewById(R.id.btn20), (Button)findViewById(R.id.btn21), (Button)findViewById(R.id.btn22) }
        };

        for (Button[] btnArr : btnArrs)
            for (final Button btn : btnArr)
                btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_reset) {
            for (Button[] btnArr : btnArrs)
                for (final Button btn : btnArr) {
                    btn.setText("");
                    btn.setEnabled(true);
                    currPlayer = 0;
                }

            ((TextView) findViewById(R.id.btnWinner)).setText("");
            return true;
        }

        if (item.getItemId() == R.id.menu_exit)
            finish();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        ((Button) v).setText(currPlayer == 0 ? "X" : "O");
        v.setEnabled(false);

        if (checkWinner()) {
            ((TextView) findViewById(R.id.btnWinner)).setText("Player " + (currPlayer + 1) + " wins!");
            for (Button[] btnArr : btnArrs)
                for (final Button btn : btnArr)
                    btn.setEnabled(false);
        }

        if (checkTie())
            ((TextView) findViewById(R.id.btnWinner)).setText("It's a tie!");

        currPlayer = (currPlayer == 1) ? 0 : 1;
    }

    private boolean checkWinner() {
        String s = currPlayer == 0 ? "X" : "O";
        return  //Horizonal
            (btnArrs[0][0].getText().equals(s) && btnArrs[0][1].getText().equals(s) && btnArrs[0][2].getText().equals(s)) ||
            (btnArrs[1][0].getText().equals(s) && btnArrs[1][1].getText().equals(s) && btnArrs[1][2].getText().equals(s)) ||
            (btnArrs[2][0].getText().equals(s) && btnArrs[2][1].getText().equals(s) && btnArrs[2][2].getText().equals(s)) ||
                //Vertical
            (btnArrs[0][0].getText().equals(s) && btnArrs[1][0].getText().equals(s) && btnArrs[2][0].getText().equals(s)) ||
            (btnArrs[0][1].getText().equals(s) && btnArrs[1][1].getText().equals(s) && btnArrs[2][1].getText().equals(s)) ||
            (btnArrs[0][2].getText().equals(s) && btnArrs[1][2].getText().equals(s) && btnArrs[2][2].getText().equals(s)) ||
                //Diagonal
            (btnArrs[0][0].getText().equals(s) && btnArrs[1][1].getText().equals(s) && btnArrs[2][2].getText().equals(s)) ||
            (btnArrs[0][2].getText().equals(s) && btnArrs[1][1].getText().equals(s) && btnArrs[2][0].getText().equals(s));
    }

    private boolean checkTie() {
        boolean tie = true;
        for (Button[] btnArr : btnArrs)
            for (final Button btn : btnArr)
                tie = tie && !btn.getText().toString().equals("");
        return tie;
    }
}
