package application.view;

import application.domain.RegistroDiario;
import application.service.RegistroDiarioServiceImplementation;

public class RegistroDiarioView {

    private final RegistroDiarioServiceImplementation registroDiarioServiceImplementation;
    private final RegistroDiario registroDiario;

    public RegistroDiarioView(RegistroDiarioServiceImplementation registroDiarioServiceImplementation, RegistroDiario registroDiario) {
        this.registroDiarioServiceImplementation = registroDiarioServiceImplementation;
        this.registroDiario = registroDiario;
    }

    public void createRegistro() {
        registroDiarioServiceImplementation.createRegistro(registroDiario);
    }

}
