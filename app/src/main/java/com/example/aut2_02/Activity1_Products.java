package com.example.aut2_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1_Products extends AppCompatActivity {

    GridView gridView;

    //DATOS DE LOS PRODUCTOS
    String[] productName = {"Buddha", "Buddha", "Leone", "Leone","Nike","Venum","Venum","Venun"};
    String[] productDescription = {"Descripción1","Descripción2","Descripción3","Descripción4","Descripción5","Descripción6","Descripción7","Descripción8"};
    String[] productDescExt = {"D1","D2","D3","D4","D5","D6","D7","D8"};
    String[] productPrice = {"50,99€", "50,99€", "50,99€", "50,99€","50,99€", "50,99€", "50,99€", "50,99€"};
    int[] productImage = {R.drawable.buddha_shorts, R.drawable.buddha_gloves, R.drawable.leone_shoes,
            R.drawable.leone_casco, R.drawable.nike_shoes, R.drawable.venum_bandages,
            R.drawable.venum_bucal, R.drawable.venum_gloves};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ASOCIAR EL LAYOUT A LA CLASE JAVA
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_products);

        //CARGAR EL GRID LAYOUT
        gridView = findViewById(R.id.gridView);

        //DECLARAR E INSTANCIAR LOS PRODUCTOS DEL GRID LAYOUT
        GridAdapter adapter = new GridAdapter(Activity1_Products.this, productName, productImage,productPrice,productDescription);
        gridView.setAdapter(adapter);

        //DECLARAR E INSTANCIAR EL DIÁLOGO QUE EMERGERÁ AL PULSAR LOS PRODUCTOS
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //FUNCIONALIDAD AL PULSAR UN PRODUCTO
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(getApplicationContext(), "You clicked" + productName[i], Toast.LENGTH_LONG).show();
                builder.setTitle("DESCRIPCIÓN");
                builder.setMessage(productDescription[i] + productDescExt[i]);
                builder.setIcon(R.drawable.about);
                builder.setNeutralButton("VOLVER", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //regresa automáticamente a la activity
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

}