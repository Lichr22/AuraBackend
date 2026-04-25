package application.domain;

import application.util.FormValidationUtil;

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



        return perfil;
    }

    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil){

        try {
            perfil.edad = FormValidationUtil.validateInt("Ingrese la edad:");
            perfil.cicloPromedio = FormValidationUtil.validateInt("Ingrese el ciclo promedio (dias):");
            perfil.duracionPeriodoPromedio = FormValidationUtil.validateInt("Ingrese la duración promedio del periodo (dias):");
            perfil.usaAnticonceptivo = FormValidationUtil.validateBoolean("¿Usa anticonceptivo? (true/false):");
            perfil.tipoAnticonceptivo = FormValidationUtil.validateString("Ingrese el tipo de anticonceptivo:");
            return perfil;
        } catch (Exception e) {
            System.out.println("Error al registrar el perfil menstrual: " + e.getMessage());
            return null;
        }
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