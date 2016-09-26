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
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Wladimir on 26/09/2016.
 */
public class ReservaActivity extends AppCompatActivity {

    String nombrePeli, nombreUsuario, reserva, consulta;
    private TextView e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        nombrePeli = getIntent().getStringExtra("nombrePeli");
        nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        reserva = getIntent().getStringExtra("reserva");

        e1 = (TextView) findViewById(R.id.txt2);
        e2 = (TextView) findViewById(R.id.txt4);
        e3 = (TextView) findViewById(R.id.txt6);
        e4 = (TextView) findViewById(R.id.txt8);

        int suma = Integer.parseInt(reserva);
        suma = suma * 5000;

        e1.setText(nombrePeli);
        e2.setText(nombreUsuario);
        e3.setText(reserva);
        e4.setText(String.valueOf(suma));

    }

    public void confirmar(View v){
        SQLiteMovieAtHome admin = new SQLiteMovieAtHome(this, "MovieAtHome", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        Cursor movie = db.rawQuery(" SELECT * FROM movie WHERE nombre='"+nombrePeli+"' ", null);
        int d = 0;
        if (movie.moveToFirst()) {
            d  = Integer.parseInt(movie.getString(7));
        }
        d = (d - 1);
        db.execSQL("UPDATE movie SET disponible = '"+ d +"' WHERE nombre = '"+nombrePeli+"'");

        String pelicula = e1.getText().toString();
        String reservado = e1.getText().toString();
        String dias = e1.getText().toString();
        String precio = e1.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("pelicula", pelicula);
        registro.put("reservado", reservado);
        registro.put("dias", dias);
        registro.put("precio", precio);

        db.insert("reserva", null, registro);
        db.close();

        consulta = "SELECT * FROM movie WHERE (disponible > 0) ORDER BY nombre ASC";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Reservacion Exitosa")
                .setTitle("Reservacion");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
                intent.putExtra("consulta", consulta);
                startActivity(intent);
            }
        });

        builder.create().show();

    }

}
