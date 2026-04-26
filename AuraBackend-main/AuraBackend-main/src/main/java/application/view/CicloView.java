package application.view;

import application.domain.Ciclo;
import application.service.CicloServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class CicloView {

    private final CicloServiceImplementation service;
    private final Ciclo ciclo;

    public CicloView(CicloServiceImplementation service, Ciclo ciclo) {
        this.service = service;
        this.ciclo = ciclo;
    }

    public void createCiclo() {
        service.createCiclo(ciclo);
    }

    public void updateCiclo() {
        service.updateCiclo(ciclo);
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
