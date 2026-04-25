package application.service.port;

import application.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {

    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(int id, Usuario usuario);
    Optional<Usuario> findUsuarioById(int id);
    List<Usuario> findAllUsuarios();
    void deleteUsuarioById(int id);
}