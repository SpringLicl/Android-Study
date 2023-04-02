package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private int[] testArr = new int[]{5, 9, 2, 14, 7, 3, 5, 4};

    private SeekBar progressBar;
    private ImageView pauseButton;
    private MediaPlayer mMediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bubbleSort(testArr);


        progressBar = findViewById(R.id.progressBar);
        pauseButton = findViewById(R.id.pauseButton);

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
//                    pauseButton.setBackgroundResource(R.drawable.play_button);
                    hideControls();
                } else {
                    mMediaPlayer.start();
//                    pauseButton.setBackgroundResource(R.drawable.pause_button);
                }
            }
        });
    }

    private Handler mHandler = new Handler();
    private Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hideControls();
        }
    };

    private void hideControls() {
        progressBar.setVisibility(View.INVISIBLE);
        pauseButton.setVisibility(View.INVISIBLE);
    }

    private void updateProgressBar(){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
//                int progress = getCurrentPosition();
                progressBar.setProgress(progress);
                if (progressBar.getVisibility() == View.INVISIBLE) {
                    progressBar.setVisibility(View.VISIBLE);
                    pauseButton.setVisibility(View.VISIBLE);
                    mHandler.postDelayed(mHideRunnable, 3000);
                } else {
                    mHandler.removeCallbacks(mHideRunnable);
                    mHandler.postDelayed(mHideRunnable, 3000);
                }
            }
        });
    }

    private void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    Log.e("MainActivity", "bubbleSort j: " + j);
                }
            }
            if (!swapped) {
                Log.e("MainActivity", "bubbleSort i: " + i);
                break;
            }
        }
        Log.e("MainActivity", "bubbleSort arr: " + Arrays.toString(arr));
    }

    @Override
    public void onClick(View view) {

    }
}