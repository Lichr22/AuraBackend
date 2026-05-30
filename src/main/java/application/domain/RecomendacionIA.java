package application.domain;

import application.util.FormValidationUtil;

import java.time.LocalDateTime;
import java.util.List;

public class RecomendacionIA {

    Long idRecomendacion;
    Usuario usuario;
    String titulo;
    String contenido;
    LocalDateTime fechaCreacion;

    public RecomendacionIA() {;
    }

    public RecomendacionIA(Long idRecomendacion, Usuario usuario, String titulo, String contenido, LocalDateTime fechaCreacion) {
        this.idRecomendacion = idRecomendacion;
        this.usuario = usuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(Long idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public RecomendacionIA createRecomendacion(RecomendacionIA recomendacion) {
        try {
            recomendacion.titulo = FormValidationUtil.validateString("Ingrese el título de la recomendación:");
            recomendacion.contenido = FormValidationUtil.validateString("Ingrese el contenido de la recomendación:");
            recomendacion.fechaCreacion = LocalDateTime.now();
            System.out.println("Recomendación creada exitosamente.");
            return recomendacion;
        } catch (Exception e) {
            System.out.println("Error al registrar la recomendación: " + e.getMessage());
            return null;
        }
    }

    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) {
        try {
            recomendacion.titulo = FormValidationUtil.validateString("Ingrese el nuevo título:");
            recomendacion.contenido = FormValidationUtil.validateString("Ingrese el nuevo contenido:");
            System.out.println("Recomendación actualizada exitosamente.");
            return recomendacion;
        } catch (Exception e) {
            System.out.println("Error al actualizar la recomendación: " + e.getMessage());
            return null;
        }
    }

    public void getRecomendacionById(Long id) {
        if (this.idRecomendacion != null && this.idRecomendacion.equals(id)) {
            System.out.println("Id Recomendacion: " + this.idRecomendacion +
                    "\nTitulo: " + this.titulo +
                    "\nContenido: " + this.contenido +
                    "\nFecha Creacion: " + this.fechaCreacion + "\n");
        } else {
            System.out.println("Recomendación con id " + id + " no encontrada.");
        }
    }

    public void getAllRecomendaciones(List<RecomendacionIA> recomendaciones) {
        if (recomendaciones == null || recomendaciones.isEmpty()) {
            System.out.println("No hay recomendaciones registradas.");
            return;
        }
        recomendaciones.forEach(r -> System.out.println("[" + r.idRecomendacion + "] " + r.titulo + " - " + r.fechaCreacion));
    }

    public void deleteRecomendacion(Long id) {
        System.out.println("Recomendación con id " + id + " eliminada.");
    }

}
