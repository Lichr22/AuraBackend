package application.inputs;

import application.exceptions.ValidacionException;
import domain.RegistroFlujo;

import java.util.List;

public interface RegistroFlujoService {

    RegistroFlujo createRegistroFlujo(RegistroFlujo flujo) throws ValidacionException;

    RegistroFlujo updateRegistroFlujo(RegistroFlujo flujo) throws ValidacionException;

    void getRegistroFlujoById(int id, RegistroFlujo flujo);

    void getAllRegistrosFlujo(List<RegistroFlujo> flujos, RegistroFlujo flujo);

    void deleteRegistroFlujo(int id);

}
