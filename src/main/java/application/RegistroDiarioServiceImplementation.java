package application;

import application.inputs.RegistroDiarioService;
import application.ports.RegistroDiarioRepositoryPort;
import domain.RegistroDiario;

import java.util.List;

public class RegistroDiarioServiceImplementation implements RegistroDiarioService {

    private final RegistroDiarioRepositoryPort repository;

    public RegistroDiarioServiceImplementation(RegistroDiarioRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public RegistroDiario createRegistro(RegistroDiario registro) {
        RegistroDiario filled = registro.createRegistro(registro);
        return filled != null ? repository.saveRegistroDiario(filled) : null;
    }

    @Override
    public RegistroDiario updateRegistro(RegistroDiario registro) {
        RegistroDiario filled = registro.updateRegistro(registro);
        return filled != null ? repository.updateRegistroDiario(filled.getIdRegistro(), filled) : null;
    }

    @Override
    public void getRegistroById(int id, RegistroDiario registro) {
        repository.findRegistroDiarioById(id)
                .ifPresentOrElse(
                        r -> System.out.println("Id: " + r.getIdRegistro() + " | Fecha: " + r.getFecha() + " | Temp: " + r.getTemperaturaBasal() + " | Peso: " + r.getPeso()),
                        () -> System.out.println("Registro con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro) {
        List<RegistroDiario> result = repository.findAllRegistrosDiarios();
        if (result.isEmpty()) {
            System.out.println("No hay registros diarios registrados.");
        } else {
            result.forEach(r -> System.out.println("[" + r.getIdRegistro() + "] " + r.getFecha() + " | Temp: " + r.getTemperaturaBasal() + " | Peso: " + r.getPeso()));
        }
    }

    @Override
    public void deleteRegistro(int id) {
        repository.deleteRegistroDiarioById(id);
        System.out.println("Registro con id " + id + " eliminado.");
    }
}
