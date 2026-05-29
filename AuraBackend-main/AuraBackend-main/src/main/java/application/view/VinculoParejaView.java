package application.view;

import application.domain.VinculoPareja;
import application.service.VinculoParejaServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class VinculoParejaView {

    private final VinculoParejaServiceImplementation service;
    private final VinculoPareja vinculoPareja;

    public VinculoParejaView(VinculoParejaServiceImplementation service, VinculoPareja vinculoPareja) {
        this.service = service;
        this.vinculoPareja = vinculoPareja;
    }

    public void createVinculo() {
        service.createVinculo(vinculoPareja);
    }

    public void updateVinculo() {
        service.updateVinculo(vinculoPareja);
    }

    public void getVinculoById() {
        long id = FormValidationUtil.validateInt("Ingrese el id del vínculo a consultar:");
        service.getVinculoById(id, vinculoPareja);
    }

    public void getAllVinculos() {
        service.getAllVinculos(new ArrayList<>(), vinculoPareja);
    }

    public void deleteVinculo() {
        long id = FormValidationUtil.validateInt("Ingrese el id del vínculo a eliminar:");
        service.deleteVinculo(id);
    }

}
