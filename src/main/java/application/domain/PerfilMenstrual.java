package application.domain;

import java.util.List;
import java.util.Scanner;

public class PerfilMenstrual {

    Scanner sc = new Scanner(System.in);

    private int idPerfil;
    private Usuario usuario;
    private int edad;
    private int cicloPromedio;
    private int duracionPeriodoPromedio;
    private Boolean usaAnticonceptivo;
    private String tipoAnticonceptivo;

    public PerfilMenstrual() {
    }

    public PerfilMenstrual(int idPerfil, Usuario usuario, Integer edad, Integer cicloPromedio,
                           Integer duracionPeriodoPromedio, Boolean usaAnticonceptivo,
                           String tipoAnticonceptivo) {
        this.idPerfil = idPerfil;
        this.usuario = usuario;
        this.edad = edad;
        this.cicloPromedio = cicloPromedio;
        this.duracionPeriodoPromedio = duracionPeriodoPromedio;
        this.usaAnticonceptivo = usaAnticonceptivo;
        this.tipoAnticonceptivo = tipoAnticonceptivo;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getCicloPromedio() {
        return cicloPromedio;
    }

    public void setCicloPromedio(Integer cicloPromedio) {
        this.cicloPromedio = cicloPromedio;
    }

    public Integer getDuracionPeriodoPromedio() {
        return duracionPeriodoPromedio;
    }

    public void setDuracionPeriodoPromedio(Integer duracionPeriodoPromedio) {
        this.duracionPeriodoPromedio = duracionPeriodoPromedio;
    }

    public Boolean getUsaAnticonceptivo() {
        return usaAnticonceptivo;
    }

    public void setUsaAnticonceptivo(Boolean usaAnticonceptivo) {
        this.usaAnticonceptivo = usaAnticonceptivo;
    }

    public String getTipoAnticonceptivo() {
        return tipoAnticonceptivo;
    }

    public void setTipoAnticonceptivo(String tipoAnticonceptivo) {
        this.tipoAnticonceptivo = tipoAnticonceptivo;
    }

    public PerfilMenstrual createPerfil(PerfilMenstrual perfil){

        System.out.println("Ingrese la edad");
        perfil.edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el ciclo promedio (dias)");
        perfil.cicloPromedio = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la duracion promedio del periodo (dias)");
        perfil.duracionPeriodoPromedio = sc.nextInt();
        sc.nextLine();

        System.out.println("Usa anticonceptivo? (true/false)");
        perfil.usaAnticonceptivo = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Ingrese el tipo de anticonceptivo");
        perfil.tipoAnticonceptivo = sc.nextLine();

        return perfil;
    }

    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil){

        System.out.println("Actualizar edad");
        perfil.edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Actualizar ciclo promedio");
        perfil.cicloPromedio = sc.nextInt();
        sc.nextLine();

        System.out.println("Actualizar duracion del periodo");
        perfil.duracionPeriodoPromedio = sc.nextInt();
        sc.nextLine();

        System.out.println("Actualizar si usa anticonceptivo (true/false)");
        perfil.usaAnticonceptivo = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Actualizar tipo anticonceptivo");
        perfil.tipoAnticonceptivo = sc.nextLine();

        return perfil;
    }

    public List<PerfilMenstrual> getAllPerfiles(){
        return null;
    }

    public void getPerfilById(int idPerfil, PerfilMenstrual perfil){

        if (this.idPerfil == idPerfil){
            System.out.println("Id Perfil: " + perfil.idPerfil +
                    "\n" + "Edad: " + perfil.edad +
                    "\n" + "Ciclo Promedio: " + perfil.cicloPromedio +
                    "\n" + "Duracion Periodo: " + perfil.duracionPeriodoPromedio +
                    "\n" + "Usa Anticonceptivo: " + perfil.usaAnticonceptivo +
                    "\n" + "Tipo Anticonceptivo: " + perfil.tipoAnticonceptivo + "\n");
        }

    }

    public void deletePerfil(int idPerfil){

    }

}