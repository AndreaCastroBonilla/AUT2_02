package com.example.aut2_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2_List extends AppCompatActivity {

    private ListView lista;
    private List<String> items;
    private ArrayAdapter adapter;

    //VARIABLES PARA EL TOTAL DE PRODUCTOS Y PRECIO
    private int cont = 0;
    private double precio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_list);

        //ACCESO A CAMPOS DE TEXTO
        EditText txtNombre = findViewById(R.id.txtNombre);
        EditText txtCantidad = findViewById(R.id.txtCantidad);
        EditText txtPrecio = findViewById(R.id.txtPrecio);

        //ACCESO A BOTONES
        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnEliminar = findViewById(R.id.btnEliminar);

        TextView productosTxt = findViewById(R.id.productosText);
        TextView precioTxt = findViewById(R.id.precioText);

        //ACCESO A LA LISTA
        lista = findViewById(R.id.lista);
        items = new ArrayList<>();

        //ADAPTADOR PARA INTERACTUAR CON LA LISTA
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,items);
        lista.setAdapter(adapter);

        //AGREGAR PRODUCTOS
        btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Si el campo del nombre está vacío, no se añadirá el producto
                if(txtNombre.getText() == null || txtNombre.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "¡NOMBRE OBLIGATORI0!", Toast.LENGTH_LONG).show();

                }else if((txtCantidad.getText() != null || !txtCantidad.getText().toString().isEmpty()) &&
                        (txtPrecio.getText() != null || !txtPrecio.getText().toString().isEmpty())){

                    String str = txtNombre.getText().toString() + " - " + txtCantidad.getText().toString() + "u. - " + txtPrecio.getText().toString() + "€";
                    items.add(str);

                    cont = cont + Integer.parseInt(txtCantidad.getText().toString());
                    precio = precio + (Double.parseDouble(txtPrecio.getText().toString()) * Integer.parseInt(txtCantidad.getText().toString()));

                    if(cont == 1){
                        productosTxt.setText(String.valueOf(cont) + " producto");
                    } else {
                        productosTxt.setText(String.valueOf(cont) + " productos");
                    }
                    precioTxt.setText(String.valueOf(precio) + "€");
                }
                adapter.notifyDataSetChanged();
            }
        });

        //ELIMINAR PRODUCTOS
        btnEliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(items.size()>0){
                    items.remove(items.size()-1);
                }else {
                    Toast.makeText(getApplicationContext(), "¡LISTA VACÍA!", Toast.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
            }
        });

        //PASO A LA ACTIVITY "PRODUCTOS"
        Button productos = findViewById(R.id.productosButton);
        productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Activity1_Products.class);
                startActivity(intent);
            }
        });

        //PASO A LA ACTIVITY "CONTACTO"
        Button contacto = findViewById(R.id.contactoButton);
        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Activity3_Contact.class);
                startActivity(intent);
            }
        });

    }
}