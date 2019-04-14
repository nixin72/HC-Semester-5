package com.example.a1523066.pdumaresq_b51_a03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PlayGame extends AppCompatActivity implements View.OnClickListener {
    public String wordToGuess;
    public int numWrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int diff = prefs.getInt("diff", 0);

        SharedPreferences spOptions;
        spOptions = getSharedPreferences("1523066", 0);
        int min = spOptions.getInt("minLength", 3);
        int max = spOptions.getInt("maxLength", 10);

        setWord(max, min, diff);
        setUpGame();
        setImage();

        findViewById(R.id.btnMakeGuess).setOnClickListener(this);
        findViewById(R.id.btnResetGame).setOnClickListener(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//            ((LinearLayout)findViewById(R.id.gameWrapper)).setOrientation(LinearLayout.HORIZONTAL);
//        }
//        else {
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//            ((LinearLayout)findViewById(R.id.gameWrapper)).setOrientation(LinearLayout.VERTICAL);
//        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMakeGuess) {
            try {
                if (((EditText) findViewById(R.id.edtLetter)).getText().length() > 1) {
                    throw new Exception();
                }

                char letterGuessed = ((EditText) findViewById(R.id.edtLetter)).getText().charAt(0);
                if (!((TextView)findViewById(R.id.txtLettersGuessed)).getText().toString().contains(String.valueOf(letterGuessed))) {
                    char[] display = ((TextView) findViewById(R.id.txtGuessSpaces)).getText().toString().toCharArray();
                    char[] chars = wordToGuess.toCharArray();
                    boolean right = false;
                    for (int i = 0 ; i < chars.length ; i++) {
                        if (letterGuessed == chars[i]) {
                            display[i*2] = letterGuessed;
                            right = true;
                        }
                    }

                    if (right) {
                        checkWin(display);
                    }
                    else {
                        numWrong++;
                        setImage();
                        ((TextView) findViewById(R.id.txtLettersGuessed)).append("\r\n" + letterGuessed);
                        checkLoose();
                    }

                    ((TextView) findViewById(R.id.txtGuessSpaces)).setText("");
                    ((EditText) findViewById(R.id.edtLetter)).setText("");

                    for (char c : display) {
                        ((TextView) findViewById(R.id.txtGuessSpaces)).append(String.valueOf(c));
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "You already guessed that letter.", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Please enter a single letter to guess.", Toast.LENGTH_SHORT).show();
            }

            ((EditText)findViewById(R.id.edtLetter)).setText("");
        }
        else {
            startActivity(new Intent(this, SelectDifficulty.class));
        }
    }

    private void checkWin(char[] lettersGuessed) {
        String word = String.copyValueOf(lettersGuessed);
        word = word.replace("_", "").replace(" ", "");
        if (word.equals(wordToGuess)) {
            ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.win));
            findViewById(R.id.btnMakeGuess).setVisibility(View.GONE);
            findViewById(R.id.btnResetGame).setVisibility(View.VISIBLE);
        }
    }

    private void checkLoose() {
        if (numWrong == 6) {
            findViewById(R.id.btnMakeGuess).setVisibility(View.GONE);
            findViewById(R.id.btnResetGame).setVisibility(View.VISIBLE);
        }
    }

    private void setImage() {
        switch (numWrong) {
            case 0: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_0));
            } break;
            case 1: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_1));
            } break;
            case 2: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_2));
            } break;
            case 3: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_3));
            } break;
            case 4: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_4));
            } break;
            case 5: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_5));
            } break;
            case 6: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_6));
            } break;
            default: {
                ((ImageView)findViewById(R.id.imgHangman)).setImageDrawable(getResources().getDrawable(R.drawable.wrong_0));
            }
        }
    }

    private void setUpGame() {
        char[] chars = wordToGuess.toCharArray();
        TextView spaces = (TextView) findViewById(R.id.txtGuessSpaces);
        for (char aChar : chars) {
            spaces.append("_ ");
        }
    }

    private void setWord(int maxLength, int minLength, int diff) {
        String[] tmp = diff == 0 ? getResources().getStringArray(R.array.easy)
                : getResources().getStringArray(R.array.hard);
        LinkedList<String> words = new LinkedList<>();

        for (String word : tmp)
            if (word.length() <= maxLength && word.length() >= minLength)
                words.add(word);

        wordToGuess = words.get(new Random().nextInt(words.size()));
    }
}
