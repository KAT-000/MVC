package com.seba.biblioapp.Modelo;

public class Revistas extends Material {

    String editorial;
    int periodicidad;

        public Revistas(String nombre, String editorial, int periodicidad){
        super(nombre, editorial, 0);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
    }

    public String setEditorial(){return editorial;}
    public int setPeriodicidad(){return periodicidad;}

    public void getEditorial(String editorial){this.editorial = editorial;}
    public void getPeriodicidad(int periodicidad){this.periodicidad = periodicidad;}
    
}
