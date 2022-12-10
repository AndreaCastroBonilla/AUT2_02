package com.example.aut2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(condicionCheck.isChecked()){
                    enviar();
                    enviar.setText("ENVIANDO...");
                }else {
                    Toast.makeText(getApplicationContext(), "ACEPTA CONDICIONES Y TÉRMINOS", Toast.LENGTH_LONG).show();
                    enviar.setText("ENVIAR");
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

    public void loguearCheckbox(View view) {
        String s = "Estado: " + (condicionCheck.isChecked() ? "Marcado" : "No Marcado");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}