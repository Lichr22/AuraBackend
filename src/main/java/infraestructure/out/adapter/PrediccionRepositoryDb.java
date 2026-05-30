package infraestructure.out.adapter;

import application.ports.PrediccionRepositoryPort;
import domain.Prediccion;
import infraestructure.out.dao.PrediccionDao;
import infraestructure.out.dao.impl.PrediccionDaoImpl;

import java.util.List;
import java.util.Optional;

public class PrediccionRepositoryDb implements PrediccionRepositoryPort {

    private final PrediccionDao dao = new PrediccionDaoImpl();

    @Override
    public Prediccion savePrediccion(Prediccion p) {
        return dao.save(p);
    }

    @Override
    public Prediccion updatePrediccion(int id, Prediccion p) {
        return dao.update(id, p);
    }

    @Override
    public Optional<Prediccion> findPrediccionById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Prediccion> findAllPredicciones() {
        return dao.findAll();
    }

    @Override
    public void deletePrediccionById(int id) {
        dao.deleteById(id);
    }
}
