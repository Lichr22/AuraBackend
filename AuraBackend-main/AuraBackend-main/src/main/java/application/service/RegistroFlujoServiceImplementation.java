package application.service;

import application.domain.RegistroFlujo;

import java.util.List;

public class RegistroFlujoServiceImplementation implements RegistroFlujoService {

    @Override
    public RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) {
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
