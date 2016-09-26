package com.example.wladimir.moviesathome;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Wladimir on 26/09/2016.
 */
public class ListaActivity extends AppCompatActivity {

    Cursor registros;
    //Encapsulo en variables los datos de la pelicula que esta en el do while paa pasarlos por intent al infopelicula
    String nombrePeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ArrayList<String> peliculas = new ArrayList<>();
        SQLiteMovieAtHome admin = new SQLiteMovieAtHome(this, "MovieAtHome", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String q = "SELECT * FROM movie ORDER BY nombre ASC";
        registros = db.rawQuery(q, null);
        if (registros.moveToFirst()) {
            do {
                peliculas.add(registros.getString(1));
            } while (registros.moveToNext());
        }

        ListView listView = (ListView) findViewById(R.id.listCartelera);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_pelicula, R.id.nombre, peliculas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ItemList());

    }


    class ItemList implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewGroup = (ViewGroup) view;
            TextView textView = (TextView) viewGroup.findViewById(R.id.nombre);
            Intent intent = new Intent(ListaActivity.this, VerActivity.class);
            nombrePeli = textView.getText().toString() ;
            intent.putExtra("nombrePeli", nombrePeli);
            startActivity(intent);
        }
    }

}
