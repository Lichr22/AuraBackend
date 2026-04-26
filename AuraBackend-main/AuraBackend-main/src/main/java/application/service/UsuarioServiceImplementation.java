package application.service;

import application.domain.Usuario;
import application.service.outputs.UsuarioService;

import java.util.List;

public class UsuarioServiceImplementation implements UsuarioService {

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuario.createUser(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuario.updateUser(usuario);
    }

    @Override
    public void getUsuarioById(int id, Usuario usuario) {
        usuario.getUserById(id);
    }

    @Override
    public void getAllUsuarios(List<Usuario> usuarios, Usuario usuario) {
        usuario.getAllUsers(usuarios);
    }

    @Override
    public void deleteUsuario(int id) {
        new Usuario().deleteUser(id);
    }

}
