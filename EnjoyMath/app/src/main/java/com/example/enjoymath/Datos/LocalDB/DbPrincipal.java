package com.example.enjoymath.Datos.LocalDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

public class DbPrincipal extends SQLiteOpenHelper {
    private final static int DB_VERSION = 1;
    public DbPrincipal(@Nullable Context context) {
        super(context, Consultas.NOMBRE_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Consultas.CREACIÓN_USUARIOS_LOCALES);
        db.execSQL(Consultas.CREACIÓN_HISTORIAL);
        db.execSQL(Consultas.CREACIÓN_LOGROS);
        db.execSQL(Consultas.CREACIÓN_USUARIOS_LOGROS);
        db.execSQL(Consultas.CREACIÓN_VISTA_LOGROS_GENERAL);
        db.execSQL(Consultas.CREACIÓN_JUEGOS_NIVELES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertarNiveles(){
        SQLiteDatabase db = this.getWritableDatabase();
        for (String nivel : Consultas.INSERCIÓN_NIVELES)
            db.execSQL(nivel);
    }
    public boolean primerArranque(){
        boolean dev;
        SQLiteDatabase db = this.getReadableDatabase();//Abrimos la base de datos para su lectura
        Cursor lector = db.rawQuery("SELECT ID_USUARIO FROM USUARIOS_LOCALES", null);//Ejecutamos el select para ver si existe algun usuario
        lector.moveToFirst();//Nos movemos al primer registro que arroje
        dev = (lector.getCount()>0);//Si el contaor es menor a 0 quiere decir que no hay registros
        lector.close();//Cerramos la lectura
        return dev;//devolvemos el valor
    }
}
