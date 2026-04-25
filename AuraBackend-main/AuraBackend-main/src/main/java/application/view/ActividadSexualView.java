package application.view;

import application.domain.ActividadSexual;
import application.service.ActividadSexualServiceImplementation;

public class ActividadSexualView {

    private final ActividadSexualServiceImplementation actividadSexualServiceImplementation;
    private final ActividadSexual actividadSexual;

    public ActividadSexualView(ActividadSexualServiceImplementation actividadSexualServiceImplementation, ActividadSexual actividadSexual) {
        this.actividadSexualServiceImplementation = actividadSexualServiceImplementation;
        this.actividadSexual = actividadSexual;
    }

    public void createActividadSexual() {
        actividadSexualServiceImplementation.createActividadSexual(actividadSexual);
    }

}
