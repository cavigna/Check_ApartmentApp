package com.example.checkapartment.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "departamentos")
public class Departamento {

    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre;
    String unidad;
    String direccion;
    String url = "";
    int luces;
    int bath;
    int cocina;
    int dormitorio;
    int terminaciones;
    int puntaje;

    public Departamento(int id, String nombre, String unidad, String direccion,
                        String url, int luces, int bath, int cocina, int dormitorio,
                        int terminaciones) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.url = url;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }

    @Ignore
    public Departamento(String nombre, String unidad, String direccion,
                        String url, int luces, int bath, int cocina,
                        int dormitorio, int terminaciones) {

        this.nombre = nombre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.url = url;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }

    public void calcularPuntaje(){
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

/*
    public Departamento(int id, String nombre, String unidad, String direccion,
                        String url, int luces, int bath, int cocina, int dormitorio,
                        int terminaciones) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.url = url;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }

    @Ignore
    public Departamento(String nombre, String unidad, String direccion,
                        String url, int luces, int bath, int cocina,
                        int dormitorio, int terminaciones) {

        this.nombre = nombre;
        this.unidad = unidad;
        this.direccion = direccion;
        this.url = url;
        this.luces = luces;
        this.bath = bath;
        this.cocina = cocina;
        this.dormitorio = dormitorio;
        this.terminaciones = terminaciones;
        this.puntaje = (luces + bath + cocina + dormitorio) * terminaciones;
    }
 */
