package com.example.macintoshhd.mydemo;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class SendSMSActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PERMISSION_CODE = 123;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        btnSend = findViewById(R.id.btnSendSMS);

        btnSend.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, PERMISSION_CODE);

        SmsManager smsManager = SmsManager.getDefault();
        try {
            smsManager.sendTextMessage("5554", null, "This is my sms", null, null);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
