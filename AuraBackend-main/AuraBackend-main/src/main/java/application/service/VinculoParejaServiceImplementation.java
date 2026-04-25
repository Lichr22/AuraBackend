package application.service;

import application.domain.VinculoPareja;
import application.service.outputs.VinculoParejaService;

import java.util.List;

public class VinculoParejaServiceImplementation implements VinculoParejaService {

    @Override
    public VinculoPareja createVinculo(VinculoPareja vinculo) {
        vinculo.createVinculo(vinculo);
        return vinculo;
    }

    @Override
    public VinculoPareja updateVinculo(VinculoPareja vinculo) {
        return vinculo;
    }

    @Override
    public void deleteVinculo(Long id) {
    }

    @Override
    public List<VinculoPareja> getVinculoById(Long id) {
        return List.of();
    }

}
