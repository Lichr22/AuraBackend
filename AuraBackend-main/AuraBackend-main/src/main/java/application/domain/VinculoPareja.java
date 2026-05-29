package application.domain;

import application.util.FormValidationUtil;

import java.time.LocalDate;
import java.util.List;

public class VinculoPareja {

    Long idVinculoPareja;
    Usuario mujer;
    Usuario pareja;
    String estadoVinculo;
    LocalDate fechaVinculacion;

    public VinculoPareja(Long idVinculoPareja, Usuario mujer, Usuario pareja, String estadoVinculo, LocalDate fechaVinculacion) {
        this.idVinculoPareja = idVinculoPareja;
        this.mujer = mujer;
        this.pareja = pareja;
        this.estadoVinculo = estadoVinculo;
        this.fechaVinculacion = fechaVinculacion;
    }

    public VinculoPareja() {
    }

    public Long getIdVinculoPareja() {
        return idVinculoPareja;
    }

    public void setIdVinculoPareja(Long idVinculoPareja) {
        this.idVinculoPareja = idVinculoPareja;
    }

    public Usuario getMujer() {
        return mujer;
    }

    public void setMujer(Usuario mujer) {
        this.mujer = mujer;
    }

    public Usuario getPareja() {
        return pareja;
    }

    public void setPareja(Usuario pareja) {
        this.pareja = pareja;
    }

    public String getEstadoVinculo() {
        return estadoVinculo;
    }

    public void setEstadoVinculo(String estadoVinculo) {
        this.estadoVinculo = estadoVinculo;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public VinculoPareja createVinculo(VinculoPareja vinculo) {
        try {
            vinculo.estadoVinculo = FormValidationUtil.validateString("Ingrese el estado del vínculo:");
            vinculo.fechaVinculacion = LocalDate.now();
            System.out.println("Vínculo creado exitosamente.");
            return vinculo;
        } catch (Exception e) {
            System.out.println("Error al registrar el vínculo: " + e.getMessage());
            return null;
        }
    }

    public VinculoPareja updateVinculo(VinculoPareja vinculo) {
        try {
            vinculo.estadoVinculo = FormValidationUtil.validateString("Ingrese el nuevo estado del vínculo:");
            System.out.println("Vínculo actualizado exitosamente.");
            return vinculo;
        } catch (Exception e) {
            System.out.println("Error al actualizar el vínculo: " + e.getMessage());
            return null;
        }
    }

    public void getVinculoById(Long id) {
        if (this.idVinculoPareja != null && this.idVinculoPareja.equals(id)) {
            System.out.println("Id Vinculo: " + this.idVinculoPareja +
                    "\nEstado Vinculo: " + this.estadoVinculo +
                    "\nFecha Vinculacion: " + this.fechaVinculacion + "\n");
        } else {
            System.out.println("Vínculo con id " + id + " no encontrado.");
        }
    }

    public void getAllVinculos(List<VinculoPareja> vinculos) {
        if (vinculos == null || vinculos.isEmpty()) {
            System.out.println("No hay vínculos registrados.");
            return;
        }
        vinculos.forEach(v -> System.out.println("[" + v.idVinculoPareja + "] Estado: " + v.estadoVinculo + " | Fecha: " + v.fechaVinculacion));
    }

    public void deleteVinculo(Long id) {
        System.out.println("Vínculo con id " + id + " eliminado.");
    }

}
