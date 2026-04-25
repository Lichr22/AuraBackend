package application.domain;


import java.time.LocalDate;
import java.util.Scanner;

public class Prediccion {

    Scanner sc = new Scanner(System.in);

    private int idPrediccion;
    private Usuario usuario;
    private LocalDate fechaCalculo;
    private LocalDate proximaMenstruacionEstimada;
    private LocalDate inicioVentanaFertil;
    private LocalDate finVentanaFertil;
    private String probabilidadEmbarazo;

    // CONSTRUCTORES
//Vacio
    public Prediccion() {
    }

    //Con atributos
    public Prediccion(int idPrediccion, Usuario usuario, LocalDate fechaCalculo,
                      LocalDate proximaMenstruacionEstimada, LocalDate inicioVentanaFertil,
                      LocalDate finVentanaFertil, String probabilidadEmbarazo) {

        this.idPrediccion = idPrediccion;
        this.usuario = usuario;
        this.fechaCalculo = fechaCalculo;
        this.proximaMenstruacionEstimada = proximaMenstruacionEstimada;
        this.inicioVentanaFertil = inicioVentanaFertil;
        this.finVentanaFertil = finVentanaFertil;
        this.probabilidadEmbarazo = probabilidadEmbarazo;
    }

    //Solo ID
    public Prediccion(int idPrediccion) {
        this.idPrediccion = idPrediccion;
    }

// GETTERS Y SETTERS

    public int getIdPrediccion() {
        return idPrediccion;
    }

    public void setIdPrediccion(int idPrediccion) {
        this.idPrediccion = idPrediccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCalculo() {
        return fechaCalculo;
    }

    public void setFechaCalculo(LocalDate fechaCalculo) {
        this.fechaCalculo = fechaCalculo;
    }

    public LocalDate getProximaMenstruacionEstimada() {
        return proximaMenstruacionEstimada;
    }

    public void setProximaMenstruacionEstimada(LocalDate proximaMenstruacionEstimada) {
        this.proximaMenstruacionEstimada = proximaMenstruacionEstimada;
    }

    public LocalDate getInicioVentanaFertil() {
        return inicioVentanaFertil;
    }

    public void setInicioVentanaFertil(LocalDate inicioVentanaFertil) {
        this.inicioVentanaFertil = inicioVentanaFertil;
    }

    public LocalDate getFinVentanaFertil() {
        return finVentanaFertil;
    }

    public void setFinVentanaFertil(LocalDate finVentanaFertil) {
        this.finVentanaFertil = finVentanaFertil;
    }

    public String getProbabilidadEmbarazo() {
        return probabilidadEmbarazo;
    }

    public void setProbabilidadEmbarazo(String probabilidadEmbarazo) {
        this.probabilidadEmbarazo = probabilidadEmbarazo;
    }

// METODOS

    public Prediccion createPrediccion(Prediccion prediccion) {

        System.out.println("Ingrese el id de la prediccion");
        int idPrediccion = sc.nextInt();
        prediccion.idPrediccion = idPrediccion;
        sc.nextLine();

        System.out.println("Ingrese la fecha de cálculo (AAAA-MM-DD)");
        String fechaCalculo = sc.nextLine();
        prediccion.fechaCalculo = LocalDate.parse(fechaCalculo);

        System.out.println("Ingrese la próxima menstruación estimada (AAAA-MM-DD)");
        String proximaMenstruacion = sc.nextLine();
        prediccion.proximaMenstruacionEstimada = LocalDate.parse(proximaMenstruacion);

        System.out.println("Ingrese inicio de la ventana fértil (AAAA-MM-DD)");
        String inicioVentana = sc.nextLine();
        prediccion.inicioVentanaFertil = LocalDate.parse(inicioVentana);

        System.out.println("Ingrese fin de la ventana fértil (AAAA-MM-DD)");
        String finVentana = sc.nextLine();
        prediccion.finVentanaFertil = LocalDate.parse(finVentana);

        System.out.println("Ingrese probabilidad de embarazo");
        String probabilidad = sc.nextLine();
        prediccion.probabilidadEmbarazo = probabilidad;

        return prediccion;
    }

//Get

    public void getPrediccion(int id) {

        if (this.idPrediccion == id) {

            System.out.println("Id Prediccion: " + this.idPrediccion + "\n" +
                    "Fecha Calculo: " + this.fechaCalculo + "\n" +
                    "Proxima menstruacion estimada: " + this.proximaMenstruacionEstimada + "\n" +
                    "Inicio ventana fertil: " + this.inicioVentanaFertil + "\n" +
                    "Fin ventana fertil: " + this.finVentanaFertil + "\n" +
                    "Probabilidad de embarazo: " + this.probabilidadEmbarazo + "\n");

        } else {

            System.out.println("Valide el id de la predicción que está consultando");

        }

    }
}