package com.example.wladimir.moviesathome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistrarse, btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.btnIrIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registrarse = new Intent(MainActivity.this, InicioActivity.class);
                startActivity(registrarse);
            }
        });

        btnRegistrarse = (Button) findViewById(R.id.btnIrRegistrar);
        btnRegistrarse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registrarse = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(registrarse);
            }
        });

    }
}
