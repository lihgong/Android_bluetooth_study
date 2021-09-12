package com.example.bluetooth_example;

import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter; // for Bluetooth
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private Button On,Off,list;
    private static final String TAG = "QQM";
    BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MyClass.getView() 1");
        setContentView(R.layout.activity_main);

        // Get control to the GUI item
        On = (Button)findViewById(R.id.button_on);
        Off = (Button)findViewById(R.id.button_off);
        list = (Button)findViewById(R.id.button_list);
    }

    public void button_cb_on(View view) {
        Log.i(TAG, "button_cb_on()");
        String msg;
        if(BT.isEnabled()) {
            msg = "BT is already on";
        } else {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            msg = "BT is been turned on";
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void button_cb_off(View view) {
        Log.i(TAG, "button_cb_off");
        if(BT.isEnabled()) {
            BT.disable();
            String msg = "BT is turned off";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    public void button_cb_list(View view) {
        Log.i(TAG, "button_cb_list");

    }
}
