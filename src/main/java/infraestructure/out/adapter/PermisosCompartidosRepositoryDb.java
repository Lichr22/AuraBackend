package infraestructure.out.adapter;

import application.ports.PermisosCompartidosRepositoryPort;
import domain.PermisosCompartidos;
import infraestructure.out.dao.PermisosCompartidosDao;
import infraestructure.out.dao.impl.PermisosCompartidosDaoImpl;

import java.util.List;
import java.util.Optional;

public class PermisosCompartidosRepositoryDb implements PermisosCompartidosRepositoryPort {

    private final PermisosCompartidosDao dao = new PermisosCompartidosDaoImpl();

    @Override
    public PermisosCompartidos savePermiso(PermisosCompartidos p) {
        return dao.save(p);
    }

    @Override
    public PermisosCompartidos updatePermiso(Long id, PermisosCompartidos p) {
        return dao.update(id, p);
    }

    @Override
    public Optional<PermisosCompartidos> findPermisoById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<PermisosCompartidos> findAllPermisos() {
        return dao.findAll();
    }

    @Override
    public void deletePermisoById(Long id) {
        dao.deleteById(id);
    }
}
