package com.example.macintoshhd.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.macintoshhd.mydemo.Services.ProductService;
import com.example.macintoshhd.mydemo.adapters.ProductAdapter;
import com.example.macintoshhd.mydemo.domain.Product;

public class ProductListActivity extends AppCompatActivity {

    private ListView mLvProducts;
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mLvProducts = findViewById(R.id.lvProducts);
        mAdapter = new ProductAdapter(ProductService.getProducts(), this);
        mLvProducts.setAdapter(mAdapter);

        mLvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) mAdapter.getItem(position);

                Toast.makeText(ProductListActivity.this, "Item is clicked: " + product.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
