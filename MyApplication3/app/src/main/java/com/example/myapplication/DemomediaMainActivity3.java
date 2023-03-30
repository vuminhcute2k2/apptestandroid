package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class DemomediaMainActivity3 extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demomedia_main3);
        mediaPlayer = null;
    }

    public void music(View view) {
        switch (view.getId()){
            case R.id.button3:
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.jack);
                }
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopMusic();

                    }
                });
                mediaPlayer.start();
                break;
            case R.id.button4:
                if (mediaPlayer != null)
                    mediaPlayer.pause();
                break;
            case R.id.button5:
                if (mediaPlayer != null){
                    mediaPlayer.stop();
                stopMusic();
            }
                break;
        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}