package infraestructure.out.adapter;

import application.ports.UsuarioRepositoryPort;
import domain.Usuario;
import infraestructure.out.dao.UsuarioDao;
import infraestructure.out.dao.impl.UsuarioDaoImpl;

import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryDB implements UsuarioRepositoryPort {

    private final UsuarioDao dao = new UsuarioDaoImpl();

    @Override
    public Usuario saveUsuario(Usuario u) {
        return dao.save(u);
    }

    @Override
    public Usuario updateUsuario(int id, Usuario u) {
        return dao.update(id, u);
    }

    @Override
    public Optional<Usuario> findUsuarioById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return dao.findAll();
    }

    @Override
    public void deleteUsuarioById(int id) {
        dao.deleteById(id);
    }
}
