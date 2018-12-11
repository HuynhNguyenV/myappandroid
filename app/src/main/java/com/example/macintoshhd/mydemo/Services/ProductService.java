package com.example.macintoshhd.mydemo.Services;

import com.example.macintoshhd.mydemo.R;
import com.example.macintoshhd.mydemo.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static List<Product> getProducts(){
        List<Product> productList = new ArrayList<Product>();


        productList.add(new Product("Hat", "this is a hat", R.mipmap.ic_launcher));
        productList.add(new Product("Hat1", "this is a hat1", R.mipmap.ic_launcher));
        productList.add(new Product("Hat2", "this is a hat2", R.mipmap.ic_launcher));
        productList.add(new Product("Hat3", "this is a hat3", R.mipmap.ic_launcher));
        productList.add(new Product("Hat4", "this is a hat4", R.mipmap.ic_launcher));
        productList.add(new Product("Hat5", "this is a hat5", R.mipmap.ic_launcher));
        productList.add(new Product("Hat6", "this is a hat6", R.mipmap.ic_launcher));
        productList.add(new Product("Hat7", "this is a hat7", R.mipmap.ic_launcher));
        productList.add(new Product("Hat8", "this is a hat8", R.mipmap.ic_launcher));

        return productList;
    }
}
