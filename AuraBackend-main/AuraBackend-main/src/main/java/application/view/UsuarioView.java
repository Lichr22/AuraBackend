package application.view;

import application.domain.Usuario;
import application.service.UsuarioServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class UsuarioView {

    private final UsuarioServiceImplementation service;
    private final Usuario usuario;

    public UsuarioView(UsuarioServiceImplementation service, Usuario usuario) {
        this.service = service;
        this.usuario = usuario;
    }

    public void createUsuario() {
        service.createUsuario(usuario);
    }

    public void updateUsuario() {
        service.updateUsuario(usuario);
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
