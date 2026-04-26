package application.service;

import application.domain.PermisosCompartidos;
import application.service.outputs.PermisosCompartidosService;

import java.util.List;

public class PermisosCompartidosServiceImplementation implements PermisosCompartidosService {

    @Override
    public PermisosCompartidos createPermiso(PermisosCompartidos permiso) {
        return permiso.createPermiso(permiso);
    }

    @Override
    public PermisosCompartidos updatePermiso(PermisosCompartidos permiso) {
        return permiso.updatePermiso(permiso);
    }

    @Override
    public void getPermisoById(Long id, PermisosCompartidos permiso) {
        permiso.getPermisoById(id);
    }

    @Override
    public void getAllPermisos(List<PermisosCompartidos> permisos, PermisosCompartidos permiso) {
        permiso.getAllPermisos(permisos);
    }

    @Override
    public void deletePermiso(Long id) {
        new PermisosCompartidos().deletePermiso(id);
    }

}
