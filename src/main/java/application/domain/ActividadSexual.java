package application.domain;

import application.util.FormValidationUtil;

import java.util.List;

public class ActividadSexual {

    private int idActividad;
    private RegistroDiario registroDiario;
    private Boolean usoPreservativo;
    private Boolean orgasmo;
    private String metodoAdicional;

    // CONSTRUCTORES
    //Vacio
    public ActividadSexual() {
    }

    // Constructor con todos los atributos
    public ActividadSexual(int idActividad, RegistroDiario registroDiario, Boolean usoPreservativo, Boolean orgasmo, String metodoAdicional) {
        this.idActividad = idActividad;
        this.registroDiario = registroDiario;
        this.usoPreservativo = usoPreservativo;
        this.orgasmo = orgasmo;
        this.metodoAdicional = metodoAdicional;
    }

    // Constructor con solo ID
    public ActividadSexual(int idActividad) {
        this.idActividad = idActividad;
    }

    // GETTERS Y SETTERS

    public int getIdActividad() { return idActividad; }

    public void setIdActividad(int idActividad) { this.idActividad = idActividad; }

    public RegistroDiario getRegistroDiario() { return registroDiario; }

    public void setRegistroDiario(RegistroDiario registroDiario) { this.registroDiario = registroDiario; }

    public Boolean getUsoPreservativo() { return usoPreservativo; }

    public void setUsoPreservativo(Boolean usoPreservativo) { this.usoPreservativo = usoPreservativo; }

    public Boolean getOrgasmo() { return orgasmo; }

    public void setOrgasmo(Boolean orgasmo) { this.orgasmo = orgasmo; }

    public String getMetodoAdicional() { return metodoAdicional; }

    public void setMetodoAdicional(String metodoAdicional) { this.metodoAdicional = metodoAdicional; }

    // METODOS
    //Create

    public ActividadSexual createActividadSexual(ActividadSexual actividad) {
        try {
            actividad.idActividad = FormValidationUtil.validateInt("Ingrese el id de la actividad sexual:");
            actividad.usoPreservativo = FormValidationUtil.validateBoolean("¿Se usó preservativo? (true/false):");
            actividad.orgasmo = FormValidationUtil.validateBoolean("¿Hubo orgasmo? (true/false):");
            actividad.metodoAdicional = FormValidationUtil.validateString("Ingrese método anticonceptivo adicional:");
            System.out.println("Actividad sexual creada exitosamente.");
            return actividad;
        } catch (Exception e) {
            System.out.println("Error al registrar la actividad sexual: " + e.getMessage());
            return null;
        }
    }

    public ActividadSexual updateActividadSexual(ActividadSexual actividad) {
        try {
            actividad.usoPreservativo = FormValidationUtil.validateBoolean("¿Se usó preservativo? (true/false):");
            actividad.orgasmo = FormValidationUtil.validateBoolean("¿Hubo orgasmo? (true/false):");
            actividad.metodoAdicional = FormValidationUtil.validateString("Ingrese el nuevo método anticonceptivo adicional:");
            System.out.println("Actividad sexual actualizada exitosamente.");
            return actividad;
        } catch (Exception e) {
            System.out.println("Error al actualizar la actividad sexual: " + e.getMessage());
            return null;
        }
    }

    public void getActividadSexualById(int id) {
        if (this.idActividad == id) {
            System.out.println("Id Actividad: " + this.idActividad +
                    "\nUso preservativo: " + this.usoPreservativo +
                    "\nOrgasmo: " + this.orgasmo +
                    "\nMetodo adicional: " + this.metodoAdicional + "\n");
        } else {
            System.out.println("Actividad con id " + id + " no encontrada.");
        }
    }

    public void getAllActividadesSexuales(List<ActividadSexual> actividades) {
        if (actividades == null || actividades.isEmpty()) {
            System.out.println("No hay actividades sexuales registradas.");
            return;
        }
        actividades.forEach(a -> System.out.println("[" + a.idActividad + "] Preservativo: " + a.usoPreservativo + " | Metodo: " + a.metodoAdicional));
    }

    public void deleteActividadSexual(int id) {
        System.out.println("Actividad sexual con id " + id + " eliminada.");
    }

}