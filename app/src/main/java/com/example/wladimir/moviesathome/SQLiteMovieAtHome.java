package com.example.wladimir.moviesathome;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wladimir on 26/09/2016.
 */
public class SQLiteMovieAtHome extends SQLiteOpenHelper {

    public SQLiteMovieAtHome(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBMoviesAtHome.tblUser);
        db.execSQL(DBMoviesAtHome.tblMovie);

        db.execSQL("insert into users values('1','Vikmar','Ruiz','23','Sair','vikmar1993')");
        db.execSQL("insert into users values('2','Wladimir','Rodriguez','21','Wlacho','wladimir1995')");

        db.execSQL("insert into movie values('1','Superman','Hombre muy fuerte llega a la tierra','1:45:32','12/02/2016','0','Blu Ray','2','R.drawable.superman')");
        db.execSQL("insert into movie values('2','Harry Potter','Niño mago que es el heredero','2:55:21','01/07/2016','0','Blu Ray 3D','2','R.drawable.superman')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists movie");
    }

}
