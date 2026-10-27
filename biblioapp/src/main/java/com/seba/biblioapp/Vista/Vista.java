package com.seba.biblioapp.Vista;


import com.seba.biblioapp.Modelo.Modelo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Vista {

    private Modelo modelo;

    private TextField txfIngresarLibro = new TextField();
    private Button btnBuscar = new Button("Buscar");

    private Label lblResNombre = new Label("Nombre: ");
    private Label lblResTitulo = new Label("Titulo: ");
    private Label lblResPublicacion = new Label("Fecha de publicacion: ");
    private Label lblResAutor = new Label("Autor: ");
    private Label lblResPaginas = new Label("Paginas: ");
    private Label lblResEditorial = new Label("Editorial: ");
    private Label lblResPeriodicidad = new Label("Periodicidad: ");

    private Button btnAgregarLibro = new Button("Agregar!");
    private Button btnAgregarRevista = new Button("Agregar!");
    private Button btnRegresarLibro = new Button("Regresar");
    private Button btnRegresarRevista = new Button("Regresar");
    private Button btnSinLibros = new Button("Registrar");
    private Button btnLibro = new Button("Libro");
    private Button btnRevista = new Button("Revista");

    private TextField txfTituloLibro = new TextField();
    private TextField txfAutorLibro = new TextField();
    private TextField txfFechaPublicacion = new TextField();
    private TextField txfCantidadPaginas = new TextField();

    private TextField txfNombreRevista = new TextField();
    private TextField txfEditorialRevista = new TextField();
    private TextField txfPeriodicidad = new TextField();

    private VBox panel;
    private HBox panel2;
    private VBox subpanel;
    private VBox OpcionLibro;
    private VBox OpcionRevista;

    public Vista(Modelo modelo){
        this.modelo = modelo;
    }

    public Scene vista(){

        Image imgFondo = new Image("https://i.pinimg.com/originals/a3/0c/4f/a30c4f26fc435774e54432112e6c48cd.png");
        ImageView imgvwFondo = new ImageView(imgFondo);
        imgvwFondo.setFitWidth(1920);
        imgvwFondo.setFitHeight(1080);
        imgvwFondo.setPreserveRatio(false);

        VBox fondo = new VBox(imgvwFondo);
        
        Label lblTitulo = new Label("Libreria generica");
        lblTitulo.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 32px;");
        

        VBox tituloDelInicio = new VBox(10, lblTitulo);
        tituloDelInicio.setAlignment(Pos.TOP_CENTER);



        Label lblIngresarLibro = new Label("Ingresa un libro");

        lblIngresarLibro.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        
        txfIngresarLibro.setPromptText("Ingresa el nombre de algun libro");
        btnBuscar.setStyle("-fx-border-radious: 8px;");

        VBox datosRecolectados = new VBox(10, lblResNombre, lblResTitulo, lblResPublicacion, lblResAutor, lblResPaginas, lblResEditorial, lblResPeriodicidad);
        datosRecolectados.setAlignment(Pos.CENTER);

        HBox ingresarLibro = new HBox(10, lblIngresarLibro, txfIngresarLibro, btnBuscar);
        ingresarLibro.setAlignment(Pos.CENTER);



        Label nombre = new Label("Nombre: ");
        nombre.setStyle("-fx-text-fill: white;");
        Label titulo = new Label("Titulo: ");
        titulo.setStyle("-fx-text-fill: white;");
        Label publicacion = new Label("Fecha de publicacion: ");
        publicacion.setStyle("-fx-text-fill: white;");
        Label autor = new Label("");
        autor.setStyle("-fx-text-fill: white;");
        Label paginas = new Label("");
        paginas.setStyle("-fx-text-fill: white;");
        Label editorial = new Label("");
        editorial.setStyle("-fx-text-fill: white;");
        Label periodicidad = new Label("");
        periodicidad.setStyle("-fx-text-fill: white;");

        lblResNombre.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResTitulo.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResPublicacion.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResAutor.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResPaginas.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResEditorial.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        lblResPeriodicidad.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

        VBox datosRecolectadosVBox = new VBox(10, nombre, titulo, publicacion, autor, paginas, editorial, periodicidad);
        datosRecolectados.setAlignment(Pos.CENTER);

        Label lblSinLibros = new Label("¿No hay libros registrados?");
        lblSinLibros.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        btnSinLibros.setStyle("-fx-border-radious: 8px;");

        Label lblTipo = new Label("¿Que tipo de material quieres registrar?");
        lblTipo.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        btnLibro.setStyle("-fx-border-radious: 8px;");
        btnRevista.setStyle("-fx-border-radious: 8px;");
        VBox tipo = new VBox(lblTipo);
        tipo.setAlignment(Pos.CENTER);
        HBox tiposMateriales = new HBox(100, btnLibro, btnRevista);
        tiposMateriales.setAlignment(Pos.CENTER);

        Label lblNombreRevista = new Label("Nombre");
        lblNombreRevista.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        Label lblEditorialRevista = new Label("Editorial");
        lblEditorialRevista.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        Label lblPeriodicidad = new Label("Periodicidad");
        lblPeriodicidad.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");


        txfNombreRevista = new TextField();
        txfNombreRevista.setPromptText("Nombre de la revista");
        txfEditorialRevista = new TextField();
        txfEditorialRevista.setPromptText("Editorial de la revista");
        txfPeriodicidad = new TextField();
        txfPeriodicidad.setPromptText("Periodicidad de la revista");



        Label lblTituloLibro = new Label("Titulo");
        lblTituloLibro.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        Label lblAutorLibro = new Label("Autor");
        lblAutorLibro.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        Label lblFechaPublicacion = new Label("Fecha de publicacion");
        lblFechaPublicacion.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");
        Label lblCantidadPaginas = new Label("Cantidad de paginas");
        lblCantidadPaginas.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14px;");

        txfTituloLibro = new TextField();
        txfTituloLibro.setPromptText("Titulo del libro");
        txfAutorLibro = new TextField();
        txfAutorLibro.setPromptText("Autor del libro");
        txfFechaPublicacion = new TextField();
        txfFechaPublicacion.setPromptText("Fecha de publicacion del libro");
        txfCantidadPaginas = new TextField();
        txfCantidadPaginas.setPromptText("Cantidad de paginas del libro");


        HBox botonesLibro = new HBox(10, btnAgregarLibro, btnRegresarLibro);
        HBox botonesRevista = new HBox(10, btnAgregarRevista, btnRegresarRevista);

        VBox OpcionLibro = new VBox(10, lblTituloLibro, txfTituloLibro, lblAutorLibro, txfAutorLibro, lblFechaPublicacion, txfFechaPublicacion, lblCantidadPaginas, txfCantidadPaginas, botonesLibro);
        OpcionLibro.setAlignment(Pos.BOTTOM_CENTER);
        OpcionLibro.setPadding(new Insets(15, 25, 15,25));
        OpcionLibro.setMaxWidth(420);
        OpcionLibro.setStyle(
        "-fx-background-color: rgba(29, 29, 29, 0.35);" + 
        "-fx-background-radius: 10;" +                     
        "-fx-border-color: rgba(61, 60, 60, 0.43);" +     
        "-fx-border-radius: 10;" +                           
        "-fx-border-width: 1.5;" +                       
        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.15), 15, 0, 0, 5);" 
        );

        VBox OpcionRevista = new VBox(10, lblNombreRevista, txfNombreRevista, lblEditorialRevista, txfEditorialRevista, lblPeriodicidad, txfPeriodicidad, botonesRevista);
        OpcionRevista.setAlignment(Pos.BOTTOM_CENTER);
        OpcionRevista.setPadding(new Insets(15, 25, 15,25));
        OpcionRevista.setMaxWidth(420);
        OpcionRevista.setStyle(
        "-fx-background-color: rgba(29, 29, 29, 0.35);" + 
        "-fx-background-radius: 10;" +                     
        "-fx-border-color: rgba(61, 60, 60, 0.43);" +     
        "-fx-border-radius: 10;" +                           
        "-fx-border-width: 1.5;" +                       
        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.15), 15, 0, 0, 5);" 
        );


        VBox subpanel = new VBox(10, tipo, tiposMateriales);
        subpanel.setAlignment(Pos.BOTTOM_CENTER);
        subpanel.setPadding(new Insets(15, 25, 15,25));
        subpanel.setMaxWidth(420);
        subpanel.setMaxHeight(360);
        subpanel.setStyle(
        "-fx-background-color: rgba(29, 29, 29, 0.35);" + 
        "-fx-background-radius: 10;" +                     
        "-fx-border-color: rgba(61, 60, 60, 0.43);" +     
        "-fx-border-radius: 10;" +                           
        "-fx-border-width: 1.5;" +                       
        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.15), 15, 0, 0, 5);" 
        );


        HBox panel2 = new HBox(10, lblSinLibros, btnSinLibros);
        panel2.setAlignment(Pos.BOTTOM_CENTER);
        panel2.setPadding(new Insets(15, 25, 15,25));
        panel2.setMaxWidth(420);
        panel2.setStyle(
        "-fx-background-color: rgba(29, 29, 29, 0.35);" + 
        "-fx-background-radius: 10;" +                     
        "-fx-border-color: rgba(61, 60, 60, 0.43);" +     
        "-fx-border-radius: 10;" +                           
        "-fx-border-width: 1.5;" +                       
        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.15), 15, 0, 0, 5);" 
        );

        VBox panel = new VBox(10, tituloDelInicio, ingresarLibro, datosRecolectados);
        panel.setPadding(new Insets(35));
        panel.setMaxHeight(360);
        panel.setMaxWidth(420);
        panel.setStyle(
        "-fx-background-color: rgba(29, 29, 29, 0.35);" + 
        "-fx-background-radius: 10;" +                     
        "-fx-border-color: rgba(61, 60, 60, 0.43);" +     
        "-fx-border-radius: 10;" +                           
        "-fx-border-width: 1.5;" +                       
        "-fx-effect: dropshadow(three-pass-box, rgba(0, 0, 0, 0.15), 15, 0, 0, 5);" 
        );

        subpanel.setVisible(false);
        subpanel.setManaged(false);
        OpcionLibro.setVisible(false);
        OpcionLibro.setManaged(false);
        OpcionRevista.setVisible(false);
        OpcionRevista.setManaged(false);

        VBox paneles = new VBox(20, panel, panel2, subpanel, OpcionLibro, OpcionRevista);
        paneles.setAlignment(Pos.TOP_CENTER);

        StackPane root = new StackPane(fondo, paneles);
        root.setAlignment(Pos.TOP_CENTER);
        StackPane.setMargin(paneles, new Insets(40, 0, 0, 0));
        root.setStyle("-fx-background-color: transparent;");

        btnSinLibros.setOnAction(e -> {panel.setVisible(false);
                                        panel.setManaged(false);
                                        panel2.setVisible(false);
                                        panel2.setManaged(false);
                                        subpanel.setVisible(true);
                                        subpanel.setManaged(true);
        });

        btnLibro.setOnAction(e -> {
            subpanel.setVisible(false);
            subpanel.setManaged(false);
            OpcionLibro.setVisible(true);
            OpcionLibro.setManaged(true);
        });

        btnRevista.setOnAction(e -> {
            subpanel.setVisible(false);
            subpanel.setManaged(false);
            OpcionRevista.setVisible(true);
            OpcionRevista.setManaged(true);
        });

        btnRegresarLibro.setOnAction(e -> {panel.setVisible(true);
                                        panel.setManaged(true);
                                        panel2.setVisible(true);
                                        panel2.setManaged(true);
                                        subpanel.setVisible(false);
                                        subpanel.setManaged(false);
                                        OpcionLibro.setVisible(false);
                                        OpcionLibro.setManaged(false);
                                        OpcionRevista.setVisible(false);
                                        OpcionRevista.setManaged(false);


        });
        btnRegresarRevista.setOnAction(e -> {panel.setVisible(true);
                                        panel.setManaged(true);
                                        panel2.setVisible(true);
                                        panel2.setManaged(true);
                                        subpanel.setVisible(false);
                                        subpanel.setManaged(false);
                                        OpcionLibro.setVisible(false);
                                        OpcionLibro.setManaged(false);
                                        OpcionRevista.setVisible(false);
                                        OpcionRevista.setManaged(false);


        });


        Scene vista = new Scene(root, 720, 480);



        return vista;
    }

    public Button getBtnAgregarLibro() { return btnAgregarLibro; }
    public Button getBtnAgregarRevista() { return btnAgregarRevista; }
    public Button getBtnRegresarLibro() { return btnRegresarLibro; }
    public Button getBtnRegresarRevista() { return btnRegresarRevista; }
    public Button getBtnSinLibros() { return btnSinLibros; }
    public Button getBtnLibro() { return btnLibro; }
    public Button getBtnRevista() { return btnRevista; }

    public TextField getTxfIngresarLibro() { return txfIngresarLibro; }
    public Button getBtnBuscar() { return btnBuscar; }

    public Label getLblResNombre() { return lblResNombre; }
    public Label getLblResTitulo() { return lblResTitulo; }
    public Label getLblResPublicacion() { return lblResPublicacion; }
    public Label getLblResAutor() { return lblResAutor; }
    public Label getLblResPaginas() { return lblResPaginas; }

    public TextField getTxfTituloLibro() { return txfTituloLibro; }
    public TextField getTxfAutorLibro() { return txfAutorLibro; }
    public TextField getTxfFechaPublicacion() { return txfFechaPublicacion; }
    public TextField getTxfCantidadPaginas() { return txfCantidadPaginas; }

    public TextField getTxfNombreRevista() { return txfNombreRevista; }
    public TextField getTxfEditorialRevista() { return txfEditorialRevista; }
    public TextField getTxfPeriodicidad() { return txfPeriodicidad; }

    public VBox getPanel() { return panel; }
    public HBox getPanel2() { return panel2; }
    public VBox getSubpanel() { return subpanel; }
    public VBox getOpcionLibro() { return OpcionLibro; }
    public VBox getOpcionRevista() { return OpcionRevista; }
    public Label getLblResEditorial() { return lblResEditorial; }
    public Label getLblResPeriodicidad() { return lblResPeriodicidad; }
}
