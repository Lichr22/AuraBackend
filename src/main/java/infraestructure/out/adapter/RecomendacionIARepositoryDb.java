package infraestructure.out.adapter;

import application.ports.RecomendacionIARepositoryPort;
import domain.RecomendacionIA;
import infraestructure.out.dao.RecomendacionIADao;
import infraestructure.out.dao.impl.RecomendacionIADaoImpl;

import java.util.List;
import java.util.Optional;

public class RecomendacionIARepositoryDb implements RecomendacionIARepositoryPort {

    private final RecomendacionIADao dao = new RecomendacionIADaoImpl();

    @Override
    public RecomendacionIA saveRecomendacion(RecomendacionIA r) {
        return dao.save(r);
    }

    @Override
    public RecomendacionIA updateRecomendacion(Long id, RecomendacionIA r) {
        return dao.update(id, r);
    }

    @Override
    public Optional<RecomendacionIA> findRecomendacionById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<RecomendacionIA> findAllRecomendaciones() {
        return dao.findAll();
    }

    @Override
    public void deleteRecomendacionById(Long id) {
        dao.deleteById(id);
    }
}
