package application.repository;

import application.domain.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class CicloRepository {

    Scanner sc = new Scanner(System.in);

    private int idCiclo;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int duracionTotal;
    private boolean esRegular;

    // Constructors

    public CicloRepository(){

    }

    public CicloRepository(int idCiclo, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin,
                           int duracionTotal, boolean esRegular) {
        this.idCiclo = idCiclo;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.duracionTotal = duracionTotal;
        this.esRegular = esRegular;
    }

    public CicloRepository(int idCiclo){
        this.idCiclo = idCiclo;
    }

    // Getters and Setters

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(int duracionTotal) {
        this.duracionTotal = duracionTotal;
    }

    public boolean isEsRegular() {
        return esRegular;
    }

    public void setEsRegular(boolean esRegular) {
        this.esRegular = esRegular;
    }

    // Methods

    public CicloRepository createCiclo(CicloRepository ciclo){

        System.out.println("Ingrese el id del ciclo");
        int id = sc.nextInt();
        ciclo.idCiclo = id;
        sc.nextLine();

        System.out.println("Ingrese la fecha de inicio (AAAA-MM-DD)");
        String fechaInicio = sc.nextLine();
        ciclo.fechaInicio = LocalDate.parse(fechaInicio);

        System.out.println("Ingrese la fecha de fin (AAAA-MM-DD)");
        String fechaFin = sc.nextLine();
        ciclo.fechaFin = LocalDate.parse(fechaFin);

        System.out.println("Ingrese la duración total del ciclo");
        int duracion = sc.nextInt();
        ciclo.duracionTotal = duracion;
        sc.nextLine();

        System.out.println("¿El ciclo es regular? (true/false)");
        boolean regular = sc.nextBoolean();
        ciclo.esRegular = regular;

        return ciclo;
    }

    public void getCicloById(int id , CicloRepository ciclo){

        if(this.idCiclo == id){

            System.out.println("Id Ciclo: " + ciclo.idCiclo + "\n" +
                    "Fecha Inicio: " + ciclo.fechaInicio + "\n" +
                    "Fecha Fin: " + ciclo.fechaFin + "\n" +
                    "Duracion: " + ciclo.duracionTotal + "\n" +
                    "Regular: " + ciclo.esRegular + "\n");

        } else {

            System.out.println("Valide el id del ciclo que está consultando");

        }

    }



}
