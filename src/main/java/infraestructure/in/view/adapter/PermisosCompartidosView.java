package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.PermisosCompartidos;
import application.PermisosCompartidosServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class PermisosCompartidosView {

    private final PermisosCompartidosServiceImplementation service;
    private final PermisosCompartidos permisosCompartidos;

    public PermisosCompartidosView(PermisosCompartidosServiceImplementation service, PermisosCompartidos permisosCompartidos) {
        this.service = service;
        this.permisosCompartidos = permisosCompartidos;
    }

    public void createPermiso() {
        try {
            service.createPermiso(permisosCompartidos);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updatePermiso() {
        try {
            service.updatePermiso(permisosCompartidos);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
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
