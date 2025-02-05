package com.carballeira.listamultimedia;

import android.widget.ImageView;

public class Multimedia {

    private String nombre;
    private String tipo;
    private ImageView miniatura;

    public Multimedia(String nombre, String tipo, ImageView miniatura) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.miniatura = miniatura;
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

    public ImageView getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(ImageView miniatura) {
        this.miniatura = miniatura;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", miniatura=" + miniatura +
                '}';
    }
}
