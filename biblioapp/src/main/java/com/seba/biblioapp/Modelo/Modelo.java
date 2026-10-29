package com.seba.biblioapp.Modelo;

import com.seba.biblioapp.Modelo.Dao.LibroDao;
import com.seba.biblioapp.Modelo.Dao.LibroJsonDao;
import com.seba.biblioapp.Modelo.Dao.RevistaDao;
import com.seba.biblioapp.Modelo.Dao.ResvistasJsonDao;

import java.util.List;

public class Modelo {
    private List<Libros> libros;
    private List<Revistas> revistas;

    private LibroDao libroDao;
    private RevistaDao revistaDao;

    public Modelo() {
        this.libroDao = new LibroJsonDao();
        this.revistaDao = new ResvistasJsonDao();
        cargarDatos(); 
    }

    public void agregarLibro(Libros libro) {
        libros.add(libro);
    }

    public void agregarRevista(Revistas revista) {
        revistas.add(revista);
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public List<Revistas> getRevistas() {
        return revistas;
    }

    public void guardarDatos() {
        libroDao.guardar(libros);
        revistaDao.guardar(revistas);
    }

    public void cargarDatos() {
        this.libros = libroDao.obtenerTodos();
        this.revistas = revistaDao.obtenerTodos();
    }
}