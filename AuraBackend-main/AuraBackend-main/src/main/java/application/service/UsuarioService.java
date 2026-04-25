package application.service;

import application.domain.Usuario;
import application.view.UsuarioView;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);

    public void deleteUsuario(int id);

    public List<Usuario> getUsuarioById(int id);

}
