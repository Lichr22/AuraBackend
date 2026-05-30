package infraestructure.out.adapter;

import application.ports.PerfilMenstrualRepositoryPort;
import domain.PerfilMenstrual;
import infraestructure.out.dao.PerfilMenstrualDao;
import infraestructure.out.dao.impl.PerfilMenstrualDaoImpl;

import java.util.List;
import java.util.Optional;

public class PerfilMenstrualRepositoryDb implements PerfilMenstrualRepositoryPort {

    private final PerfilMenstrualDao dao = new PerfilMenstrualDaoImpl();

    @Override
    public PerfilMenstrual savePerfilMenstrual(PerfilMenstrual p) {
        return dao.save(p);
    }

    @Override
    public PerfilMenstrual updatePerfilMenstrual(int id, PerfilMenstrual p) {
        return dao.update(id, p);
    }

    @Override
    public Optional<PerfilMenstrual> findPerfilMenstrualById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<PerfilMenstrual> findAllPerfilesMenstruales() {
        return dao.findAll();
    }

    @Override
    public void deletePerfilMenstrualById(int id) {
        dao.deleteById(id);
    }
}
