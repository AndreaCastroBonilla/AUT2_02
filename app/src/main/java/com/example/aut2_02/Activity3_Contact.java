package com.example.aut2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3_Contact extends AppCompatActivity {

    private EditText nombre,asunto,email,mensaje;
    private Button enviar;
    private CheckBox condicionCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_contact);

        nombre = findViewById(R.id.nombreText);
        asunto = findViewById(R.id.asuntoText);
        email = findViewById(R.id.emailText);
        mensaje = findViewById(R.id.mensajeText);
        enviar = findViewById(R.id.enviarButton);
        condicionCheck = findViewById(R.id.condicionesButton);

        //PASO A LA ACTIVITY "CESTA"
        Button cesta = findViewById(R.id.cestaButton);
        cesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Activity2_List.class);
                startActivity(intent);
            }
        });

        //PASO A LA ACTIVITY "MENÚ"
        Button menu = findViewById(R.id.mainButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.getText()==null || nombre.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "'nombre' obligatorio", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
                }else if(email.getText()==null || email.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "'email' obligatorio", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
                }else if(asunto.getText()==null || asunto.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "'asunto' obligatorio", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
                }else if(mensaje.getText()==null || mensaje.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "'mensaje' obligatorio", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
                }else if(!condicionCheck.isChecked()){
                    Toast.makeText(getApplicationContext(), "ACEPTA TÉRMINOS Y CONDICIONES", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
                }
                else {
                    enviar();
                    enviar.setText("ENVIANDO...");
                }

            }
        });
    }

    public void enviar(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{email.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT,asunto.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,mensaje.getText().toString());
        startActivity(Intent.createChooser(intent,"Send email"));
    }

}