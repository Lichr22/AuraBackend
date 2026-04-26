package application.view;

import application.domain.RegistroDiario;
import application.service.RegistroDiarioServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class RegistroDiarioView {

    private final RegistroDiarioServiceImplementation service;
    private final RegistroDiario registroDiario;

    public RegistroDiarioView(RegistroDiarioServiceImplementation service, RegistroDiario registroDiario) {
        this.service = service;
        this.registroDiario = registroDiario;
    }

    public void createRegistro() {
        service.createRegistro(registroDiario);
    }

    public void updateRegistro() {
        service.updateRegistro(registroDiario);
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
