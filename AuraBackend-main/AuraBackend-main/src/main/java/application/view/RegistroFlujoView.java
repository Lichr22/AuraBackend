package application.view;

import application.domain.RegistroFlujo;
import application.service.RegistroFlujoServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class RegistroFlujoView {

    private final RegistroFlujoServiceImplementation service;
    private final RegistroFlujo registroFlujo;

    public RegistroFlujoView(RegistroFlujoServiceImplementation service, RegistroFlujo registroFlujo) {
        this.service = service;
        this.registroFlujo = registroFlujo;
    }

    public void createRegistroFlujo() {
        service.createRegistroFlujo(registroFlujo);
    }

    public void updateRegistroFlujo() {
        service.updateRegistroFlujo(registroFlujo);
    }

    public void getRegistroFlujoById() {
        int id = FormValidationUtil.validateInt("Ingrese el id del flujo a consultar:");
        service.getRegistroFlujoById(id, registroFlujo);
    }

    public void getAllRegistrosFlujo() {
        service.getAllRegistrosFlujo(new ArrayList<>(), registroFlujo);
    }

    public void deleteRegistroFlujo() {
        int id = FormValidationUtil.validateInt("Ingrese el id del flujo a eliminar:");
        service.deleteRegistroFlujo(id);
    }

}
