package com.seba.biblioapp.Modelo.Dao;

import java.util.List;

import com.seba.biblioapp.Modelo.Revistas;

public interface RevistaDao {
    List<Revistas> obtenerTodos();
    void guardar(List<Revistas> Revistas);
}
