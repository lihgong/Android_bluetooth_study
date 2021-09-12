package com.example.bluetooth_example;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QQM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MyClass.getView() 1");
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MyClass.getView() 2");
    }
}
