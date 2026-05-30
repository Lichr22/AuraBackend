package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.VinculoPareja;
import application.VinculoParejaServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class VinculoParejaView {

    private final VinculoParejaServiceImplementation service;
    private final VinculoPareja vinculoPareja;

    public VinculoParejaView(VinculoParejaServiceImplementation service, VinculoPareja vinculoPareja) {
        this.service = service;
        this.vinculoPareja = vinculoPareja;
    }

    public void createVinculo() {
        try {
            service.createVinculo(vinculoPareja);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateVinculo() {
        try {
            service.updateVinculo(vinculoPareja);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
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
