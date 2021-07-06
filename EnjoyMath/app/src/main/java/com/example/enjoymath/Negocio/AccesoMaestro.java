package com.example.enjoymath.Negocio;

import android.content.Context;

import com.example.enjoymath.Datos.LocalDB.DbPrincipal;
import com.example.enjoymath.Datos.Objetos.Locales.Historial;
import com.example.enjoymath.Datos.Objetos.Locales.UsuarioLocal;

import java.io.Serializable;

public class AccesoMaestro{//Se implementa serializable para poder usar un objeto de conexión en toda la app
    private  Context context;
    private  DbPrincipal dbPrincipal;


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
    public void insertarDatos(UsuarioLocal usr){
        System.out.println("Mi base de datos nula: "+usr!=null);
        this.dbPrincipal.insertarUsuarioLocal(usr);
    }
    public int devolverIdActivo(){
        return this.dbPrincipal.devolverUsuarioArbitrario();
    }
    public Historial devolverHistorial(int id){
        System.out.println("Historial "+this.dbPrincipal.devolverHistorial(id));
        return new Historial(this.dbPrincipal.devolverHistorial(id).split(","));
    }
    public void actualizarInformaciónHistorial(int idUsuario, Historial historial){
        this.dbPrincipal.actualizarAvance(idUsuario, historial);
    }
    public int traerPuntosJuegoActual(int idJuegoActual){
        return this.dbPrincipal.traerPuntosJuegoActual(idJuegoActual);
    }

}
