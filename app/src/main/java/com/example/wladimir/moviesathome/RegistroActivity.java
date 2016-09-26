package com.example.wladimir.moviesathome;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Wladimir on 19/09/2016.
 */

public class RegistroActivity extends AppCompatActivity {

    private EditText edit1, edit2, edit3, edit4, edit5, edit6;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        btn = (Button) findViewById(R.id.btnCancelar);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent volver = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(volver);
            }
        });

        edit1 = (EditText) findViewById(R.id.editCodigo);
        edit2 = (EditText) findViewById(R.id.editNombre);
        edit3 = (EditText) findViewById(R.id.editApellido);
        edit4 = (EditText) findViewById(R.id.editEdad);
        edit5 = (EditText) findViewById(R.id.editUsuario);
        edit6 = (EditText) findViewById(R.id.editContraseña);

    }

    public void registrarse(View v) {

        SQLiteMovieAtHome admin = new SQLiteMovieAtHome(this,"MovieAtHome", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String codigo = edit1.getText().toString();
        String nombre = edit2.getText().toString();
        String apellido = edit3.getText().toString();
        String edad = edit4.getText().toString();
        String usuario = edit5.getText().toString();
        String contraseña = edit6.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);
        registro.put("edad", edad);
        registro.put("usuario", usuario);
        registro.put("contraseña", contraseña);

        bd.insert("users", null, registro);
        bd.close();

        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
        edit5.setText("");
        edit6.setText("");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Se registro correctamente")
                .setTitle("Registro");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                startActivity(intent);
            }
        });

        builder.create().show();

    }


    public void limpiar(View v) {
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
        edit5.setText("");
        edit6.setText("");
    }

}
