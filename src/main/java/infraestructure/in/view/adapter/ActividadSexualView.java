package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.ActividadSexual;
import application.ActividadSexualServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class ActividadSexualView {

    private final ActividadSexualServiceImplementation service;
    private final ActividadSexual actividadSexual;

    public ActividadSexualView(ActividadSexualServiceImplementation service, ActividadSexual actividadSexual) {
        this.service = service;
        this.actividadSexual = actividadSexual;
    }

    public void createActividadSexual() {
        try {
            service.createActividadSexual(actividadSexual);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateActividadSexual() {
        try {
            service.updateActividadSexual(actividadSexual);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getActividadSexualById() {
        int id = FormValidationUtil.validateInt("Ingrese el id de la actividad a consultar:");
        service.getActividadSexualById(id, actividadSexual);
    }

    public void getAllActividadesSexuales() {
        service.getAllActividadesSexuales(new ArrayList<>(), actividadSexual);
    }

    public void deleteActividadSexual() {
        int id = FormValidationUtil.validateInt("Ingrese el id de la actividad a eliminar:");
        service.deleteActividadSexual(id);
    }

}
