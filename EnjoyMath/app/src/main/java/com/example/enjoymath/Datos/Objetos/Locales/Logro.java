package com.example.enjoymath.Datos.Objetos.Locales;

public class Logro {
    private int idLogro;
    private String nombreLogro;
    private int puntosEquivalentes;

    public Logro(String nombreLogro, int puntosEquivalentes) {
        this.nombreLogro = nombreLogro;
        this.puntosEquivalentes = puntosEquivalentes;
    }

    public Logro(int idLogro, String nombreLogro, int puntosEquivalentes) {
        this.idLogro = idLogro;
        this.nombreLogro = nombreLogro;
        this.puntosEquivalentes = puntosEquivalentes;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public String getNombreLogro() {
        return nombreLogro;
    }

    public void setNombreLogro(String nombreLogro) {
        this.nombreLogro = nombreLogro;
    }

    public int getPuntosEquivalentes() {
        return puntosEquivalentes;
    }

    public void setPuntosEquivalentes(int puntosEquivalentes) {
        this.puntosEquivalentes = puntosEquivalentes;
    }
}
