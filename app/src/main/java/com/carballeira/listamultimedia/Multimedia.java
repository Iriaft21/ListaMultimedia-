package com.carballeira.listamultimedia;

import android.widget.ImageView;

import java.io.Serializable;

public class Multimedia implements Serializable {

    private String nombre;
    private String tipo;
    private int miniatura;
    private String ruta;

    public Multimedia(String nombre, String tipo, int miniatura, String ruta) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.miniatura = miniatura;
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(int miniatura) {
        this.miniatura = miniatura;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", miniatura=" + miniatura +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
