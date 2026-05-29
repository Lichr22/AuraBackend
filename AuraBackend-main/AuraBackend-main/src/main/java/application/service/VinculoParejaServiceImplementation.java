package application.service;

import application.domain.VinculoPareja;
import application.service.outputs.VinculoParejaService;

import java.util.List;

public class VinculoParejaServiceImplementation implements VinculoParejaService {

    @Override
    public VinculoPareja createVinculo(VinculoPareja vinculo) {
        return vinculo.createVinculo(vinculo);
    }

    @Override
    public VinculoPareja updateVinculo(VinculoPareja vinculo) {
        return vinculo.updateVinculo(vinculo);
    }

    @Override
    public void getVinculoById(Long id, VinculoPareja vinculo) {
        vinculo.getVinculoById(id);
    }

    @Override
    public void getAllVinculos(List<VinculoPareja> vinculos, VinculoPareja vinculo) {
        vinculo.getAllVinculos(vinculos);
    }

    @Override
    public void deleteVinculo(Long id) {
        new VinculoPareja().deleteVinculo(id);
    }

}
