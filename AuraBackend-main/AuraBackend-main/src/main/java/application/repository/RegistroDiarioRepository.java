package application.repository;

import application.domain.Ciclo;
import application.domain.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class RegistroDiarioRepository {

    Scanner sc = new Scanner(System.in);

    private int idRegistro;
    private Usuario usuario;
    private Ciclo ciclo;
    private LocalDate fecha;
    private double temperaturaBasal;
    private double peso;
    private String calidadSueno;
    private String notasLibres;

    public RegistroDiarioRepository() {

    }

    public RegistroDiarioRepository(int idRegistro, Usuario usuario, Ciclo ciclo, LocalDate fecha,
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





}
