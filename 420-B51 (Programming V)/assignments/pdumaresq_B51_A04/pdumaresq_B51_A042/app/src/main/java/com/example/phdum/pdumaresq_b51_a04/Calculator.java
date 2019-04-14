package com.example.phdum.pdumaresq_b51_a04;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class Calculator extends AppCompatActivity implements View.OnClickListener {
    private Matrix matrix;
    private ArrayList<MatrixCoordinate> coordinates;
    private ArrayList<ArrayList<Button>> inputFields;
    private Stack<Matrix> operations;
    private String equation;
    private int[] currEdt;
    private ArrayList<Button> keypad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        equation    = "";
        coordinates = new ArrayList<>();
        inputFields = new ArrayList<>();
        currEdt     = new int[]{0,0};
        keypad      = new ArrayList<>();
        operations  = new Stack<>();

        if (getResources().getConfiguration().orientation == 1) {
            ((LinearLayout)findViewById(R.id.lnrCalculator)).setOrientation(LinearLayout.VERTICAL);
        } else {
            ((LinearLayout)findViewById(R.id.lnrCalculator)).setOrientation(LinearLayout.HORIZONTAL);
        }


        //Check if a new Matrix was passed into the activity
        Bundle b = getIntent().getExtras();
        if (b.isEmpty()) {
            startActivity(new Intent(this, SelectMatrixSize.class));
        }

        matrix = (Matrix)getIntent().getExtras().getSerializable("matrix");

        setKeypadListeners();
        //Get the matrix passed in an add it to the matrices
        for (Button button : keypad) {
            button.setOnClickListener(this);
        }

        generateEquation();
        drawInputArea();
        setSelectedButton(0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.btnKeypadUndo && v.getId() != R.id.btnKeypadRedo) {
            operations.push(new Matrix(matrix.toArray(), matrix.getId()));
        }

        switch (v.getId()) {
            case R.id.btnKeypad0: numberClicked("0"); break;
            case R.id.btnKeypad1: numberClicked("1"); break;
            case R.id.btnKeypad2: numberClicked("2"); break;
            case R.id.btnKeypad3: numberClicked("3"); break;
            case R.id.btnKeypad4: numberClicked("4"); break;
            case R.id.btnKeypad5: numberClicked("5"); break;
            case R.id.btnKeypad6: numberClicked("6"); break;
            case R.id.btnKeypad7: numberClicked("7"); break;
            case R.id.btnKeypad8: numberClicked("8"); break;
            case R.id.btnKeypad9: numberClicked("9"); break;
            case R.id.btnKeypadBackspace: backspace(); break;
            case R.id.btnKeypadClear: clearMatrix(); break;
            case R.id.btnKeypadDecimal: decimal(); break;
//            case R.id.btnKeypadDet: calculateDeterminant(); break;
            case R.id.btnKeypadAddRow: addRow(); break;
            case R.id.btnKeypadInverse: calculateInverse(); break;
            case R.id.btnKeypadNeg: negative(); break;
            case R.id.btnKeypadAddCol: addColumn(); break;
            case R.id.btnKeypadRREF: calculateRREF(); break;
            case R.id.btnKeypadREF: calculateREF(); break;
            case R.id.btnKeypadTranspose: calculateTranspose(); break;
            case R.id.btnKeypadUndo: undo(); break;
            default: {
                for (MatrixCoordinate coordinate : coordinates) {
                    if (coordinate.getEditText().equals(v)) {
                        setSelectedButton(v.getId());
                    }
                }
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == 1) {
            ((LinearLayout)findViewById(R.id.lnrCalculator)).setOrientation(LinearLayout.VERTICAL);
        } else {
            ((LinearLayout)findViewById(R.id.lnrCalculator)).setOrientation(LinearLayout.HORIZONTAL);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        if (matrix.getId() == -1) {
            menu.findItem(R.id.mitmSave).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmAbout: {
                startActivity(new Intent(this, About.class));
            } break;
            case R.id.mitmSelectSize: {
                startActivity(new Intent(this, SelectMatrixSize.class));
            } break;
            case R.id.mitmCalculator: {
                startActivity(new Intent(this, Calculator.class));
            } break;
            case R.id.mitmOptions: {
                startActivity(new Intent(this, Options.class));
            } break;
            case R.id.mitmSaveAs: {
                matrix.setId(-1);

                DatabaseHandler db = new DatabaseHandler(this);
                int id = db.createMatrix(matrix, this);
                if (id == -1) {
                    Toast.makeText(
                            this,
                            "The Matrix could not be saved, your maximum storage space has been reached.",
                            Toast.LENGTH_LONG
                    ).show();
                }

                matrix.setId(id);
                startActivity(new Intent(this, ViewSavedEquations.class));
            } break;
            case R.id.mitmSave: {
                if (matrix.getId() == -1) {
                    DatabaseHandler db = new DatabaseHandler(this);
                    int id = db.createMatrix(matrix, this);
                    if (id == -1) {
                        Toast.makeText(
                                this,
                                "The Matrix could not be saved, your maximum storage space has been reached.",
                                Toast.LENGTH_LONG
                        ).show();
                    }

                    matrix.setId(id);
                    startActivity(new Intent(this, ViewSavedEquations.class));
                }
                else {
                    DatabaseHandler db = new DatabaseHandler(this);
                    db.updateMatrix(matrix);

                    startActivity(new Intent(this, ViewSavedEquations.class));
                }
            } break;
            case R.id.mitmStoredEquations: {
                startActivity(new Intent(this, ViewSavedEquations.class));
            } break;
        }

        return item.getItemId() == R.id.mitmCalculator || super.onOptionsItemSelected(item);
    }

    private void setKeypadListeners() {
        keypad.add((Button)findViewById(R.id.btnKeypad0));
        keypad.add((Button)findViewById(R.id.btnKeypad1));
        keypad.add((Button)findViewById(R.id.btnKeypad2));
        keypad.add((Button)findViewById(R.id.btnKeypad3));
        keypad.add((Button)findViewById(R.id.btnKeypad4));
        keypad.add((Button)findViewById(R.id.btnKeypad5));
        keypad.add((Button)findViewById(R.id.btnKeypad6));
        keypad.add((Button)findViewById(R.id.btnKeypad7));
        keypad.add((Button)findViewById(R.id.btnKeypad8));
        keypad.add((Button)findViewById(R.id.btnKeypad9));
        keypad.add((Button)findViewById(R.id.btnKeypadBackspace));
        keypad.add((Button)findViewById(R.id.btnKeypadClear));
        keypad.add((Button)findViewById(R.id.btnKeypadDecimal));
//        keypad.add((Button)findViewById(R.id.btnKeypadDet));
        keypad.add((Button)findViewById(R.id.btnKeypadREF));
        keypad.add((Button)findViewById(R.id.btnKeypadAddRow));
        keypad.add((Button)findViewById(R.id.btnKeypadInverse));
        keypad.add((Button)findViewById(R.id.btnKeypadNeg));
        keypad.add((Button)findViewById(R.id.btnKeypadAddCol));
        keypad.add((Button)findViewById(R.id.btnKeypadRREF));
        keypad.add((Button)findViewById(R.id.btnKeypadTranspose));
    }

    private void generateEquation() {
        equation = matrix.toString();
        ((TextView)findViewById(R.id.txtDisplayEquationRaw)).setText(equation);
    }

    private void drawInputArea() {
        LinearLayout lay = (LinearLayout) findViewById(R.id.lnrCalcDisplay);
        for (int i = 0; i < matrix.rows(); i++) {
            LinearLayout row = createLinearLayout();
            inputFields.add(new ArrayList<Button>());

            for (int i1 = 0; i1 < matrix.columns(); i1++) {
                Button btn = createButton(i , i1);
                btn.setOnClickListener(this);
                addCoordinate(new MatrixCoordinate(i, i1, btn, Double.parseDouble(btn.getText().toString())));
                inputFields.get(i).add(btn);
                row.addView(btn);
            }
            lay.addView(row);
        }
    }

    private LinearLayout createLinearLayout() {
        LinearLayout LL = new LinearLayout(this);
        LL.setOrientation(LinearLayout.HORIZONTAL);

        ViewGroup.LayoutParams LLParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        LL.setLayoutParams(LLParams);

        return LL;
    }

    private Button createButton(int x, int y) {
        Button btn = new Button(this);
        btn.setBackgroundColor(Color.WHITE);

        ViewGroup.LayoutParams edtParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 125);

        btn.setLayoutParams(edtParams);
        btn.setId(Integer.parseInt(String.valueOf(x) + String.valueOf(y)));
        btn.setText(matrix.get(x, y) == 0 ? "0" : String.valueOf(matrix.get(x, y)));

        return btn;
    }

    private void addCoordinate(MatrixCoordinate coor) {
        int foundIndex = -1;
        for (int i = 0; i < coordinates.size(); i++) {
            if (coordinates.get(i).getCoordX() == coor.getCoordX()
                    && coordinates.get(i).getCoordY() == coor.getCoordY()) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            coordinates.add(coor);
        }
        else {
            coordinates.set(foundIndex, coor);
        }
    }

    public void setSelectedButton(int[] coor) {
        setSelectedButton(Integer.parseInt(String.valueOf(coor[0]) + String.valueOf(coor[1])));
    }

    public void setSelectedButton(int id) {
        LinearLayout display = (LinearLayout)findViewById(R.id.lnrCalcDisplay);
        for (int r = 0 ; r < display.getChildCount() ; r++) {
            LinearLayout row = (LinearLayout) display.getChildAt(r);
            for (int c = 0 ; c < row.getChildCount() ; c++) {
                if (Integer.parseInt(String.valueOf(r) + String.valueOf(c)) == id)
                    row.getChildAt(c).setBackgroundColor(Color.LTGRAY);
                else
                    row.getChildAt(c).setBackgroundColor(Color.WHITE);
            }
        }

        String[] selected = String.valueOf(id).split("");
        if (selected.length == 2)
            changeCurrentCoordinate(0, Integer.parseInt(selected[1]));
        else
            changeCurrentCoordinate(Integer.parseInt(selected[1]), Integer.parseInt(selected[2]));
    }

    public void changeCurrentCoordinate(int x, int y) {
        currEdt = new int[]{x, y};
    }

    public void undo() {
        matrix = operations.pop();
        redraw();
    }

    public void numberClicked(String num) {
        String text = inputFields.get(currEdt[0]).get(currEdt[1]).getText().toString();
        if (text.equals("0"))
            text = num;
        else
            text += num;

        updater(currEdt[0], currEdt[1], Double.parseDouble(text));
    }

    public void negative() {
        String text = inputFields.get(currEdt[0]).get(currEdt[1]).getText().toString();
        if (text.contains("-"))
            text = text.substring(1);
        else
            text = "-" + text;

        updater(currEdt[0], currEdt[1], Double.parseDouble(text));
    }

    public void decimal() {
        String text = inputFields.get(currEdt[0]).get(currEdt[1]).getText().toString();
        if (!text.contains("."))
            text += ".";

        updater(currEdt[0], currEdt[1], Double.parseDouble(text));
    }

    public void backspace() {
        String text = inputFields.get(currEdt[0]).get(currEdt[1]).getText().toString();
        if (text.length() == 1)
            text = "0";
        else
            text = text.substring(0, text.length()-1);

        updater(currEdt[0], currEdt[1], Double.parseDouble(text));
    }

    public void clearMatrix() {
        matrix = new Matrix(matrix.rows(), matrix.columns(), matrix.getId());
        getIntent().putExtra("matrix", matrix);
        recreate();
    }

    public void addRow() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (matrix.rows() < settings.getInt("maxRows", 4)) {
            matrix.addRow();
            getIntent().putExtra("matrix", new Matrix(matrix.rows(), matrix.columns()));
            redraw();
            setSelectedButton(currEdt);
        }
        else {
            Toast.makeText(
                    this,
                    "You cannot exceed the maximum matrix size." +
                    "To increase the max size, save this matrix and go to your settings.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void addColumn() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (matrix.columns() < settings.getInt("maxCols", 4)) {
            matrix.addColumn();
            getIntent().putExtra("matrix", new Matrix(matrix.rows(), matrix.columns()));
            redraw();
            setSelectedButton(currEdt);
        }
        else {
            Toast.makeText(
                    this,
                    "You cannot exceed the maximum matrix size." +
                            "To increase the max size, save this matrix and go to your settings.",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void calculateRREF() {
        matrix = matrix.getRREF();
        redraw();
    }

    public void calculateREF() {
        matrix = matrix.getREF();
        redraw();
    }

    public void calculateTranspose() {
        matrix = matrix.getTranspose();
        redraw();
    }

    public void calculateInverse() {
        try {
            matrix = matrix.getInverse();
        }
        catch (NoInverseException e) {
            Toast.makeText(
                    getApplicationContext(),
                    "The matrix has no inverse because the determinant is zero.", Toast.LENGTH_SHORT
            ).show();
        }
        catch (NoDeterminantException e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Non-square matrices don't have inverses.", Toast.LENGTH_SHORT
            ).show();
        }
        finally {
            redraw();
        }
    }

    public void calculateDeterminant() {
        try {
            matrix.getDeterminant();
        }
        catch (NoDeterminantException e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Non-square matrices don't have determinants.", Toast.LENGTH_SHORT
            ).show();
        }
    }

    private void updater(int x, int y, double val) {
        matrix.setCoordinate(x, y, val);
        if (val == Math.round(val)) {
            inputFields.get(x).get(y).setText(String.format(Locale.CANADA, "%.0f", val));
        }
        else {
            inputFields.get(x).get(y).setText(String.valueOf(val));
        }

        redraw();
    }

    private void redraw() {
        ((LinearLayout)findViewById(R.id.lnrCalcDisplay)).removeAllViews();
        generateEquation();
        drawInputArea();
        setSelectedButton(currEdt);
    }
}
