package com.example.aut2_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] productName;
    private String[] productPrice;
    private String[] productDescription;
    private int[] productImage;

    public GridAdapter(Context c, String[] productName, int[] image, String[] price,String[] desc) {
        context = c;
        this.productName = productName;
        this.productImage = image;
        this.productPrice=price;
        this.productDescription=desc;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if(inflater==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);
        TextView textViewPrice = convertView.findViewById(R.id.textPrice_view);
        TextView textViewDesc = convertView.findViewById(R.id.textDesc_view);

        imageView.setImageResource(productImage[i]);
        textView.setText(productName[i]);
        textViewPrice.setText(productPrice[i]);
        textViewDesc.setText(productDescription[i]);

        return convertView;
    }
}
