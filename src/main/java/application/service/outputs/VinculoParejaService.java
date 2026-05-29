package application.service.outputs;

import application.domain.VinculoPareja;

import java.util.List;

public interface VinculoParejaService {

    VinculoPareja createVinculo(VinculoPareja vinculo);

    VinculoPareja updateVinculo(VinculoPareja vinculo);

    void getVinculoById(Long id, VinculoPareja vinculo);

    void getAllVinculos(List<VinculoPareja> vinculos, VinculoPareja vinculo);

    void deleteVinculo(Long id);

}
