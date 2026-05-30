package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public Usuario createUsuario(Usuario usuario) throws ValidacionException {
        Usuario filled = usuario.createUser(usuario);
        if (filled == null) throw new ValidacionException("Datos de usuario inválidos.");
        try {
            return repository.saveUsuario(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar usuario.", e);
        }
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) throws ValidacionException {
        Usuario filled = usuario.updateUser(usuario);
        if (filled == null) throw new ValidacionException("Datos de usuario inválidos para actualizar.");
        try {
            return repository.updateUsuario(filled.getIdUsuario(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar usuario.", e);
        }
    }

    @Override
    public void getUsuarioById(int id, Usuario usuario) {
        try {
            Usuario u = repository.findUsuarioById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("Usuario", id));
            System.out.println("Id: " + u.getIdUsuario() + " | Nombre: " + u.getNombre() + " | Email: " + u.getEmail() + " | Rol: " + u.getRol());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar usuario con id " + id, e);
        }
    }

    @Override
    public void getAllUsuarios(List<Usuario> usuarios, Usuario usuario) {
        try {
            List<Usuario> result = repository.findAllUsuarios();
            if (result.isEmpty()) {
                System.out.println("No hay usuarios registrados.");
            } else {
                result.forEach(u -> System.out.println("[" + u.getIdUsuario() + "] " + u.getNombre() + " - " + u.getEmail() + " - " + u.getRol()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener usuarios.", e);
        }
    }

    @Override
    public void deleteUsuario(int id) {
        try {
            repository.deleteUsuarioById(id);
            System.out.println("Usuario con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar usuario con id " + id, e);
        }
    }
}
