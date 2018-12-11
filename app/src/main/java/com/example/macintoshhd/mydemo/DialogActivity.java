package com.example.macintoshhd.mydemo;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShowDialog, mBtnEnterName,mBtnRead, mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        mBtnEnterName = findViewById(R.id.btnEnterName);
        mBtnShowDialog = findViewById(R.id.btnShowDialog);
        mBtnRead = findViewById(R.id.btnReadFromShared);
        mBtnSave = findViewById(R.id.btnSaveToShared);

        mBtnShowDialog.setOnClickListener(this);
        mBtnEnterName.setOnClickListener(this);
        mBtnRead.setOnClickListener(this);
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnShowDialog:
//                Toast.makeText(this, "Show Dialog is clicked", Toast.LENGTH_SHORT).show();
                alert();
                break;
            case R.id.btnEnterName:
                Toast.makeText(this, "Enter Name is clicked", Toast.LENGTH_SHORT).show();
                enterNameDialog();
                break;
            case R.id.btnReadFromShared:
                read();
                break;
            case R.id.btnSaveToShared:
                save();
                break;
        }
    }


    private void save(){
        SharedPreferences preferences = getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("Address", "59 Yen Bai");
        editor.putString("Name", "Nguyen Viet Huynh");

        editor.commit();
    }

    private void read(){
        SharedPreferences preferences = getSharedPreferences("DATA", MODE_PRIVATE);
        String address = preferences.getString("Address", null);
        String name = preferences.getString("Name", null);

        Toast.makeText(this, "Your name is " + name + " - Address: " + address, Toast.LENGTH_SHORT).show();
    }

    private void alert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Information");
        builder.setMessage("hello huynh");
        builder.setPositiveButton("fine", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "Fine! And you", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "No! And you", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }

    private EditText mEtName;

    private void enterNameDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Information");

        mEtName = new EditText(this);
        builder.setView(mEtName);
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setPositiveButton("Enter Name", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = mEtName.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(DialogActivity.this, "Name is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DialogActivity.this, "hello: " + name, Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "Exit", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
}
