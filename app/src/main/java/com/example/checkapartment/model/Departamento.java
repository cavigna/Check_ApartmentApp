package com.example.checkapartment.model;

public class Departamento {

    int id;

    String calle;

    int luces;
    int bath;
    int cocina;
    int dormitorio;
    int terminaciones;
    int puntaje;

    public Departamento(int id, String calle, int luces, int bath, int cocina, int dormitorio, int terminaciones) {
        this.id = id;
        this.calle = calle;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }


    public Departamento(String calle, int luces, int bath, int cocina, int dormitorio, int terminaciones) {
        this.calle = calle;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getLuces() {
        return luces;
    }

    public void setLuces(int luces) {
        this.luces = luces;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getCocina() {
        return cocina;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

    public int getDormitorio() {
        return dormitorio;
    }

    public void setDormitorio(int dormitorio) {
        this.dormitorio = dormitorio;
    }

    public int getTerminaciones() {
        return terminaciones;
    }

    public void setTerminaciones(int terminaciones) {
        this.terminaciones = terminaciones;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
