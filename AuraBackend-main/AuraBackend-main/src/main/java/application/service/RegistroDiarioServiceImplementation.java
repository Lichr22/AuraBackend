package application.service;

import application.domain.RegistroDiario;
import application.service.outputs.RegistroDiarioService;

import java.util.List;

public class RegistroDiarioServiceImplementation implements RegistroDiarioService {

    @Override
    public RegistroDiario createRegistro(RegistroDiario registro) {
        registro.createRegistro(registro);
        return registro;
    }

    @Override
    public void deleteRegistro(int id) {
    }

    @Override
    public List<RegistroDiario> getRegistroById(int id) {
        return List.of();
    }

}
