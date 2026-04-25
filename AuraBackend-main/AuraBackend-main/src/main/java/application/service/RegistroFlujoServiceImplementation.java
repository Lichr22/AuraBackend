package application.service;

import application.domain.RegistroFlujo;
import application.service.outputs.RegistroFlujoService;

import java.util.List;

public class RegistroFlujoServiceImplementation implements RegistroFlujoService {

    @Override
    public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) {
        flujo.createRegistroFlujo(flujo);
        return flujo;
    }

    @Override
    public void deleteRegistroFlujo(int id) {
    }

    @Override
    public List<RegistroFlujo> getRegistroFlujoById(int id) {
        return List.of();
    }

}
