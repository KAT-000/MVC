package com.seba.biblioapp;

import com.seba.biblioapp.Controlador.Controlador;
import com.seba.biblioapp.Modelo.Modelo;
import com.seba.biblioapp.Vista.Vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override 
    public void start(Stage primaryStage) throws Exception{

        Modelo modelo = new Modelo();
        Vista vista = new Vista(modelo);
        Controlador controlador = new Controlador(vista, modelo);

        primaryStage.setScene(vista.vista());
        primaryStage.setTitle("Trabajo esforzado MVC");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
