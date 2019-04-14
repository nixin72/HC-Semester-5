package ca.qc.cegep_heritage.pdumaresq.pdumaresq_b52_l03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    protected String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton[] buttons = {
                (ImageButton) findViewById(R.id.imgBtnSquare),      (ImageButton) findViewById(R.id.imgBtnCube),    (ImageButton) findViewById(R.id.imgBtnSqrt),
                (ImageButton) findViewById(R.id.imgBtnInverse),     (ImageButton) findViewById(R.id.imgBtnSeven),   (ImageButton) findViewById(R.id.imgBtnEight),
                (ImageButton) findViewById(R.id.imgBtnNine),        (ImageButton) findViewById(R.id.imgBtnAdd),     (ImageButton) findViewById(R.id.imgBtnFour),
                (ImageButton) findViewById(R.id.imgBtnFive),        (ImageButton) findViewById(R.id.imgBtnSix),     (ImageButton) findViewById(R.id.imgBtnMinus),
                (ImageButton) findViewById(R.id.imgBtnOne),         (ImageButton) findViewById(R.id.imgBtnTwo),     (ImageButton) findViewById(R.id.imgBtnThree),
                (ImageButton) findViewById(R.id.imgBtnMultiply),    (ImageButton) findViewById(R.id.imgBtnZero),    (ImageButton) findViewById(R.id.imgBtnDecimal),
                (ImageButton) findViewById(R.id.imgBtnEquals),      (ImageButton) findViewById(R.id.imgBtnDivide)
        };

        findViewById(R.id.btnClear).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                equation = "";
                ((TextView) findViewById(R.id.txtAnswer)).setText(equation);
            }
        });

        for (ImageButton button : buttons)
            button.setOnClickListener(this);
    }

    public void updateEquation(String res) {
        equation = res;
        ((TextView) findViewById(R.id.txtAnswer)).setText(res);
    }

    public Double parse() {
        Double result = 0.0;
        String[] toks = equation.split("\\s");
        String prevTok = "";
        for (String tok : toks)
            switch (tok) {
                case "+": prevTok = "+"; break;
                case "-": prevTok = "-"; break;
                case "*": prevTok = "*"; break;
                case "/": prevTok = "/"; break;
                case ".": prevTok = "."; break;
                case "^2": result = Math.pow(result, 2); break;
                case "^3": result = Math.pow(result, 3); break;
                case "^-": result = Math.sqrt(result); break;
                case "1/": result = 1 / result; break;
                default: {
                    Double currTok = Double.parseDouble(tok);
                    switch (prevTok) {
                        case "+": { result = result + currTok; } break;
                        case "-": { result = result - currTok; } break;
                        case "*": { result = result * currTok; } break;
                        case "/": { result = result / currTok; } break;
                        case ".": { result = Double.parseDouble(result.toString() + "." + tok); } break;
                        default: { result = Double.parseDouble((result == 0.0) ? tok : result.toString() + tok); }
                    }
                }
            }

        equation = String.valueOf(result);
        return result;
    }

    public void onClick(View v) {
        Double result = 0.0;
        try {
            switch (v.getId()) {
                case R.id.imgBtnZero: updateEquation(equation + "0"); break;
                case R.id.imgBtnDecimal: updateEquation(equation + "."); break;
                case R.id.imgBtnOne: updateEquation(equation + "1"); break;
                case R.id.imgBtnTwo: updateEquation(equation + "2"); break;
                case R.id.imgBtnThree: updateEquation(equation + "3"); break;
                case R.id.imgBtnFour: updateEquation(equation + "4"); break;
                case R.id.imgBtnFive: updateEquation(equation + "5"); break;
                case R.id.imgBtnSix: updateEquation(equation + "6"); break;
                case R.id.imgBtnSeven: updateEquation(equation + "7"); break;
                case R.id.imgBtnEight: updateEquation(equation + "8"); break;
                case R.id.imgBtnNine: updateEquation(equation + "9"); break;
                case R.id.imgBtnAdd: updateEquation(equation + " + "); break;
                case R.id.imgBtnMinus: updateEquation(equation + " - "); break;
                case R.id.imgBtnMultiply: updateEquation(equation + " * "); break;
                case R.id.imgBtnDivide: updateEquation(equation + " / ");  break;
                case R.id.imgBtnSquare: result = Math.pow(parse(), 2); break;
                case R.id.imgBtnCube: result = Math.pow(parse(), 3); break;
                case R.id.imgBtnSqrt: result = Math.sqrt(parse()); break;
                case R.id.imgBtnInverse: result = 1 / parse(); break;
                case R.id.imgBtnEquals: { result = parse();
                    updateEquation(String.format(Locale.CANADA, "%.5f", result));
                } break;
            }

            if (v.getId() == R.id.imgBtnSquare || v.getId() == R.id.imgBtnCube || v.getId() == R.id.imgBtnSqrt || v.getId() == R.id.imgBtnInverse) {
                equation = String.format(Locale.CANADA, "%.5f", result);
                updateEquation(equation);
            }
        }
        catch (Exception e) {
            equation = "";
            ((TextView) findViewById(R.id.txtAnswer)).setText(("ERROR"));
        }
    }
}
