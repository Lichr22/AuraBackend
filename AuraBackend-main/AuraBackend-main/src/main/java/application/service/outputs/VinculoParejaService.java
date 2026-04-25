package application.service.outputs;

import application.domain.VinculoPareja;

import java.util.List;

public interface VinculoParejaService {

    VinculoPareja createVinculo(VinculoPareja vinculo);

    VinculoPareja updateVinculo(VinculoPareja vinculo);

    void deleteVinculo(Long id);

    List<VinculoPareja> getVinculoById(Long id);

}
