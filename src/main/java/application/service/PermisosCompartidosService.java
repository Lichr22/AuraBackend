package application.service;

import application.domain.PermisosCompartidos;

import java.util.List;

public interface PermisosCompartidosService {

    PermisosCompartidos createPermiso(PermisosCompartidos permiso);

    PermisosCompartidos updatePermiso(PermisosCompartidos permiso);

    void deletePermiso(Long id);

    List<PermisosCompartidos> getPermisoById(Long id);

}
