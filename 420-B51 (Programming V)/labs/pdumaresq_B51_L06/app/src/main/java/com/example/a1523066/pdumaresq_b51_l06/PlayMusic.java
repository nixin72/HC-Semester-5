package com.example.a1523066.pdumaresq_b51_l06;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PlayMusic extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mpSong = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.imbColdplay).setOnClickListener(this);
        findViewById(R.id.imbDemons).setOnClickListener(this);
        findViewById(R.id.imbHell).setOnClickListener(this);
        findViewById(R.id.imbTheBoxer).setOnClickListener(this);

        findViewById(R.id.imbRewind).setOnClickListener(this);
        findViewById(R.id.imbPause).setOnClickListener(this);
        findViewById(R.id.imbPlay).setOnClickListener(this);
        findViewById(R.id.imbStop).setOnClickListener(this);
        findViewById(R.id.imbFastForward).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Integer[] Songs = { R.raw.viva_la_vida, R.raw.demons, R.raw.hell, R.raw.the_boxer};

        switch (v.getId()) {
            case R.id.imbColdplay: {
                if (mpSong.isPlaying()) mpSong.reset();
                mpSong = MediaPlayer.create(this, Songs[0]);
                mpSong.start();
            } break;
            case R.id.imbDemons: {
                if (mpSong.isPlaying()) mpSong.reset();
                mpSong = MediaPlayer.create(this, Songs[1]);
                mpSong.start();
            } break;
            case R.id.imbHell: {
                if (mpSong.isPlaying()) mpSong.reset();
                mpSong = MediaPlayer.create(this, Songs[2]);
                mpSong.start();
            } break;
            case R.id.imbTheBoxer: {
                if (mpSong.isPlaying()) mpSong.reset();
                mpSong = MediaPlayer.create(this, Songs[3]);
                mpSong.start();
            } break;

            case R.id.imbRewind: {
                mpSong.seekTo(mpSong.getCurrentPosition() - 10000);
            } break;
            case R.id.imbPause: { mpSong.pause(); } break;
            case R.id.imbPlay: { mpSong.start(); } break;
            case R.id.imbStop: { mpSong.stop(); } break;
            case R.id.imbFastForward: {
                mpSong.seekTo(mpSong.getCurrentPosition() + 10000);
            } break;
            default: {}
        }
    }
}
