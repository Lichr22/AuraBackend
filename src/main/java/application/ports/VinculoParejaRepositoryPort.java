package application.ports;

import domain.VinculoPareja;

import java.util.List;
import java.util.Optional;

public interface VinculoParejaRepositoryPort {

    VinculoPareja saveVinculo(VinculoPareja vinculo);
    VinculoPareja updateVinculo(Long id, VinculoPareja vinculo);
    Optional<VinculoPareja> findVinculoById(Long id);
    List<VinculoPareja> findAllVinculos();
    void deleteVinculoById(Long id);
}
