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
        db.execSQL(DBMoviesAtHome.tblReserva);

        db.execSQL("insert into users values('1','Vikmar','Ruiz','23','Sair','vikmar1993')");
        db.execSQL("insert into users values('2','Wladimir','Rodriguez','21','Wlacho','wladimir1995')");

        db.execSQL("insert into movie values('1','Superman','Hombre muy fuerte llega a la tierra','1:45:32','12/02/2016','0','Blu Ray','2','superman')");
        db.execSQL("insert into movie values('2','Harry Potter','Niño mago que es el heredero','2:55:21','01/07/2016','0','Blu Ray 3D','2','superman')");
        db.execSQL("insert into movie values('3','Star War','Niño mago que es el heredero','2:05:21','01/08/2016','0','Blu Ray 3D','2','superman')");
        db.execSQL("insert into movie values('4','La Mascara','Niño mago que es el heredero','1:55:21','05/09/2016','0','Blu Ray 3D','2','superman')");
        db.execSQL("insert into movie values('5','Deadpool','Niño mago que es el heredero','1:35:11','10/03/2016','0','Blu Ray 3D','2','superman')");
        db.execSQL("insert into movie values('6','X-Men','Niño mago que es el heredero','3:45:11','11/01/2016','0','Blu Ray','2','superman')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists movie");
    }

}
