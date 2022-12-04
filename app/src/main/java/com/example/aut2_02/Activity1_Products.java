package com.example.aut2_02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1_Products extends AppCompatActivity {

    GridView gridView;

    //DATOS DE LOS PRODUCTOS
   // Context context;
    //String str = context.getString(R.string.buddha_glovess);

    String[] productName = {"Buddha", "Buddha", "Leone", "Leone","Nike","Venum","Venum","Venun",""};
    String[] productDescription = {"Pantalón","Guantes","Zapatos","Casco","Zapatos","Vendas","Bucal","Guantes",""};
    String[] productDescExt = {
            "Shorts de Boxeo diseñados utilizando unos nuevos patrones para que el pantalón quede realmente cómodo, tanto para los entrenamientos como para la competición.\n" +"\n"+
                    "   - Ligeros y cómodos.\n" +
                    "   - Fabricados en Satén Premium.\n" +
                    "   - Diseñados para la Competición Amateur.\n" +
                    "   - Cintura ancha elástica.\n" +
                    "   - Aperturas en los laterales para una mejor libertad en movimiento.\n" +
                    "   - Etiqueta bordada.\n",
            "D2",
            "D3",
            "D4",
            "D5",
            "D6",
            "D7",
            "Diseñados para brindar una buena amortiguación en cada impacto y brindar una protección óptima a las articulaciones, gracias a una espuma de triple densidad.\n" +
            "\nSu sistema de ventilación microperforado facilita la evacuación del sudor y sus puños alargados aportan un confort adicional.\n" +
            "\nLos guantes de boxeo Phantom son aptos para un uso habitual de 3 a 4 veces por semana, así como para diferentes modalidades de boxeo.",""};
    String[] productPrice = {"30,90€", "64,90€", "89,90€", "129,90€","94,99€", "8,99€", "14,99€", "89,90€",""};
    int[] productImage = {R.drawable.buddha_shorts, R.drawable.buddha_gloves, R.drawable.leone_shoes,
            R.drawable.leone_casco, R.drawable.nike_shoes, R.drawable.venum_bandages,
            R.drawable.venum_bucal, R.drawable.venum_gloves,R.drawable.dot};

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
                builder.setMessage(productDescExt[i]);
                builder.setIcon(R.drawable.info);
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

        //PASO A LA ACTIVITY "MENÚ"
        Button menu = findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //PASO A LA ACTIVITY "CESTA"
        Button list = findViewById(R.id.productosButton);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Activity2_List.class);
                startActivity(intent);
            }
        });

    }


}