package com.example.aut2_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MENÚ -> ACTIVIDAD 1
        next = (Button) findViewById(R.id.productosButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Activity1_Products.class);
                startActivity(i);
            }
        });

        //MENÚ -> ACTIVIDAD 2
        next = (Button) findViewById(R.id.cestaButton);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Activity2_List.class);
                startActivity(i);
            }
        });

        //DECLARAR E INSTANCIAR EL DIÁLOGO QUE EMERGERÁ AL PULSAR "ABOUT"
        ImageButton about = (ImageButton) findViewById(R.id.aboutButton);

        //FUNCIONALIDAD AL PULSAR EL BOTÓN
        about.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Andrea Castro Bonilla v1.0.0 2022©", Toast.LENGTH_LONG).show();
            }
        });
    }
}