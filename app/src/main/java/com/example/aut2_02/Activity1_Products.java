package com.example.aut2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Activity1_Products extends AppCompatActivity {

    GridView gridView;

    String[] productName = {"uno","dos","tres","cuatro"};
    int[] numberImage ={R.drawable.leone_shoes,R.drawable.nike_shoes,R.drawable.buddha_shorts,R.drawable.buddha_gloves};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_products);

        gridView = findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

}