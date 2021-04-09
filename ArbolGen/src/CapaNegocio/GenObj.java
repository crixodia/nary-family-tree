package CapaNegocio;

import java.util.Objects;

public class GenObj {

    private String nombre;
    private String conyuge;
    private int anioNace;
    private int anioFallece;

    public GenObj(String nombre, String conyuge, int anioNace, int anioFallece) {
        this.nombre = nombre;
        this.conyuge = conyuge;
        this.anioNace = anioNace;
        this.anioFallece = anioFallece;
    }

    public GenObj(String nombre, String conyuge) {
        this.nombre = nombre;
        this.conyuge = conyuge;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConyuge() {
        return conyuge;
    }

    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    public int getAnioNace() {
        return anioNace;
    }

    public void setAnioNace(int anioNace) {
        this.anioNace = anioNace;
    }

    public int getAnioFallece() {
        return anioFallece;
    }

    public void setAnioFallece(int anioFallece) {
        this.anioFallece = anioFallece;
    }

    @Override
    public String toString() {
        return nombre + ":" + conyuge;
    }

    public String toStringText() {
        return nombre + ":" + conyuge + ":" + anioNace + ":" + anioFallece;
    }

    @Override
    public boolean equals(Object obj) {
        GenObj aux = (GenObj) obj;
        return nombre.equals(aux.nombre) && conyuge.equals(aux.conyuge);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.conyuge);
        return hash;
    }
}
