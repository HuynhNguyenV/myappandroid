package com.example.macintoshhd.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends AppCompatActivity {

    EditText mNumber1, mNumber2, mResult;

    Button mAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        mNumber1 = findViewById(R.id.etNumber1);
        mNumber2 = findViewById(R.id.etNumber2);
        mResult = findViewById(R.id.etResult);
        mAdd = findViewById(R.id.btnAdd);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(mNumber1.getText().toString());
                int num2 = Integer.parseInt(mNumber2.getText().toString());
                mResult.setText("" + (num1 + num2));
            }
        });
    }
}
