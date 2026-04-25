package application.service;

import application.domain.Usuario;
import application.service.outputs.UsuarioService;

import java.util.List;

public class UsuarioServiceImplementation implements UsuarioService {

    @Override
    public Usuario createUsuario(Usuario usuario){
        usuario.createUser(usuario);
        return usuario;
    }

    @Override
    public void deleteUsuario(int id) {

    }

    @Override
    public List<Usuario> getUsuarioById(int id) {
        return List.of();
    }

}
