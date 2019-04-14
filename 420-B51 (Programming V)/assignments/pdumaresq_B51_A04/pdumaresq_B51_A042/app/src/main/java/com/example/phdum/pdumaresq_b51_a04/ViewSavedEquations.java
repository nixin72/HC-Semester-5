package com.example.phdum.pdumaresq_b51_a04;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class ViewSavedEquations extends AppCompatActivity {
    List<Matrix> matrices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_saved_equations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseHandler db = new DatabaseHandler(this);
        matrices = db.retrieveMatrices();

        TableLayout tbl = (TableLayout) findViewById(R.id.lstMatricesInDb);
        for (Matrix matrix : matrices) {
            TableRow row = new TableRow(this);
            HorizontalScrollView cont = new HorizontalScrollView(this);
            LinearLayout lnr = new LinearLayout(this);
            lnr.setOrientation(LinearLayout.HORIZONTAL);

            lnr.addView(insertEquation(matrix.toString()));
            lnr.addView(createUpdateButton(matrix));
            lnr.addView(createDeleteButton(matrix));
            lnr.setPadding(0, 25, 10, 25);
            cont.addView(lnr);
            row.addView(hr());
            row.addView(cont);
            tbl.addView(row);
        }

        if (matrices.size() != 0) {
            findViewById(R.id.txtNoMatrices).setVisibility(View.GONE);
        }
    }

    public String getMatrixString(Matrix matrix) {
        int[] longest = new int[matrix.columns()];
        for (int r = 0; r < matrix.rows(); r++) {
            for (int c = 0 ; c < matrix.columns() ; c++) {
                String col = String.valueOf(matrix.get(r, c));
                if (col.length() > longest[c]) {
                    longest[c] = col.length();
                }
            }
        }

        String strMatrix = "";
        for (int r = 0 ; r < matrix.rows() ; r++) {
            strMatrix += "[";
            for (int c = 0 ; c < matrix.columns() ; c++) {
                strMatrix += (String.valueOf(matrix.get(r,c)).contains(".")
                        ? String.valueOf(matrix.get(r,c))
                            .replaceFirst("0++$", "")
                            .replaceFirst("\\.$", "")
                        : String.valueOf(matrix.get(r,c)))
                    + getSpaces(longest[c], String.valueOf(matrix.get(r,c)).length());
            }
            strMatrix = strMatrix.replaceFirst("\\s$", "") + "]\n";
        }

        return strMatrix;
    }

    public String getSpaces(int longest, int length) {
        String spaces = " ";
        for (int n = 0 ; n < longest-length ; n++) {
            spaces += " ";
        }

        return spaces;
    }

    public View hr() {
        View hr = new View(this);
        hr.setBackgroundColor(Color.BLACK);
        hr.setLayoutParams(new Toolbar.LayoutParams(100, 20));
        return hr;
    }

    public TextView insertEquation(String equation) {
        TextView eq = new TextView(this);
        eq.setText(getMatrixString(Matrix.stringToMatrix(equation)));
        eq.setTypeface(Typeface.MONOSPACE);
        eq.setTextSize(25);
        eq.setMinimumWidth(50);
        eq.setMinWidth(400);
        return eq;
    }

    public Button createUpdateButton(final Matrix matrix) {
        Button btn = new Button(this);
        btn.setText("Update");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Calculator.class);
                i.putExtra("matrix", matrix);
                startActivity(i);
            }
        });

        return btn;
    }

    public Button createDeleteButton(final Matrix matrix) {
        Button btn = new Button(this);
        btn.setText("Delete");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                db.deleteMatrix(matrix);
                recreate();
            }
        });

        return btn;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_stored_equations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmAbout: {
                startActivity(new Intent(this, About.class));
            } break;
            case R.id.mitmCalculator: {
                startActivity(new Intent(this, SelectMatrixSize.class));
            } break;
            case R.id.mitmOptions: {
                startActivity(new Intent(this, Options.class));
            } break;
        }

        return super.onOptionsItemSelected(item);
    }
}
