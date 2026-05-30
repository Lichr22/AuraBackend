package infraestructure.out.mapper;

import domain.Usuario;

import java.util.List;
import java.util.Scanner;

public class PermisosCompartidosRepositoryMapper {

    Scanner sc = new Scanner(System.in);

    private Long idPermiso;
    private Usuario usuarioPropietario;
    private Usuario usuarioInvitado;
    private String nivelAcceso;
    private String estado;

    public PermisosCompartidosRepositoryMapper() {}

    public PermisosCompartidosRepositoryMapper(Long idPermiso, Usuario usuarioPropietario, Usuario usuarioInvitado, String nivelAcceso, String estado) {
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

    public PermisosCompartidosRepositoryMapper createPermiso(PermisosCompartidosRepositoryMapper permiso) {
        System.out.println("Ingrese el nivel de acceso del permiso");
        permiso.nivelAcceso = sc.nextLine();

        System.out.println("Ingrese el estado del permiso");
        permiso.estado = sc.nextLine();

        return permiso;
    }

    public PermisosCompartidosRepositoryMapper updatePermiso(PermisosCompartidosRepositoryMapper permiso) {
        System.out.println("Actualizar nivel de acceso");
        permiso.nivelAcceso = sc.nextLine();

        System.out.println("Actualizar estado");
        permiso.estado = sc.nextLine();

        return permiso;
    }

    public List<PermisosCompartidosRepositoryMapper> getAllPermisos() {
        return null;
    }

    public void getPermisoById(int idPermiso, PermisosCompartidosRepositoryMapper permiso) {
        if (this.idPermiso.equals(idPermiso)) {
            System.out.println("Id Permiso: " + permiso.idPermiso +
                    "\nPropietario: " + permiso.usuarioPropietario.getNombre() +
                    "\nInvitado: " + permiso.usuarioInvitado.getNombre() +
                    "\nNivel Acceso: " + permiso.nivelAcceso +
                    "\nEstado: " + permiso.estado + "\n");
        }
    }

    public void deletePermiso(Long idPermiso) {}
}
