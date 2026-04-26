package application.view;

import application.domain.PermisosCompartidos;
import application.service.PermisosCompartidosServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class PermisosCompartidosView {

    private final PermisosCompartidosServiceImplementation service;
    private final PermisosCompartidos permisosCompartidos;

    public PermisosCompartidosView(PermisosCompartidosServiceImplementation service, PermisosCompartidos permisosCompartidos) {
        this.service = service;
        this.permisosCompartidos = permisosCompartidos;
    }

    public void createPermiso() {
        service.createPermiso(permisosCompartidos);
    }

    public void updatePermiso() {
        service.updatePermiso(permisosCompartidos);
    }

    public void getPermisoById() {
        long id = FormValidationUtil.validateInt("Ingrese el id del permiso a consultar:");
        service.getPermisoById(id, permisosCompartidos);
    }

    public void getAllPermisos() {
        service.getAllPermisos(new ArrayList<>(), permisosCompartidos);
    }

    public void deletePermiso() {
        long id = FormValidationUtil.validateInt("Ingrese el id del permiso a eliminar:");
        service.deletePermiso(id);
    }

}
