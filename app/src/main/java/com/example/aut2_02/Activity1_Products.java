package com.example.aut2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Activity1_Products extends AppCompatActivity {

    private GridView gridView;
    private GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_products);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("prueba1");
        arrayList.add("prueba2");
        arrayList.add("prueba3");
        arrayList.add("prueba4");
        arrayList.add("prueba5");
        arrayList.add("prueba6");

        gridView = (GridView) findViewById(R.id.elementsGridView);
        adapter = new GridAdapter(this,arrayList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

}