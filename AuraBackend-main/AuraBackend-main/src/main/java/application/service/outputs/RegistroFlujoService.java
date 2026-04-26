package application.service.outputs;

import application.domain.RegistroFlujo;

import java.util.List;

public interface RegistroFlujoService {

    RegistroFlujo createRegistroFlujo(RegistroFlujo flujo);

    RegistroFlujo updateRegistroFlujo(RegistroFlujo flujo);

    void getRegistroFlujoById(int id, RegistroFlujo flujo);

    void getAllRegistrosFlujo(List<RegistroFlujo> flujos, RegistroFlujo flujo);

    void deleteRegistroFlujo(int id);

}
