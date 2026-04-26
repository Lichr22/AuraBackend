package application.view;

import application.domain.ActividadSexual;
import application.service.ActividadSexualServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class ActividadSexualView {

    private final ActividadSexualServiceImplementation service;
    private final ActividadSexual actividadSexual;

    public ActividadSexualView(ActividadSexualServiceImplementation service, ActividadSexual actividadSexual) {
        this.service = service;
        this.actividadSexual = actividadSexual;
    }

    public void createActividadSexual() {
        service.createActividadSexual(actividadSexual);
    }

    public void updateActividadSexual() {
        service.updateActividadSexual(actividadSexual);
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
