package com.seba.biblioapp.Modelo;

abstract class Material {
    private String nombre;
    private String titulo;
    private int publicacion;

    public Material(String nombre, String titulo, int publicacion){
        this.titulo = titulo;
        this.nombre = nombre;
        this.publicacion = publicacion;
    }

    public String setTitulo(){return titulo;}
    public String setNombre(){return nombre;}
    public int setPublicacion(){return publicacion;}
    
    public void getTitulo(String titulo){this.titulo = titulo;}
    public void getNombre(String nombre){this.nombre = nombre;}
    public void getPublicacion(int publicacion){this.publicacion = publicacion;}

}
