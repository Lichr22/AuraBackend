package infraestructure.out.adapter;

import application.ports.RegistroFlujoRepositoryPort;
import domain.RegistroFlujo;
import infraestructure.out.dao.RegistroFlujoDao;
import infraestructure.out.dao.impl.RegistroFlujoDaoImpl;

import java.util.List;
import java.util.Optional;

public class RegistroFlujoRepositoryDb implements RegistroFlujoRepositoryPort {

    private final RegistroFlujoDao dao = new RegistroFlujoDaoImpl();

    @Override
    public RegistroFlujo saveRegistroFlujo(RegistroFlujo f) {
        return dao.save(f);
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(int id, RegistroFlujo f) {
        return dao.update(id, f);
    }

    @Override
    public Optional<RegistroFlujo> findRegistroFlujoById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<RegistroFlujo> findAllRegistrosFlujo() {
        return dao.findAll();
    }

    @Override
    public void deleteRegistroFlujoById(int id) {
        dao.deleteById(id);
    }
}
