package com.example.enjoymath.Datos.LocalDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import com.example.enjoymath.Datos.Objetos.Locales.Historial;
import com.example.enjoymath.Datos.Objetos.Locales.UsuarioLocal;
import com.example.enjoymath.Negocio.AccesoMaestro;


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
        //db.execSQL(Consultas.CREACIÓN_VISTA_LOGROS_GENERAL);
        db.execSQL(Consultas.CREACIÓN_JUEGOS_NIVELES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertarNiveles(){
        if(this.tablaNivelesVacía()){
            SQLiteDatabase db = this.getWritableDatabase();
            for (String nivel : Consultas.INSERCIÓN_NIVELES)
                db.execSQL(nivel);
        }

    }

    /**
     *
     * @param usr
     */
    public void insertarUsuarioLocal(UsuarioLocal usr){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("NOMBRE",usr.getNombre());
        contenedor.put("APELLIDOS",usr.getApellidos());
        contenedor.put("USUARIO",usr.getUsuario());
        contenedor.put("REGISTRO",usr.getRegistro());
        contenedor.put("ACTIVO",0);
        db.insert(Consultas.NOMBRES_TABLAS[2], null, contenedor);
    }

    /**
     *
     * @return
     */
    public boolean primerArranque(){
        boolean dev;//Vaariable de retorno
        SQLiteDatabase db = this.getReadableDatabase();//Abrimos la base de datos para su lectura
        Cursor lector = db.rawQuery("SELECT ID_USUARIO FROM USUARIOS", null);//Ejecutamos el select para ver si existe algun usuario
        lector.moveToFirst();//Nos movemos al primer registro que arroje
        dev = (lector.getCount()==0);//Si el contador es menor a 0 quiere decir que no hay registros
        System.out.println(lector.getCount()+"numerod e lineas");
        lector.close();//Cerramos la lectura
        return dev;//devolvemos el valor
    }
    public int devolverUsuarioActivo(){
        int dev = -1;
        SQLiteDatabase db = this.getReadableDatabase();//Abrimos la base de datos para su lectura
        Cursor lector = db.rawQuery("SELECT ID_USUARIO FROM USUARIOS WHERE ACTIVO = 1", null);//Ejecutamos el select para ver si existe algun usuario
        lector.moveToFirst();//Nos movemos al primer registro que arroje
        dev =(lector.getCount()>0)? lector.getInt(0):-1;
        lector.close();
        return dev;
    }
    public String devolverHistorial(int idUsuario){
        String dev = null;
        SQLiteDatabase db = this.getReadableDatabase();//Abrimos la base de datos para su lectura
        Cursor lector = db.rawQuery("SELECT * FROM USUARIO where ID_USUARIO = ?", new String[]{String.valueOf(idUsuario)});//Ejecutamos el select para ver si existe algún usuario
        lector.moveToFirst();
        if(lector.getCount()>0)
            dev = lector.getInt(0) +","+lector.getInt(2)+","+lector.getString(1)+","+lector.getString(3);
        lector.close();
        return dev;
    }
    private boolean tablaNivelesVacía(){
        boolean dev = false;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor lector = db.rawQuery("SELECT ID_JUEGO FROM JUEGOS_NIVELES", null);
        dev = lector.getCount()==0;
        lector.close();
        return dev;
    }
}
