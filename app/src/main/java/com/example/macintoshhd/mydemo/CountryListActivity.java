package com.example.macintoshhd.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryListActivity extends AppCompatActivity {

    ListView mLvCountry;
    String [] countries = {
        "VietName", "Lao", "ThaiLan", "Campuchia", "Japan", "China", "USA",
            "VietName", "Lao", "ThaiLan", "Campuchia", "Japan", "China", "USA",
            "VietName", "Lao", "ThaiLan", "Campuchia", "Japan", "China", "USA",
            "VietName", "Lao", "ThaiLan", "Campuchia", "Japan", "China", "USA",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);

        mLvCountry = findViewById(R.id.lvCountry);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, countries
        );
        mLvCountry.setAdapter(adapter);
    }
}
