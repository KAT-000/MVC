package com.seba.biblioapp.Controlador;



import com.seba.biblioapp.Modelo.Libros;
import com.seba.biblioapp.Modelo.Modelo;
import com.seba.biblioapp.Modelo.Revistas;
import com.seba.biblioapp.Vista.Vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controlador {

    private Modelo modelo;
    private Vista vista;
    public Controlador(Vista vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;

        initEventos();
    }
     private void initEventos(){
        vista.getBtnSinLibros().setOnAction(e -> {
            vista.getPanel().setVisible(false); 
            vista.getPanel().setManaged(false);
            vista.getPanel2().setVisible(false); 
            vista.getPanel2().setManaged(false);
            vista.getSubpanel().setVisible(true); 
            vista.getSubpanel().setManaged(true);
        });
        vista.getBtnLibro().setOnAction(e -> {
            vista.getSubpanel().setVisible(false); 
            vista.getSubpanel().setManaged(false);
            vista.getOpcionLibro().setVisible(true); 
            vista.getOpcionLibro().setManaged(true);
        });
        vista.getBtnRevista().setOnAction(e -> {
            vista.getSubpanel().setVisible(false); 
            vista.getSubpanel().setManaged(false);
            vista.getOpcionRevista().setVisible(true); 
            vista.getOpcionRevista().setManaged(true);
        });
        EventHandler<ActionEvent> volverAlInicio = e -> {
            vista.getPanel().setVisible(true); 
            vista.getPanel().setManaged(true);
            vista.getPanel2().setVisible(true); 
            vista.getPanel2().setManaged(true);
            vista.getSubpanel().setVisible(false); 
            vista.getSubpanel().setManaged(false);
            vista.getOpcionLibro().setVisible(false); 
            vista.getOpcionLibro().setManaged(false);
            vista.getOpcionRevista().setVisible(false); 
            vista.getOpcionRevista().setManaged(false);
        };

        vista.getBtnRegresarLibro().setOnAction(volverAlInicio);
        vista.getBtnRegresarRevista().setOnAction(volverAlInicio);

        vista.getBtnAgregarLibro().setOnAction(e -> {
            String Titulo = vista.getTxfTituloLibro().getText();
            String Autor = vista.getTxfAutorLibro().getText();
            String fecha = vista.getTxfFechaPublicacion().getText();
            String paginasStr = vista.getTxfCantidadPaginas().getText();

            if(!Titulo.isEmpty() && !Autor.isEmpty() && !fecha.isEmpty() && !paginasStr.isEmpty()){
                try {
                    int paginas = Integer.parseInt(paginasStr);
                    int publicacion = Integer.parseInt(fecha);
                    Libros libroNuevo = new Libros(Titulo, Titulo, publicacion, Autor, paginas);

                    modelo.agregarLibro(libroNuevo);
                    modelo.guardarDatos();

                    System.out.println("Libro guardado con exito.");

                    vista.getTxfTituloLibro().clear();
                    vista.getTxfAutorLibro().clear();
                    vista.getTxfFechaPublicacion().clear();
                    vista.getTxfCantidadPaginas().clear();
                } catch (NumberFormatException ex) {
                    System.out.println("Error, la cantidad de paginas debe ser un numero entero.");
                }
            } else {
                System.out.println("Por favor, completa todos los campos.");
            }
        });

        vista.getBtnAgregarRevista().setOnAction(e -> {
            String nombreRev = vista.getTxfNombreRevista().getText();
            String editorialRev = vista.getTxfEditorialRevista().getText();
            String periodicidadRev = vista.getTxfPeriodicidad().getText();

            if(!nombreRev.isEmpty() && !editorialRev.isEmpty() && !periodicidadRev.isEmpty()){
                try{
                    Revistas revistaNueva = new Revistas(nombreRev, editorialRev, 0);
                    modelo.agregarRevista(revistaNueva);
                    modelo.guardarDatos();

                    System.out.println("Revista guardada con exito.");

                    vista.getTxfNombreRevista().clear();
                    vista.getTxfEditorialRevista().clear();
                    vista.getTxfPeriodicidad().clear();
                } catch (Exception ex) {
                    System.out.println("Error al guardar la revista.");
                }
            } else {System.out.println("Por favor, completa todos los campos.");}
        });


        vista.getBtnBuscar().setOnAction(e -> {
            String busqueda = vista.getTxfIngresarLibro().getText().trim();

            if (!busqueda.isEmpty()) {
                Libros libroEncontrado = null;
                Revistas revistaEncontrada = null;

            
                for (Libros lib : modelo.getLibros()) {
                    if (lib.setTitulo().equalsIgnoreCase(busqueda) || lib.setNombre().equalsIgnoreCase(busqueda)) {
                        libroEncontrado = lib;
                        break;
                    }
                }

              
                if (libroEncontrado == null) {
                    for (Revistas rev : modelo.getRevistas()) {
                        if (rev.setNombre().equalsIgnoreCase(busqueda) || rev.setEditorial().equalsIgnoreCase(busqueda)) {
                            revistaEncontrada = rev;
                            break;
                        }
                    }
                }

                
                if (libroEncontrado != null) {
                    vista.getLblResNombre().setText("Nombre: " + libroEncontrado.setNombre());
                    vista.getLblResTitulo().setText("Titulo: " + libroEncontrado.setTitulo());
                    vista.getLblResPublicacion().setText("Fecha de publicacion: " + libroEncontrado.setPublicacion());
                    vista.getLblResAutor().setText("Autor: " + libroEncontrado.setAutor());
                    vista.getLblResPaginas().setText("Paginas: " + libroEncontrado.setPaginas());
                    vista.getLblResEditorial().setText("Editorial: -");
                    vista.getLblResPeriodicidad().setText("Periodicidad: -");
                    System.out.println("¡Libro encontrado y mostrado en pantalla!");
                } else if (revistaEncontrada != null) {
                    vista.getLblResNombre().setText("Nombre: " + revistaEncontrada.setNombre());
                    vista.getLblResTitulo().setText("Titulo: -");
                    vista.getLblResPublicacion().setText("Fecha de publicacion: -");
                    vista.getLblResAutor().setText("Autor: -");
                    vista.getLblResPaginas().setText("Paginas: -");
                    vista.getLblResEditorial().setText("Editorial: " + revistaEncontrada.setEditorial());
                    vista.getLblResPeriodicidad().setText("Periodicidad: " + revistaEncontrada.setPeriodicidad());
                    System.out.println("¡Revista encontrada y mostrada en pantalla!");
                } else {
                    System.out.println("No se encontró ningún material con ese nombre.");
                    vista.getLblResNombre().setText("Nombre: No encontrado");
                    vista.getLblResTitulo().setText("Titulo: -");
                    vista.getLblResPublicacion().setText("Fecha de publicacion: -");
                    vista.getLblResAutor().setText("Autor: -");
                    vista.getLblResPaginas().setText("Paginas: -");
                    vista.getLblResEditorial().setText("Editorial: -");
                    vista.getLblResPeriodicidad().setText("Periodicidad: -");
                }
            } else {
                System.out.println("Por favor, ingresa un término de búsqueda.");
            }
        });
    }
}
   