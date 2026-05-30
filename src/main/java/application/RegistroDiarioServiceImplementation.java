package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
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
    public RegistroDiario createRegistro(RegistroDiario registro) throws ValidacionException {
        RegistroDiario filled = registro.createRegistro(registro);
        if (filled == null) throw new ValidacionException("Datos de registro diario inválidos.");
        try {
            return repository.saveRegistroDiario(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar registro diario.", e);
        }
    }

    @Override
    public RegistroDiario updateRegistro(RegistroDiario registro) throws ValidacionException {
        RegistroDiario filled = registro.updateRegistro(registro);
        if (filled == null) throw new ValidacionException("Datos de registro diario inválidos para actualizar.");
        try {
            return repository.updateRegistroDiario(filled.getIdRegistro(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar registro diario.", e);
        }
    }

    @Override
    public void getRegistroById(int id, RegistroDiario registro) {
        try {
            RegistroDiario r = repository.findRegistroDiarioById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("RegistroDiario", id));
            System.out.println("Id: " + r.getIdRegistro() + " | Fecha: " + r.getFecha() + " | Temp: " + r.getTemperaturaBasal() + " | Peso: " + r.getPeso());
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar registro diario con id " + id, e);
        }
    }

    @Override
    public void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro) {
        try {
            List<RegistroDiario> result = repository.findAllRegistrosDiarios();
            if (result.isEmpty()) {
                System.out.println("No hay registros diarios registrados.");
            } else {
                result.forEach(r -> System.out.println("[" + r.getIdRegistro() + "] " + r.getFecha() + " | Temp: " + r.getTemperaturaBasal() + " | Peso: " + r.getPeso()));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener registros diarios.", e);
        }
    }

    @Override
    public void deleteRegistro(int id) {
        try {
            repository.deleteRegistroDiarioById(id);
            System.out.println("Registro con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar registro diario con id " + id, e);
        }
    }
}
