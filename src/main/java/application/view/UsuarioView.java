package application.view;

import application.domain.Usuario;
import application.service.UsuarioServiceImplementation;

public class UsuarioView {

    private final UsuarioServiceImplementation usuarioServiceImplementation;

    private final Usuario usuario;

    public UsuarioView(UsuarioServiceImplementation usuarioServiceImplementation, Usuario usuario) {
        this.usuarioServiceImplementation = usuarioServiceImplementation;
        this.usuario = usuario;
    }

    public void createUsuario(){

        usuarioServiceImplementation.createUsuario(usuario);

    }

}