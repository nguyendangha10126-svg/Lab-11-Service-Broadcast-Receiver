package com.example.lab11_servicebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            boolean isAirplaneModeOn = Settings.Global.getInt(
                    context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

            if (isAirplaneModeOn) {
                Toast.makeText(context, "Chế độ máy bay: ĐANG BẬT ✈️", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Chế độ máy bay: ĐANG TẮT 📡", Toast.LENGTH_LONG).show();
            }
        }
    }
}
