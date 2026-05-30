package infraestructure.out.adapter;

import application.ports.ActividadSexualRepositoryPort;
import domain.ActividadSexual;
import infraestructure.out.dao.ActividadSexualDao;
import infraestructure.out.dao.impl.ActividadSexualDaoImpl;

import java.util.List;
import java.util.Optional;

public class ActividadSexualRepositoryDb implements ActividadSexualRepositoryPort {

    private final ActividadSexualDao dao = new ActividadSexualDaoImpl();

    @Override
    public ActividadSexual saveActividadSexual(ActividadSexual a) {
        return dao.save(a);
    }

    @Override
    public ActividadSexual updateActividadSexual(int id, ActividadSexual a) {
        return dao.update(id, a);
    }

    @Override
    public Optional<ActividadSexual> findActividadSexualById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<ActividadSexual> findAllActividadesSexuales() {
        return dao.findAll();
    }

    @Override
    public void deleteActividadSexualById(int id) {
        dao.deleteById(id);
    }
}
