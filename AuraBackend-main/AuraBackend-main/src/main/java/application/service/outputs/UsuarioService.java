package application.service.outputs;

import application.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    void getUsuarioById(int id, Usuario usuario);

    void getAllUsuarios(List<Usuario> usuarios, Usuario usuario);

    void deleteUsuario(int id);

}
