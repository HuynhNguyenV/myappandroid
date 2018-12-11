package com.example.macintoshhd.mydemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnDataProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        mBtnDataProcess = findViewById(R.id.btnDataProcess);
        mBtnDataProcess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("products.db", MODE_PRIVATE, null);

        String sqlCreate = "CREATE TABLE IF NOT EXISTS `product`" +
                "(`_id` INTEGER NOT NULL PRIMARY KEY, " +
                "`name` TEXT NOT NULL, `price` REAL, `quantity` INTEGER)";

        db.execSQL(sqlCreate);

        String sql = "INSERT INTO product VALUES(3, 'mit', 333, 444);";
        db.execSQL(sql);
        sql = "INSERT INTO product VALUES(4, 'mi tom', 222,1234);";
        db.execSQL(sql);

        Cursor query = db.rawQuery("SELECT * from product", null);

        if (query.moveToFirst()) {
            do {
                String name = query.getString(0);
                int phone = query.getInt(1);
                String email = query.getString(2);
                Toast.makeText(this, " " + name, Toast.LENGTH_SHORT).show();
            }while (query.moveToNext());
        }
        query.close();

        db.close();
    }


}
