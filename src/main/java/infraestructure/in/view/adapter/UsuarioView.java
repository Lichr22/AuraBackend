package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.Usuario;
import application.UsuarioServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class UsuarioView {

    private final UsuarioServiceImplementation service;
    private final Usuario usuario;

    public UsuarioView(UsuarioServiceImplementation service, Usuario usuario) {
        this.service = service;
        this.usuario = usuario;
    }

    public void createUsuario() {
        try {
            service.createUsuario(usuario);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateUsuario() {
        try {
            service.updateUsuario(usuario);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getUsuarioById() {
        int id = FormValidationUtil.validateInt("Ingrese el id del usuario a consultar:");
        service.getUsuarioById(id, usuario);
    }

    public void getAllUsuarios() {
        service.getAllUsuarios(new ArrayList<>(), usuario);
    }

    public void deleteUsuario() {
        int id = FormValidationUtil.validateInt("Ingrese el id del usuario a eliminar:");
        service.deleteUsuario(id);
    }

}
