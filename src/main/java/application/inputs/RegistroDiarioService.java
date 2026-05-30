package application.inputs;

import domain.RegistroDiario;

import java.util.List;

public interface RegistroDiarioService {

    RegistroDiario createRegistro(RegistroDiario registro);

    RegistroDiario updateRegistro(RegistroDiario registro);

    void getRegistroById(int id, RegistroDiario registro);

    void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro);

    void deleteRegistro(int id);

}
