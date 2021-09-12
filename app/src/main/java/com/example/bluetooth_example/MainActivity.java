package com.example.bluetooth_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // for logger
import android.bluetooth.BluetoothAdapter; // for Bluetooth
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 2;
    private static final String TAG = "QQM";
    BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MyClass.getView() 1");
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MyClass.getView() 2");
        Log.i(TAG, "MyClass.getView() 3");
        if (!BT.isEnabled()) {
            Log.i(TAG, "MyClass.getView() 4");
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            Log.i(TAG, "MyClass.getView() 5");
            startActivityForResult(turnOn, 0);
            Log.i(TAG, "MyClass.getView() 6");
            Toast.makeText(getApplicationContext(),"Turned on BT" , Toast.LENGTH_LONG).show();
            Log.i(TAG, "MyClass.getView() 7");
        } else {
            Log.i(TAG, "MyClass.getView() 8");
            Toast.makeText(getApplicationContext(),"BT is already on", Toast.LENGTH_LONG).show();
            Log.i(TAG, "MyClass.getView() 9");
        }

        // In this place the bluetooth adapter is already enabled
        // ... well actually not, the enable BT button is acync to this place


    }
}
