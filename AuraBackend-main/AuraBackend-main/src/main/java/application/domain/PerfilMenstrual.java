package application.domain;

import application.util.FormValidationUtil;

import java.util.List;

public class PerfilMenstrual {

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

    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) {
        try {
            perfil.idPerfil = FormValidationUtil.validateInt("Ingrese el id del perfil:");
            perfil.edad = FormValidationUtil.validateInt("Ingrese la edad:");
            perfil.cicloPromedio = FormValidationUtil.validateInt("Ingrese el ciclo promedio (dias):");
            perfil.duracionPeriodoPromedio = FormValidationUtil.validateInt("Ingrese la duración promedio del periodo (dias):");
            perfil.usaAnticonceptivo = FormValidationUtil.validateBoolean("¿Usa anticonceptivo? (true/false):");
            perfil.tipoAnticonceptivo = FormValidationUtil.validateString("Ingrese el tipo de anticonceptivo:");
            System.out.println("Perfil menstrual creado exitosamente.");
            return perfil;
        } catch (Exception e) {
            System.out.println("Error al registrar el perfil menstrual: " + e.getMessage());
            return null;
        }
    }

    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil) {
        try {
            perfil.edad = FormValidationUtil.validateInt("Ingrese la nueva edad:");
            perfil.cicloPromedio = FormValidationUtil.validateInt("Ingrese el nuevo ciclo promedio (dias):");
            perfil.duracionPeriodoPromedio = FormValidationUtil.validateInt("Ingrese la nueva duración promedio del periodo (dias):");
            perfil.usaAnticonceptivo = FormValidationUtil.validateBoolean("¿Usa anticonceptivo? (true/false):");
            perfil.tipoAnticonceptivo = FormValidationUtil.validateString("Ingrese el tipo de anticonceptivo:");
            System.out.println("Perfil menstrual actualizado exitosamente.");
            return perfil;
        } catch (Exception e) {
            System.out.println("Error al actualizar el perfil menstrual: " + e.getMessage());
            return null;
        }
    }

    public void getPerfilById(int idPerfil) {
        if (this.idPerfil == idPerfil) {
            System.out.println("Id Perfil: " + this.idPerfil +
                    "\nEdad: " + this.edad +
                    "\nCiclo Promedio: " + this.cicloPromedio +
                    "\nDuracion Periodo: " + this.duracionPeriodoPromedio +
                    "\nUsa Anticonceptivo: " + this.usaAnticonceptivo +
                    "\nTipo Anticonceptivo: " + this.tipoAnticonceptivo + "\n");
        } else {
            System.out.println("Perfil con id " + idPerfil + " no encontrado.");
        }
    }

    public void getAllPerfiles(List<PerfilMenstrual> perfiles) {
        if (perfiles == null || perfiles.isEmpty()) {
            System.out.println("No hay perfiles registrados.");
            return;
        }
        perfiles.forEach(p -> System.out.println("[" + p.idPerfil + "] Edad: " + p.edad + " | Ciclo: " + p.cicloPromedio + " dias"));
    }

    public void deletePerfil(int idPerfil) {
        System.out.println("Perfil con id " + idPerfil + " eliminado.");
    }

}