package com.example.enjoymath.Datos.Objetos.Locales;

public class JuegoNivel {
    private int id_logro;
    private String fecha;

    public JuegoNivel(int id_logro, String fecha) {
        this.id_logro = id_logro;
        this.fecha = fecha;
    }

    public int getId_logro() {
        return id_logro;
    }

    public void setId_logro(int id_logro) {
        this.id_logro = id_logro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
