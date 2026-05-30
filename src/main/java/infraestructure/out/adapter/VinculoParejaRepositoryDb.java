package infraestructure.out.adapter;

import application.ports.VinculoParejaRepositoryPort;
import domain.VinculoPareja;
import infraestructure.out.dao.VinculoParejaDao;
import infraestructure.out.dao.impl.VinculoParejaDaoImpl;

import java.util.List;
import java.util.Optional;

public class VinculoParejaRepositoryDb implements VinculoParejaRepositoryPort {

    private final VinculoParejaDao dao = new VinculoParejaDaoImpl();

    @Override
    public VinculoPareja saveVinculo(VinculoPareja v) {
        return dao.save(v);
    }

    @Override
    public VinculoPareja updateVinculo(Long id, VinculoPareja v) {
        return dao.update(id, v);
    }

    @Override
    public Optional<VinculoPareja> findVinculoById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<VinculoPareja> findAllVinculos() {
        return dao.findAll();
    }

    @Override
    public void deleteVinculoById(Long id) {
        dao.deleteById(id);
    }
}
