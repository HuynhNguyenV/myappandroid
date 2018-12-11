package com.example.macintoshhd.mydemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macintoshhd.mydemo.R;
import com.example.macintoshhd.mydemo.domain.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    private List<Product> mProducts;
    private Context mContext;

    public ProductAdapter(List<Product> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return mProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        }

        ImageView iv = convertView.findViewById(R.id.ivCoverImage);
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvBrief = convertView.findViewById(R.id.tvBrief);

        Product product = mProducts.get(position);
        iv.setImageResource(product.getCoverImage());
        tvTitle.setText(product.getTitle());
        tvBrief.setText(product.getBrief());


        return convertView;
    }


}
