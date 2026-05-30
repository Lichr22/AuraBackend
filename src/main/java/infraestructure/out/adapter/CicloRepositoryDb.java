package infraestructure.out.adapter;

import application.ports.CicloRepositoryPort;
import domain.Ciclo;
import infraestructure.out.dao.CicloDao;
import infraestructure.out.dao.impl.CicloDaoImpl;

import java.util.List;
import java.util.Optional;

public class CicloRepositoryDb implements CicloRepositoryPort {

    private final CicloDao dao = new CicloDaoImpl();

    @Override
    public Ciclo saveCiclo(Ciclo c) {
        return dao.save(c);
    }

    @Override
    public Ciclo updateCiclo(int id, Ciclo c) {
        return dao.update(id, c);
    }

    @Override
    public Optional<Ciclo> findCicloById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Ciclo> findAllCiclos() {
        return dao.findAll();
    }

    @Override
    public void deleteCicloById(int id) {
        dao.deleteById(id);
    }
}
