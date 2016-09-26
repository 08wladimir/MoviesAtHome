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
    String nombrePeli, nombreUsuario;
    String consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        consulta = getIntent().getStringExtra("consulta");

        ArrayList<String> peliculas = new ArrayList<>();
        SQLiteMovieAtHome admin = new SQLiteMovieAtHome(this, "MovieAtHome", null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        registros = db.rawQuery(consulta, null);
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
            intent.putExtra("nombreUsuario", nombreUsuario);
            startActivity(intent);
        }
    }

    public void bluRay(View v){
        consulta = "SELECT * FROM movie WHERE tipo = 'Blu Ray' AND (disponible > 0)";
        Intent intent = new Intent(ListaActivity.this, ListaActivity.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        intent.putExtra("consulta", consulta);
        startActivity(intent);
    }

    public void bluRay3d(View v){
        consulta = "SELECT * FROM movie WHERE tipo = 'Blu Ray 3D' AND (disponible > 0)";
        Intent intent = new Intent(ListaActivity.this, ListaActivity.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        intent.putExtra("consulta", consulta);
        startActivity(intent);
    }

    public void sinFiltro(View v){
        consulta = "SELECT * FROM movie WHERE (disponible > 0) ORDER BY nombre ASC";
        Intent intent = new Intent(ListaActivity.this, ListaActivity.class);
        intent.putExtra("nombreUsuario", nombreUsuario);
        intent.putExtra("consulta", consulta);
        startActivity(intent);
    }

}
