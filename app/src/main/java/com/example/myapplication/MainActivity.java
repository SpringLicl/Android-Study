package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int[] testArr = new int[]{5, 9, 2, 14, 7, 3, 5, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubbleSort(testArr);
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
                    Log.e("MainActivity", "bubbleSort j: " +j);
                }
            }
            if (!swapped) {
                Log.e("MainActivity", "bubbleSort i: " +i);
                break;
            }
        }
        Log.e("MainActivity", "bubbleSort arr: " + Arrays.toString(arr));
    }
}