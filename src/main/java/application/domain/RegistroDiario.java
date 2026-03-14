package application.domain;

import java.time.LocalDate;
import java.util.Scanner;

public class RegistroDiario {

    Scanner sc = new Scanner(System.in);

    private int idRegistro;
    private Usuario usuario;
    private Ciclo ciclo;
    private LocalDate fecha;
    private double temperaturaBasal;
    private double peso;
    private String calidadSueno;
    private String notasLibres;

    public RegistroDiario() {

    }

    public RegistroDiario(int idRegistro, Usuario usuario, Ciclo ciclo, LocalDate fecha,
                          double temperaturaBasal, double peso,
                          String calidadSueno, String notasLibres) {
        this.idRegistro = idRegistro;
        this.usuario = usuario;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.temperaturaBasal = temperaturaBasal;
        this.peso = peso;
        this.calidadSueno = calidadSueno;
        this.notasLibres = notasLibres;
    }

    public RegistroDiario(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTemperaturaBasal() {
        return temperaturaBasal;
    }

    public void setTemperaturaBasal(double temperaturaBasal) {
        this.temperaturaBasal = temperaturaBasal;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCalidadSueno() {
        return calidadSueno;
    }

    public void setCalidadSueno(String calidadSueno) {
        this.calidadSueno = calidadSueno;
    }

    public String getNotasLibres() {
        return notasLibres;
    }

    public void setNotasLibres(String notasLibres) {
        this.notasLibres = notasLibres;
    }

    public RegistroDiario createRegistro(RegistroDiario registro){

        System.out.println("Ingrese el id del registro");
        int id = sc.nextInt();
        registro.idRegistro = id;
        sc.nextLine();

        System.out.println("Ingrese la fecha (AAAA-MM-DD)");
        String fecha = sc.nextLine();
        registro.fecha = LocalDate.parse(fecha);

        System.out.println("Ingrese temperatura basal");
        double temperatura = sc.nextDouble();
        registro.temperaturaBasal = temperatura;
        sc.nextLine();

        System.out.println("Ingrese el peso");
        double peso = sc.nextDouble();
        registro.peso = peso;
        sc.nextLine();

        System.out.println("Ingrese la calidad del sueño");
        String sueno = sc.nextLine();
        registro.calidadSueno = sueno;

        System.out.println("Ingrese notas libres");
        String notas = sc.nextLine();
        registro.notasLibres = notas;

        return registro;
    }

    public void getRegistroById(int id , RegistroDiario registro){

        if(this.idRegistro == id){

            System.out.println("Id Registro: " + registro.idRegistro + "\n" +
                    "Fecha: " + registro.fecha + "\n" +
                    "Temperatura Basal: " + registro.temperaturaBasal + "\n" +
                    "Peso: " + registro.peso + "\n" +
                    "Calidad Sueño: " + registro.calidadSueno + "\n" +
                    "Notas: " + registro.notasLibres + "\n");

        } else {

            System.out.println("Valide el id del registro que está consultando");
        }

    }

}
