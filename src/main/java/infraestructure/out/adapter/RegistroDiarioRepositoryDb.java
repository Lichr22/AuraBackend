package infraestructure.out.adapter;

import application.ports.RegistroDiarioRepositoryPort;
import domain.RegistroDiario;
import infraestructure.out.dao.RegistroDiarioDao;
import infraestructure.out.dao.impl.RegistroDiarioDaoImpl;

import java.util.List;
import java.util.Optional;

public class RegistroDiarioRepositoryDb implements RegistroDiarioRepositoryPort {

    private final RegistroDiarioDao dao = new RegistroDiarioDaoImpl();

    @Override
    public RegistroDiario saveRegistroDiario(RegistroDiario r) {
        return dao.save(r);
    }

    @Override
    public RegistroDiario updateRegistroDiario(int id, RegistroDiario r) {
        return dao.update(id, r);
    }

    @Override
    public Optional<RegistroDiario> findRegistroDiarioById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<RegistroDiario> findAllRegistrosDiarios() {
        return dao.findAll();
    }

    @Override
    public void deleteRegistroDiarioById(int id) {
        dao.deleteById(id);
    }
}
