package com.example.macintoshhd.mydemo.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS `product`" +
                "(`_id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                " `name` TEXT NOT NULL, `price` REAL, `quantity` INTEGER)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public long addProduct(String name, float price, int quantity){
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("price", price);
        cv.put("quantity", quantity);

        SQLiteDatabase sd = getWritableDatabase();
        long result = sd.insert("product", null, cv);
        return result;
    }


    public boolean removeProduct(int productId) {
        SQLiteDatabase sd = getWritableDatabase();
        String[] whereArgs = new String[]{String.valueOf(productId)};

        long result = sd.delete("product", "_id= ? ", whereArgs);

        return (result > 0);
    }

    public Cursor getProduct(int productId){
        SQLiteDatabase sb = getWritableDatabase();

        String[] cols = new String[]{"_id", "name", "price", "quantity"};
        String[] selectionArgs = new String[] {String.valueOf(productId)};
        Cursor c = sb.query("product", cols, "_id = ?", selectionArgs, null, null, null);
        return c;
    }
}
