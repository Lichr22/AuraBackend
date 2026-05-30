package application.inputs;

import application.exceptions.ValidacionException;
import domain.RegistroDiario;

import java.util.List;

public interface RegistroDiarioService {

    RegistroDiario createRegistro(RegistroDiario registro) throws ValidacionException;

    RegistroDiario updateRegistro(RegistroDiario registro) throws ValidacionException;

    void getRegistroById(int id, RegistroDiario registro);

    void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro);

    void deleteRegistro(int id);

}
