package com.example.bluetooth_example;

import java.util.ArrayList;
import java.util.Set;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter; // for Bluetooth
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

// REFERENCE
// http://cmnocsexperience.blogspot.com/2019/01/android.html
// https://github.com/android/connectivity-samples
// https://ivanliang86.pixnet.net/blog/post/102107617
public class MainActivity extends AppCompatActivity {
    private Button On,Off,list;
    private ListView lv;
    private static final String TAG = "QQM";
    BluetoothAdapter BT = BluetoothAdapter.getDefaultAdapter();
    private Set<BluetoothDevice>pairedDevices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MyClass.getView() 1");
        setContentView(R.layout.activity_main);

        // Get control to the GUI item
        On = (Button)findViewById(R.id.button_on);
        Off = (Button)findViewById(R.id.button_off);
        list = (Button)findViewById(R.id.button_list);
        lv = (ListView)findViewById(R.id.bt_listview);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                ListView listView;
                listView = (ListView) arg0;
                String msg = "ID=" + arg3 + " TEXT=" + listView.getItemAtPosition(arg2).toString();
                Log.i(TAG, msg);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

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
        pairedDevices = BT.getBondedDevices();

        ArrayList list = new ArrayList();
        for(BluetoothDevice bt : pairedDevices) {
            list.add(bt.getName());
        }

        Toast.makeText(getApplicationContext(),"Showing Paired Devices", Toast.LENGTH_SHORT).show();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }
}
