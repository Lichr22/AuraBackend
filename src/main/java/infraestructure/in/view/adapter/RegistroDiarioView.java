package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.RegistroDiario;
import application.RegistroDiarioServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class RegistroDiarioView {

    private final RegistroDiarioServiceImplementation service;
    private final RegistroDiario registroDiario;

    public RegistroDiarioView(RegistroDiarioServiceImplementation service, RegistroDiario registroDiario) {
        this.service = service;
        this.registroDiario = registroDiario;
    }

    public void createRegistro() {
        try {
            service.createRegistro(registroDiario);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateRegistro() {
        try {
            service.updateRegistro(registroDiario);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getRegistroById() {
        int id = FormValidationUtil.validateInt("Ingrese el id del registro a consultar:");
        service.getRegistroById(id, registroDiario);
    }

    public void getAllRegistros() {
        service.getAllRegistros(new ArrayList<>(), registroDiario);
    }

    public void deleteRegistro() {
        int id = FormValidationUtil.validateInt("Ingrese el id del registro a eliminar:");
        service.deleteRegistro(id);
    }

}
