package application.service.outputs;

import application.domain.PermisosCompartidos;

import java.util.List;

public interface PermisosCompartidosService {

    PermisosCompartidos createPermiso(PermisosCompartidos permiso);

    PermisosCompartidos updatePermiso(PermisosCompartidos permiso);

    void getPermisoById(Long id, PermisosCompartidos permiso);

    void getAllPermisos(List<PermisosCompartidos> permisos, PermisosCompartidos permiso);

    void deletePermiso(Long id);

}
