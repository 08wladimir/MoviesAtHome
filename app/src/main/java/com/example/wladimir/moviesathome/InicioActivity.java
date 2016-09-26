package com.example.wladimir.moviesathome;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Wladimir on 21/09/2016.
 */
public class InicioActivity extends AppCompatActivity {

    private EditText edit1, edit2;
    String consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        edit1 = (EditText) findViewById(R.id.editUser);
        edit2 = (EditText) findViewById(R.id.editPass);

    }

    public void iniciar(View v) {

        consulta = "SELECT * FROM movie WHERE (disponible > 0) ORDER BY nombre ASC";

        SQLiteMovieAtHome admin = new SQLiteMovieAtHome(this,"MovieAtHome", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String user = edit1.getText().toString();
        String pass = edit2.getText().toString();

        Cursor datos = bd.rawQuery("select usuario,contraseña  from users where usuario ='"+ user +"' and contraseña = '"+ pass +"'", null);
        if (datos.moveToFirst()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("Inicio sesion correctamente")
                    .setTitle("Inicio de Sesion");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    EditText textView = (EditText) findViewById(R.id.editUser);
                    Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                    String nombreUsuario = textView.getText().toString() ;
                    intent.putExtra("nombreUsuario", nombreUsuario);
                    intent.putExtra("consulta", consulta);
                    startActivity(intent);
                }
            });

            builder.create().show();
        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("Inicio sesion incorrectamente")
                    .setTitle("Inicio de Sesion");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                    startActivity(intent);
                }
            });

            builder.create().show();
        }
        bd.close();

    }

}
