package com.example.enjoymath.Negocio;

import android.content.Context;

import com.example.enjoymath.Datos.LocalDB.DbPrincipal;
import com.example.enjoymath.Datos.Objetos.Locales.Historial;

import java.io.Serializable;

public class AccesoMaestro implements Serializable {//Se implementa serializable para poder usar un objeto de conexión en toda la app
    private transient Context context;
    private  transient DbPrincipal dbPrincipal;

    public Context getContext() {
        return context;
    }
    public void setContext(Context context) {
        this.context = context;
    }


    public AccesoMaestro(Context context) {
        this.context = context;
        this.dbPrincipal = new DbPrincipal(this.context);
    }
    public boolean validarPrimerArranque(){return this.dbPrincipal.primerArranque();}
    public void insertarNiveles(){this.dbPrincipal.insertarNiveles();}
    public Historial devolverHistorialActual(){
        int idUsuario = this.dbPrincipal.devolverUsuarioActivo();
        return new Historial(this.dbPrincipal.devolverHistorial(idUsuario).split(","));
    }

}
