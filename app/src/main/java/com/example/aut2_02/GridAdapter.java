package com.example.aut2_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] productName;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] productName, int[] image) {
        this.context = context;
        this.productName = productName;
        this.image = image;
    }

    @Override
    public int getCount() {
        return productName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view = inflater.inflate(R.layout.grid_item,null);
        }

        ImageView imageView = view.findViewById(R.id.grid_image);
        TextView textView = view.findViewById(R.id.item_name);

        imageView.setImageResource(image[i]);
        textView.setText(productName[i]);

        return view;
    }
}
