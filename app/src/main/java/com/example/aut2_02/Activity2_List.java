package com.example.aut2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Activity2_List extends AppCompatActivity {

    private ListView lista;
    private List<String> items;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_list);

        EditText txtNombre = findViewById(R.id.txtNombre);
        EditText txtCantidad = findViewById(R.id.txtCantidad);
        EditText txtPrecio = findViewById(R.id.txtPrecio);

        Button btnAgregar = findViewById(R.id.btnAgregar);
        Button btnEliminar = findViewById(R.id.btnEliminar);
        lista = findViewById(R.id.lista);
        items = new ArrayList<>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,items);
        lista.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str = txtNombre.getText().toString() + " - " + txtCantidad.getText().toString() + "u. - " + txtPrecio.getText().toString() + "€";
                items.add(str);
                adapter.notifyDataSetChanged();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                items.remove(txtNombre.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}