package application.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class RecomendacionIA {

    Scanner sc = new Scanner(System.in);

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
        System.out.println("Ingrese el titulo de la recomendacion");
        recomendacion.titulo = sc.nextLine();

        System.out.println("Ingrese el contenido de la recomendacion");
        recomendacion.contenido = sc.nextLine();

        recomendacion.fechaCreacion = LocalDateTime.now();

        return recomendacion;
    }

    public RecomendacionIA updateRecomendacion(RecomendacionIA recomendacion) {
        System.out.println("Actualizar titulo");
        recomendacion.titulo = sc.nextLine();

        System.out.println("Actualizar contenido");
        recomendacion.contenido = sc.nextLine();

        return recomendacion;
    }

    public List<RecomendacionIA> getAllRecomendaciones() {
        return null;
    }

    public void getRecomendacionById(int idRecomendacion, RecomendacionIA recomendacion) {
        if (this.idRecomendacion.equals(idRecomendacion)) {
            System.out.println("Id Recomendacion: " + recomendacion.idRecomendacion +
                    "\nUsuario: " + recomendacion.usuario.getNombre() +
                    "\nTitulo: " + recomendacion.titulo +
                    "\nContenido: " + recomendacion.contenido +
                    "\nFecha Creacion: " + recomendacion.fechaCreacion + "\n");
        }
    }

    public void deleteRecomendacion(int idRecomendacion) {}
}
