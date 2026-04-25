package application.service.outputs;

import application.domain.RegistroDiario;

import java.util.List;

public interface RegistroDiarioService {

    RegistroDiario createRegistro(RegistroDiario registro);

    void deleteRegistro(int id);

    List<RegistroDiario> getRegistroById(int id);

}
