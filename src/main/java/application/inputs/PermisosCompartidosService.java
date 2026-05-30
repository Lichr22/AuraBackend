package application.inputs;

import application.exceptions.ValidacionException;
import domain.PermisosCompartidos;

import java.util.List;

public interface PermisosCompartidosService {

    PermisosCompartidos createPermiso(PermisosCompartidos permiso) throws ValidacionException;

    PermisosCompartidos updatePermiso(PermisosCompartidos permiso) throws ValidacionException;

    void getPermisoById(Long id, PermisosCompartidos permiso);

    void getAllPermisos(List<PermisosCompartidos> permisos, PermisosCompartidos permiso);

    void deletePermiso(Long id);

}
