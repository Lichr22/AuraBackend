package application.inputs;

import application.exceptions.ValidacionException;
import domain.VinculoPareja;

import java.util.List;

public interface VinculoParejaService {

    VinculoPareja createVinculo(VinculoPareja vinculo) throws ValidacionException;

    VinculoPareja updateVinculo(VinculoPareja vinculo) throws ValidacionException;

    void getVinculoById(Long id, VinculoPareja vinculo);

    void getAllVinculos(List<VinculoPareja> vinculos, VinculoPareja vinculo);

    void deleteVinculo(Long id);

}
