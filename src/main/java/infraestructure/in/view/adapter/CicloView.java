package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.Ciclo;
import application.CicloServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class CicloView {

    private final CicloServiceImplementation service;
    private final Ciclo ciclo;

    public CicloView(CicloServiceImplementation service, Ciclo ciclo) {
        this.service = service;
        this.ciclo = ciclo;
    }

    public void createCiclo() {
        try {
            service.createCiclo(ciclo);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateCiclo() {
        try {
            service.updateCiclo(ciclo);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getCicloById() {
        int id = FormValidationUtil.validateInt("Ingrese el id del ciclo a consultar:");
        service.getCicloById(id, ciclo);
    }

    public void getAllCiclos() {
        service.getAllCiclos(new ArrayList<>(), ciclo);
    }

    public void deleteCiclo() {
        int id = FormValidationUtil.validateInt("Ingrese el id del ciclo a eliminar:");
        service.deleteCiclo(id);
    }

}
