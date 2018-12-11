package com.example.macintoshhd.mydemo;

import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.macintoshhd.mydemo.helpers.DatabaseHelper;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSave, mBtnNew, mBtnGet;
    private TextInputEditText mName, mPrice, mQuantity, mId;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        mBtnNew = findViewById(R.id.btnNew);
        mBtnSave = findViewById(R.id.btnSave);
        mBtnGet = findViewById(R.id.btnGet);
        mName = findViewById(R.id.txtName);
        mPrice = findViewById(R.id.txtPrice);
        mQuantity = findViewById(R.id.txtQuantity);
        mId = findViewById(R.id.txtId);


        mBtnSave.setOnClickListener(this);
        mBtnNew.setOnClickListener(this);
        mBtnGet.setOnClickListener(this);

        mDatabaseHelper = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveProduct();
                break;
            case R.id.btnNew:
                newProduct();
                break;
            case R.id.btnGet:
                getProduct();
                break;
        }
    }

    private void getProduct(){
        String id = mId.getText().toString();

        int productId = Integer.parseInt(id);

        Cursor cursor = mDatabaseHelper.getProduct(productId);

        if (cursor != null && cursor.moveToFirst()){
            mName.setText(cursor.getString(cursor.getColumnIndex("name")));
            mPrice.setText(cursor.getString(cursor.getColumnIndex("price")));
            mQuantity.setText(cursor.getString(cursor.getColumnIndex("quantity")));
        }


    }

    private void saveProduct(){
        String name = mName.getText().toString();
        String price = mPrice.getText().toString();
        String quantity = mQuantity.getText().toString();

        long result = mDatabaseHelper.addProduct(name, Float.parseFloat(price), Integer.parseInt(quantity));
        Toast.makeText(this, "New product has been saved!", Toast.LENGTH_SHORT).show();
    }


    private void newProduct(){
        mName.setText("");
        mPrice.setText("");
        mQuantity.setText("");
    }
}
