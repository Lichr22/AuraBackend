package application.domain;

import application.util.FormValidationUtil;

import java.util.List;

public class PermisosCompartidos {

    private Long idPermiso;
    private Usuario usuarioPropietario;
    private Usuario usuarioInvitado;
    private String nivelAcceso;
    private String estado;

    public PermisosCompartidos() {}

    public PermisosCompartidos(Long idPermiso, Usuario usuarioPropietario, Usuario usuarioInvitado, String nivelAcceso, String estado) {
        this.idPermiso = idPermiso;
        this.usuarioPropietario = usuarioPropietario;
        this.usuarioInvitado = usuarioInvitado;
        this.nivelAcceso = nivelAcceso;
        this.estado = estado;
    }

    public Long getIdPermiso() { return idPermiso; }
    public void setIdPermiso(Long idPermiso) { this.idPermiso = idPermiso; }

    public Usuario getUsuarioPropietario() { return usuarioPropietario; }
    public void setUsuarioPropietario(Usuario usuarioPropietario) { this.usuarioPropietario = usuarioPropietario; }

    public Usuario getUsuarioInvitado() { return usuarioInvitado; }
    public void setUsuarioInvitado(Usuario usuarioInvitado) { this.usuarioInvitado = usuarioInvitado; }

    public String getNivelAcceso() { return nivelAcceso; }
    public void setNivelAcceso(String nivelAcceso) { this.nivelAcceso = nivelAcceso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public PermisosCompartidos createPermiso(PermisosCompartidos permiso) {
        try {
            permiso.nivelAcceso = FormValidationUtil.validateString("Ingrese el nivel de acceso del permiso:");
            permiso.estado = FormValidationUtil.validateString("Ingrese el estado del permiso:");
            System.out.println("Permiso creado exitosamente.");
            return permiso;
        } catch (Exception e) {
            System.out.println("Error al registrar el permiso: " + e.getMessage());
            return null;
        }
    }

    public PermisosCompartidos updatePermiso(PermisosCompartidos permiso) {
        try {
            permiso.nivelAcceso = FormValidationUtil.validateString("Ingrese el nuevo nivel de acceso:");
            permiso.estado = FormValidationUtil.validateString("Ingrese el nuevo estado:");
            System.out.println("Permiso actualizado exitosamente.");
            return permiso;
        } catch (Exception e) {
            System.out.println("Error al actualizar el permiso: " + e.getMessage());
            return null;
        }
    }

    public void getPermisoById(Long id) {
        if (this.idPermiso != null && this.idPermiso.equals(id)) {
            System.out.println("Id Permiso: " + this.idPermiso +
                    "\nNivel Acceso: " + this.nivelAcceso +
                    "\nEstado: " + this.estado + "\n");
        } else {
            System.out.println("Permiso con id " + id + " no encontrado.");
        }
    }

    public void getAllPermisos(List<PermisosCompartidos> permisos) {
        if (permisos == null || permisos.isEmpty()) {
            System.out.println("No hay permisos registrados.");
            return;
        }
        permisos.forEach(p -> System.out.println("[" + p.idPermiso + "] Nivel: " + p.nivelAcceso + " | Estado: " + p.estado));
    }

    public void deletePermiso(Long id) {
        System.out.println("Permiso con id " + id + " eliminado.");
    }

}
