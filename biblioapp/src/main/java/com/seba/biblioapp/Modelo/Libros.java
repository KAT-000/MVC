package com.seba.biblioapp.Modelo;

public class Libros extends Material{
    String autor;
    int paginas;

    public Libros(String titulo, String nombre, int publicacion, String autor, int paginas){
        super(titulo, nombre, publicacion);
        this.autor = autor;
        this.paginas = paginas;
    }

    public String setAutor(){return autor;}
    public int setPaginas(){return paginas;}

    public void getAutor(String autor){this.autor = autor;}
    public void getPaginas(int paginas){this.paginas = paginas;}
}
