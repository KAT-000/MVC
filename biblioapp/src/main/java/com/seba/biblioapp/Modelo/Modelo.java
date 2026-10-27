package com.seba.biblioapp.Modelo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private List<Libros> libros;
    private List<Revistas> revistas;
    private Gson gson;

    public Modelo() {
        this.libros = new ArrayList<>();
        this.revistas = new ArrayList<>();
        this.gson = new Gson();
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
        try (FileWriter writer = new FileWriter("Libros.json")) {
            gson.toJson(libros, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar los libros: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter("Revistas.json")) {
            gson.toJson(revistas, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar las revistas: " + e.getMessage());
        }
    }
    public void cargarDatos() {
        File archivoLibros = new File("Libros.json");
        if (archivoLibros.exists()) {
            try (FileReader reader = new FileReader(archivoLibros)) {
                Type tipoListaLibros = new TypeToken<ArrayList<Libros>>() {}.getType();
                List<Libros> cargados = gson.fromJson(reader, tipoListaLibros);
                if (cargados != null) {
                    libros = cargados;
                }
            } catch (IOException e) {
                System.out.println("Error al leer Libros.json: " + e.getMessage());
            }
        } else {
            libros = new ArrayList<>(); 
        }

        File archivoRevistas = new File("Revistas.json");
        if (archivoRevistas.exists()) {
            try (FileReader reader = new FileReader(archivoRevistas)) {
                Type tipoListaRevistas = new TypeToken<ArrayList<Revistas>>() {}.getType();
                List<Revistas> cargadosRev = gson.fromJson(reader, tipoListaRevistas);
                if (cargadosRev != null) {
                    revistas = cargadosRev;
                }
            } catch (IOException e) {
                System.out.println("Error al leer Revistas.json: " + e.getMessage());
            }
        } else {
            revistas = new ArrayList<>();
        }
    }
}