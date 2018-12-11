package com.example.macintoshhd.mydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WellcomeMessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getExtras().getString("message");

        Toast.makeText(context, "Received message: " + message, Toast.LENGTH_SHORT).show();
    }
}
