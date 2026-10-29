package com.seba.biblioapp.Modelo.Dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seba.biblioapp.Modelo.Libros;

public class LibroJsonDao implements LibroDao{

    private final String archivo = "Libros.json";
    private final Gson gson = new Gson();

    @Override 
    public List<Libros> obtenerTodos(){

        File file = new File(archivo);
        if(!file.exists()){return new ArrayList<>();}
        try (FileReader reader = new FileReader(file)){
            Type tipo = new TypeToken<ArrayList<Libros>>() {}.getType();
            List<Libros> lista = gson.fromJson(reader, tipo);
            return lista !=  null ? lista : new ArrayList<>(); 
        } catch (IOException e) {System.out.println("Error al leer Libros.json: " + e.getMessage()); return new ArrayList<>();}
    }

    @Override
    public void guardar(List<Libros> libros){

        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(libros, writer);
        } 
        catch (IOException e) {System.out.println("Error al guardar los libros: " + e.getMessage());
        }
    }
}