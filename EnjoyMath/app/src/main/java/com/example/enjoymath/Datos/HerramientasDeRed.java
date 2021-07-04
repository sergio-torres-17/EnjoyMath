package com.example.enjoymath.Datos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Clase auxiliar para herramientas de red
 */
public class HerramientasDeRed {
    private Context context;

    public HerramientasDeRed(Context context) {
        this.context = context;
    }

    /**
     * Este método,verifica que haya conexión a internet
     * @return
     */
    public boolean pruebaPing(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
