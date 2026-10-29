package com.seba.biblioapp.Modelo.Dao;

import java.util.List;

import com.seba.biblioapp.Modelo.Libros;

public interface LibroDao {
    List<Libros> obtenerTodos();
    void guardar(List<Libros> Libros);
}
