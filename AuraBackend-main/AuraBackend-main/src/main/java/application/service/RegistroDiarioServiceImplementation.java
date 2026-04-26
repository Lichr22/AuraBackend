package application.service;

import application.domain.RegistroDiario;
import application.service.outputs.RegistroDiarioService;

import java.util.List;

public class RegistroDiarioServiceImplementation implements RegistroDiarioService {

    @Override
    public RegistroDiario createRegistro(RegistroDiario registro) {
        return registro.createRegistro(registro);
    }

    @Override
    public RegistroDiario updateRegistro(RegistroDiario registro) {
        return registro.updateRegistro(registro);
    }

    @Override
    public void getRegistroById(int id, RegistroDiario registro) {
        registro.getRegistroById(id);
    }

    @Override
    public void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro) {
        registro.getAllRegistros(registros);
    }

    @Override
    public void deleteRegistro(int id) {
        new RegistroDiario().deleteRegistro(id);
    }

}
