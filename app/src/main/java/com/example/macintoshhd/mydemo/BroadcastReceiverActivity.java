package com.example.macintoshhd.mydemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadcastReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSend;
    private WellcomeMessageReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rroadcast_receiver);

        mSend = findViewById(R.id.btnSendWelcome);

        mSend.setOnClickListener(this);
        mReceiver = new WellcomeMessageReceiver();

    }

    @Override
    protected void onResume() {
        mReceiver = new WellcomeMessageReceiver();
        registerReceiver(
                this.mReceiver,
                new IntentFilter(
                        "app.test.MESSAGE"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mReceiver);
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setAction("app.test.MESSAGE");
        intent.putExtra("message", "Message" + ((int)(Math.random() *100)));
        this.sendBroadcast(intent);
    }
}
