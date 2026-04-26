package application.service;

import application.domain.RegistroFlujo;
import application.service.outputs.RegistroFlujoService;

import java.util.List;

public class RegistroFlujoServiceImplementation implements RegistroFlujoService {

    @Override
    public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) {
        return RegistroFlujo.createRegistroFlujo(flujo);
    }

    @Override
    public RegistroFlujo updateRegistroFlujo(RegistroFlujo flujo) {
        return flujo.updateRegistroFlujo(flujo);
    }

    @Override
    public void getRegistroFlujoById(int id, RegistroFlujo flujo) {
        flujo.getRegistroFlujoById(id);
    }

    @Override
    public void getAllRegistrosFlujo(List<RegistroFlujo> flujos, RegistroFlujo flujo) {
        flujo.getAllRegistrosFlujo(flujos);
    }

    @Override
    public void deleteRegistroFlujo(int id) {
        new RegistroFlujo().deleteRegistroFlujo(id);
    }

}
