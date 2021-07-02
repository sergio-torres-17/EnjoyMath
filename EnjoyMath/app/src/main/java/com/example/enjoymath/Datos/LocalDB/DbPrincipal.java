package com.example.enjoymath.Datos.LocalDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
