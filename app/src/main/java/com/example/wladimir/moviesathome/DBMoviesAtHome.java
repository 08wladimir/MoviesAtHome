package com.example.wladimir.moviesathome;

/**
 * Created by Wladimir on 26/09/2016.
 */
public class DBMoviesAtHome {

    public static final String user ="users";
    public static final String codigo = "codigo";
    public static final String nombre = "nombre";
    public static final String apellido = "apellido";
    public static final String edad = "edad";
    public static final String usuario = "usuario";
    public static final String contraseña = "contraseña";

    public static final String movie = "movie";
    public static final String codigoM = "codigo";
    public static final String titulo = "nombre";
    public static final String sinopsis = "sinopsis";
    public static final String duracion = "duracion";
    public static final String estreno = "estreno";
    public static final String calificacion = "calificacion";
    public static final String tipo = "tipo";
    public static final String disponible = "disponible";
    public static final String imagen = "imagen";

    public static final String reserva = "reserva";
    public static final String pelicula = "pelicula";
    public static final String reservado = "reservado";
    public static final String dias = "dias";
    public static final String precio = "precio";

    public static final String tblUser = "CREATE TABLE "+user+" ("
            +codigo+" VARCHAR(15) PRIMARY KEY NOT NULL, "
            +nombre+ " VARCHAR(15) NOT NULL,"
            +apellido+ " VARCHAR(15) NOT NULL,"
            +edad+ " VARCHAR(15) NOT NULL,"
            +usuario+ " VARCHAR(15) NOT NULL,"
            +contraseña+ " VARCHAR(15) NOT NULL);";

    public  static final String tblMovie = "CREATE TABLE "+movie+" ("
            +codigoM+" VARCHAR(15) PRIMARY KEY NOT NULL, "
            +titulo+ " VARCHAR(20) NOT NULL,"
            +sinopsis+ " VARCHAR(50) NOT NULL,"
            +duracion+ " VARCHAR(15) NOT NULL,"
            +estreno+ " VARCHAR(15) NOT NULL,"
            +calificacion+ " VARCHAR(15) NOT NULL,"
            +tipo+ " VARCHAR(15) NOT NULL,"
            +disponible+ " VARCHAR(15) NOT NULL,"
            +imagen+ " VARCHAR(15) NOT NULL);";

    public static final String tblReserva = "CREATE TABLE "+reserva+" ("
            +pelicula+" VARCHAR(20) PRIMARY KEY NOT NULL, "
            +reservado+ " VARCHAR(15) NOT NULL,"
            +dias+ " VARCHAR(15) NOT NULL,"
            +precio+ " VARCHAR(15) NOT NULL);";

}
