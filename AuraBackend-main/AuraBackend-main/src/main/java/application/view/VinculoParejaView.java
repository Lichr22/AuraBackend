package application.view;

import application.domain.VinculoPareja;
import application.service.VinculoParejaServiceImplementation;

public class VinculoParejaView {

    private final VinculoParejaServiceImplementation vinculoParejaServiceImplementation;
    private final VinculoPareja vinculoPareja;

    public VinculoParejaView(VinculoParejaServiceImplementation vinculoParejaServiceImplementation, VinculoPareja vinculoPareja) {
        this.vinculoParejaServiceImplementation = vinculoParejaServiceImplementation;
        this.vinculoPareja = vinculoPareja;
    }

    public void createVinculo() {
        vinculoParejaServiceImplementation.createVinculo(vinculoPareja);
    }

    public void updateVinculo() {
        vinculoParejaServiceImplementation.updateVinculo(vinculoPareja);
    }

}
