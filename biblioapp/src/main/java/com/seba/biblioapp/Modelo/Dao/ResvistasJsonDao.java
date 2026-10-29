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
import com.seba.biblioapp.Modelo.Revistas;

public class ResvistasJsonDao implements RevistaDao{

    private final String archivo = "Revistas.json";
    private final Gson gson = new Gson();

    @Override 
    public List<Revistas> obtenerTodos(){

        File file = new File(archivo);
        if(!file.exists()){return new ArrayList<>();}
        try (FileReader reader = new FileReader(file)){
            Type tipo = new TypeToken<ArrayList<Revistas>>() {}.getType();
            List<Revistas> lista = gson.fromJson(reader, tipo);
            return lista !=  null ? lista : new ArrayList<>(); 
        } catch (IOException e) {System.out.println("Error al leer Revistas.json: " + e.getMessage()); return new ArrayList<>();}
    }

    @Override
    public void guardar(List<Revistas> revistas){

        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(revistas, writer);
        } 
        catch (IOException e) {System.out.println("Error al guardar las revistas: " + e.getMessage());
        }
    }
}