package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.RegistroFlujo;
import application.RegistroFlujoServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class RegistroFlujoView {

    private final RegistroFlujoServiceImplementation service;
    private final RegistroFlujo registroFlujo;

    public RegistroFlujoView(RegistroFlujoServiceImplementation service, RegistroFlujo registroFlujo) {
        this.service = service;
        this.registroFlujo = registroFlujo;
    }

    public void createRegistroFlujo() {
        try {
            service.createRegistroFlujo(registroFlujo);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateRegistroFlujo() {
        try {
            service.updateRegistroFlujo(registroFlujo);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
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
