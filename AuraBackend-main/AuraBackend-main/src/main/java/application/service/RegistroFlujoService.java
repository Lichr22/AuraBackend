package application.service;

import application.domain.RegistroFlujo;

import java.util.List;

public interface RegistroFlujoService {

    RegistroFlujo createRegistroFlujo(RegistroFlujo flujo);

    void deleteRegistroFlujo(int id);

    List<RegistroFlujo> getRegistroFlujoById(int id);

}
