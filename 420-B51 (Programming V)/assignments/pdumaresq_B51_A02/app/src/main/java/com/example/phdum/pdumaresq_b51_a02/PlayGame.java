package com.example.phdum.pdumaresq_b51_a02;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class PlayGame extends AppCompatActivity implements View.OnClickListener {
    CountDownTimer time;

    private int answer;
    private int difficulty;
    private int numCorrect = 0;
    private int numQuestions = 0;
    private int[] nums;
    private char[] ops;
    private long timeRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setOrientation();

        setEventListeners();
        difficulty = getIntent().getIntExtra("diff", 0);
        setNumsAndOps(difficulty);
        answer = generateEquation(nums, ops);

        timeRemaining = 60 + (difficulty * 10);
        setTimeLimit();
    }

    @Override
    public void onStop() {
        super.onStop();

        Bundle b = new Bundle();
        b.putLong("time", timeRemaining);
        getIntent().putExtras(b);

        time.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        timeRemaining = getIntent().getLongExtra("time", 0);
        time.cancel();
        time.start();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setOrientation();
    }

    @Override
    public void onClick(View v) {
        EditText edtAns = (EditText) findViewById(R.id.edtAnswer);
        switch (v.getId()) {
            case R.id.btn0: edtAns.append(String.valueOf(0));   break;
            case R.id.btn1: edtAns.append(String.valueOf(1));   break;
            case R.id.btn2: edtAns.append(String.valueOf(2));   break;
            case R.id.btn3: edtAns.append(String.valueOf(3));   break;
            case R.id.btn4: edtAns.append(String.valueOf(4));   break;
            case R.id.btn5: edtAns.append(String.valueOf(5));   break;
            case R.id.btn6: edtAns.append(String.valueOf(6));   break;
            case R.id.btn7: edtAns.append(String.valueOf(7));   break;
            case R.id.btn8: edtAns.append(String.valueOf(8));   break;
            case R.id.btn9: edtAns.append(String.valueOf(9));   break;
            case R.id.btnNeg: toggleNegative(edtAns);           break;
            case R.id.btnSubmit: submitAnswer(edtAns);          break;
            case R.id.btnBackspace: edtAns.setText(edtAns.getText().toString()
                    .substring(0, edtAns.getText().toString().length()-1)); break;
            case R.id.btnReset: startActivity(new Intent(this, SelectDifficulty.class));
        }
    }

    private void setOrientation() {
        LinearLayout wrap = ((LinearLayout)findViewById(R.id.layoutWrapper));

        boolean isVertical = this.getResources().getConfiguration().orientation == LinearLayout.VERTICAL;
        wrap.setOrientation(isVertical ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL);

        ViewGroup.LayoutParams params = wrap.getLayoutParams();
        params.height = isVertical ? Toolbar.LayoutParams.WRAP_CONTENT : Toolbar.LayoutParams.MATCH_PARENT;
        wrap.setLayoutParams(params);
    }

    private void setEventListeners() {
        findViewById(R.id.btnSubmit).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);
        findViewById(R.id.btnNeg).setOnClickListener(this);
        findViewById(R.id.btnReset).setOnClickListener(this);
        findViewById(R.id.btnBackspace).setOnClickListener(this);
    }

    private void setTimeLimit() {
        time = new CountDownTimer(timeRemaining*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                ((TextView)findViewById(R.id.txtTimer)).setText("Time left: " + millisUntilFinished / 1000);
                timeRemaining = millisUntilFinished / 1000;
            }

            public void onFinish() {
                findViewById(R.id.btnSubmit).setEnabled(false);
                findViewById(R.id.btn0).setEnabled(false);
                findViewById(R.id.btn1).setEnabled(false);
                findViewById(R.id.btn2).setEnabled(false);
                findViewById(R.id.btn3).setEnabled(false);
                findViewById(R.id.btn4).setEnabled(false);
                findViewById(R.id.btn5).setEnabled(false);
                findViewById(R.id.btn6).setEnabled(false);
                findViewById(R.id.btn7).setEnabled(false);
                findViewById(R.id.btn8).setEnabled(false);
                findViewById(R.id.btn9).setEnabled(false);
                findViewById(R.id.btnNeg).setEnabled(false);

                findViewById(R.id.txtTimer).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                findViewById(R.id.txtNumCorrect).setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                findViewById(R.id.txtNums).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                findViewById(R.id.btnBackspace).setVisibility(View.GONE);
                findViewById(R.id.edtAnswer).setVisibility(View.GONE);
                findViewById(R.id.btnReset).setVisibility(View.VISIBLE);

                ((TextView)findViewById(R.id.txtTimer)).setText("Time's up!");

                ((TextView)findViewById(R.id.txtNums)).setText(
                    numCorrect == 0 && numQuestions == 1 ? "0%" :
                        String.format(Locale.CANADA, "%.2f",
                            Double.parseDouble(String.valueOf(numCorrect)) /
                                Double.parseDouble(String.valueOf(numQuestions)) * 100.0) + "%");
            }
        }.start();
    }

    private void setNumsAndOps(int diff) {
        ops = (diff < 4) ? new char[] {'+', '-'} : new char[] {'+', '-', '*', '/'};

        Random r = new Random();
        switch (diff) {
            case 0: nums = new int[] {r.nextInt(10), r.nextInt(10)}; break;
            case 1: nums = new int[] {r.nextInt(10), r.nextInt(10), r.nextInt(10)}; break;
            case 2: nums = new int[] {r.nextInt(100), r.nextInt(100)}; break;
            case 3: nums = new int[] {r.nextInt(100), r.nextInt(100), r.nextInt(100)}; break;
            case 4: nums = new int[] {r.nextInt(10), r.nextInt(10)}; break;
            case 5: nums = new int[] {r.nextInt(10), r.nextInt(10), r.nextInt(10)}; break;
            case 6: nums = new int[] {r.nextInt(100), r.nextInt(100)}; break;
            case 7: nums = new int[] {r.nextInt(100), r.nextInt(100), r.nextInt(100)}; break;
            default: setNumsAndOps(7);
        }
        numQuestions++;
    }

    private void setDifficulty() {
        numCorrect++;
        if (numCorrect % 5 == 0 && difficulty < 8) {
            difficulty++;

            Toast msg = Toast.makeText(getApplicationContext(), "5 seconds have been added!",
                    Toast.LENGTH_SHORT);
            msg.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 1000);
            msg.show();

            time.cancel();
            timeRemaining += 5;
            setTimeLimit();
        }
    }

    private int getAnswer() {
        int ans;
        try {
            ans = Integer.parseInt(((EditText)findViewById(R.id.edtAnswer)).getText().toString());
        }
        catch (NumberFormatException e) {
            ans = 999999999;
        }

        return ans;
    }

    private int generateEquation(int[] nums, char[] ops) {
        Random r = new Random();
        String eq = "";

        for (int num : nums) {
            eq += String.valueOf(num) + " " + ops[r.nextInt(ops.length)] + " ";
        }

        eq = eq.substring(0, eq.length() - 2);
        int ans = parseEquation(eq);

        ((TextView) findViewById(R.id.txtNums)).setText(eq);
        ((EditText)findViewById(R.id.edtAnswer)).setText(String.valueOf(ans));
        return ans;
    }

    private int parseEquation(String eq) {
        LinkedList<String> toks = new LinkedList<>();
        for (String tok : eq.split("\\s")) {
            toks.add(tok);
        }

        if (toks.indexOf("*") != -1 && toks.indexOf("*") == toks.lastIndexOf("*")) {
            toks.add(toks.indexOf("*")-1, checkMultiplyDivide("*", toks));
        }
        if (toks.indexOf("/") != -1 && toks.indexOf("/") == toks.lastIndexOf("/")) {
            toks.add(toks.indexOf("/")-1, checkMultiplyDivide("/", toks));
        }

        int ans = 0;
        if (toks.size() > 1) {
            char lastOp = '~';
            for (String tok : toks) {
                if (tok.matches("-|\\+|\\*|/")) {
                    lastOp = tok.charAt(0);
                } else if (lastOp != '~') {
                    switch (lastOp) {
                        case '+': ans = ans + Integer.parseInt(tok);    break;
                        case '-': ans = ans - Integer.parseInt(tok);    break;
                        case '/': ans = ans / Integer.parseInt(tok);    break;
                        case '*': ans = ans * Integer.parseInt(tok);    break;
                    }
                } else {
                    ans = Integer.parseInt(tok);
                }
            }
        } else {
            ans = Integer.parseInt(toks.get(0));
        }

        return ans;
    }

    private int performOperation(String[] toks) {
        int ans = 0;
        switch (toks[1]) {
            case "+": ans = Integer.parseInt(toks[0]) + Integer.parseInt(toks[2]); break;
            case "-": ans = Integer.parseInt(toks[0]) - Integer.parseInt(toks[2]); break;
            case "*": ans = Integer.parseInt(toks[0]) * Integer.parseInt(toks[2]); break;
            case "/": ans = Integer.parseInt(toks[0]) / Integer.parseInt(toks[2]); break;
        }

        return ans;
    }

    private void toggleNegative(EditText edtAns) {
        if (edtAns.getText().toString().equals("")) {
            edtAns.setText("-");
        }
        else {
            edtAns.setText(edtAns.getText().charAt(0) == '-' ?
                    edtAns.getText().toString().substring(1) : "-" + edtAns.getText());
        }
    }

    private void submitAnswer(EditText edtAns) {
        if (getAnswer() == answer) {
            setDifficulty();
        }

        setNumsAndOps(difficulty);
        answer = generateEquation(nums, ops);

        edtAns.setText("");
        ((TextView)findViewById(R.id.txtNumCorrect))
                .setText("Correct Answers: " + String.valueOf(numCorrect));
    }

    private String checkMultiplyDivide(String op, LinkedList<String> toks) {
        int i = toks.indexOf(op);
        String[] tmp = {
                toks.remove(i-1),
                toks.remove(i-1),
                toks.remove(i-1)
        };

        return String.valueOf(performOperation(tmp));
    }
}