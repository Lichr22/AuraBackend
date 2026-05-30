package application.inputs;

import application.exceptions.ValidacionException;
import domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario) throws ValidacionException;

    Usuario updateUsuario(Usuario usuario) throws ValidacionException;

    void getUsuarioById(int id, Usuario usuario);

    void getAllUsuarios(List<Usuario> usuarios, Usuario usuario);

    void deleteUsuario(int id);

}
