package application.view;

import application.domain.RegistroFlujo;
import application.service.RegistroFlujoServiceImplementation;

public class RegistroFlujoView {

    private final RegistroFlujoServiceImplementation registroFlujoServiceImplementation;
    private final RegistroFlujo registroFlujo;

    public RegistroFlujoView(RegistroFlujoServiceImplementation registroFlujoServiceImplementation, RegistroFlujo registroFlujo) {
        this.registroFlujoServiceImplementation = registroFlujoServiceImplementation;
        this.registroFlujo = registroFlujo;
    }

    public void createRegistroFlujo() {
        registroFlujoServiceImplementation.createRegistroFlujo(registroFlujo);
    }

}
