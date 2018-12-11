package com.example.macintoshhd.mydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceHandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStartService, mStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_hanlder);

        mStartService = findViewById(R.id.btnStartService);
        mStopService = findViewById(R.id.btnStopService);

        mStartService.setOnClickListener(this);
        mStopService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStartService:
                start();
                break;
            case R.id.btnStopService:
                stop();
                break;
        }
    }

    public void start(){
        Intent intent = new Intent(this, DownloadService.class);

        startService(intent);
    }


    public void stop(){
        Intent intent = new Intent(this, DownloadService.class);
        stopService(intent);
    }
}
