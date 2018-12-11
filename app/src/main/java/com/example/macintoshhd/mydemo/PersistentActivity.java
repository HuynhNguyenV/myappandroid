package com.example.macintoshhd.mydemo;

import android.os.Environment;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistentActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText mTxtName;
    private Button mBtnSave, mBtnRead, mBtnSaveExternal, mBtnReadExternal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent);

        mTxtName = findViewById(R.id.txtName);
        mBtnSave = findViewById(R.id.btnNew);
        mBtnRead = findViewById(R.id.btnRead);
        mBtnSaveExternal = findViewById(R.id.btnSaveExternal);
        mBtnReadExternal = findViewById(R.id.btnReadExternal);

        mBtnRead.setOnClickListener(this);
        mBtnSave.setOnClickListener(this);
        mBtnSaveExternal.setOnClickListener(this);
        mBtnReadExternal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNew:
                save();
                break;
            case R.id.btnRead:
                read();
                break;
            case R.id.btnSaveExternal:
                saveExternal();
                break;
            case R.id.btnReadExternal:
                readExternal();
                break;
        }
    }

    private void save() {
        String fileName = "hello.txt";
        try (FileOutputStream outputStream = openFileOutput(fileName, MODE_PRIVATE)) {
            String name = mTxtName.getText().toString();

            outputStream.write(name.getBytes());
            Toast.makeText(this, "New File has been saved", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("TAG", "save" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void read() {
        String fileName = "hello.txt";
        FileInputStream fin = null;
        try {
            fin = openFileInput(fileName);

            byte[] buffer = new byte[1024];
            int length = 0;
            length = fin.read(buffer, 0, 1024);
            String name = new String(buffer, 0, length);
            mTxtName.setText(name);

            Toast.makeText(this, "Hello: " + name, Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("TAG", "save" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
            }
        }
    }


    private void saveExternal() {
        File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "text.txt");
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            String name = mTxtName.getText().toString();
            outputStream.write(name.getBytes());

            outputStream.close();
            Toast.makeText(this, "New file has been saved!: ", Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private void readExternal() {
        File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "text.txt");
        FileInputStream fin = null;
        byte[] buffer = new byte[1024];
        int length = 0;

        try {
            fin = new FileInputStream(file);
            length = fin.read(buffer, 0, 1024);

            String name = new String(buffer, 0, length);
            mTxtName.setText(name);
            fin.close();

            Toast.makeText(this, "Hello: " + name, Toast.LENGTH_SHORT).show();
        } catch (IOException ex) {
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }


}
