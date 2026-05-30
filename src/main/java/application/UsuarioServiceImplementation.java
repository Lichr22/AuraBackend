package application;

import application.inputs.UsuarioService;
import application.ports.UsuarioRepositoryPort;
import domain.Usuario;

import java.util.List;

public class UsuarioServiceImplementation implements UsuarioService {

    private final UsuarioRepositoryPort repository;

    public UsuarioServiceImplementation(UsuarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario filled = usuario.createUser(usuario);
        return filled != null ? repository.saveUsuario(filled) : null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario filled = usuario.updateUser(usuario);
        return filled != null ? repository.updateUsuario(filled.getIdUsuario(), filled) : null;
    }

    @Override
    public void getUsuarioById(int id, Usuario usuario) {
        repository.findUsuarioById(id)
                .ifPresentOrElse(
                        u -> System.out.println("Id: " + u.getIdUsuario() + " | Nombre: " + u.getNombre() + " | Email: " + u.getEmail() + " | Rol: " + u.getRol()),
                        () -> System.out.println("Usuario con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllUsuarios(List<Usuario> usuarios, Usuario usuario) {
        List<Usuario> result = repository.findAllUsuarios();
        if (result.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            result.forEach(u -> System.out.println("[" + u.getIdUsuario() + "] " + u.getNombre() + " - " + u.getEmail() + " - " + u.getRol()));
        }
    }

    @Override
    public void deleteUsuario(int id) {
        repository.deleteUsuarioById(id);
        System.out.println("Usuario con id " + id + " eliminado.");
    }
}
