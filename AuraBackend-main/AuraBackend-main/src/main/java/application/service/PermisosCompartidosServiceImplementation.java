package application.service;

import application.domain.PermisosCompartidos;

import java.util.List;

public class PermisosCompartidosServiceImplementation implements PermisosCompartidosService {

    @Override
    public PermisosCompartidos createPermiso(PermisosCompartidos permiso) {
        return permiso;
    }

    @Override
    public PermisosCompartidos updatePermiso(PermisosCompartidos permiso) {
        return permiso;
    }

    @Override
    public void deletePermiso(Long id) {
    }

    @Override
    public List<PermisosCompartidos> getPermisoById(Long id) {
        return List.of();
    }

}
