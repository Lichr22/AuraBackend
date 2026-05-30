package application.service;

import application.domain.RegistroDiario;
import application.exception.BaseDatosException;
import application.exception.EntidadNoEncontradaException;
import application.exception.ValidacionException;
import application.service.outputs.RegistroDiarioService;
import application.service.port.RegistroDiarioRepositoryPort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RegistroDiarioServiceImplementation implements RegistroDiarioService {

    private final RegistroDiarioRepositoryPort repositoryPort;
    private final Map<Integer, RegistroDiario> cache = new HashMap<>();

    public RegistroDiarioServiceImplementation(RegistroDiarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public RegistroDiario createRegistro(RegistroDiario registro) {
        try {
            validarTemperatura(registro.getTemperaturaBasal());
            validarPeso(registro.getPeso());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }
        try {
            RegistroDiario guardado = repositoryPort.saveRegistroDiario(registro);
            cache.put(guardado.getIdRegistro(), guardado);
            System.out.println("Registro diario creado con id: " + guardado.getIdRegistro());
            return guardado;
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar el registro diario.", e);
        }
    }

    @Override
    public RegistroDiario updateRegistro(RegistroDiario registro) {
        Optional<RegistroDiario> existente = repositoryPort.findRegistroDiarioById(registro.getIdRegistro());
        if (existente.isEmpty()) throw new EntidadNoEncontradaException("RegistroDiario", registro.getIdRegistro());
        try {
            validarTemperatura(registro.getTemperaturaBasal());
            validarPeso(registro.getPeso());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }
        try {
            RegistroDiario actualizado = repositoryPort.updateRegistroDiario(registro.getIdRegistro(), registro);
            cache.put(actualizado.getIdRegistro(), actualizado);
            return actualizado;
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar el registro diario.", e);
        }
    }

    @Override
    public void getRegistroById(int id, RegistroDiario registro) {
        if (cache.containsKey(id)) { imprimirRegistro(cache.get(id)); return; }
        Optional<RegistroDiario> encontrado = repositoryPort.findRegistroDiarioById(id);
        if (encontrado.isEmpty()) throw new EntidadNoEncontradaException("RegistroDiario", id);
        cache.put(id, encontrado.get());
        imprimirRegistro(encontrado.get());
    }

    @Override
    public void getAllRegistros(List<RegistroDiario> registros, RegistroDiario registro) {
        List<RegistroDiario> lista = repositoryPort.findAllRegistrosDiarios();
        if (lista.isEmpty()) { System.out.println("No hay registros diarios."); return; }
        lista.stream()
                .sorted((a, b) -> b.getFecha().compareTo(a.getFecha()))
                .forEach(r -> System.out.println("[" + r.getIdRegistro() + "] " + r.getFecha() + " | Temp: " + r.getTemperaturaBasal() + "°C | Peso: " + r.getPeso() + "kg"));
    }

    @Override
    public void deleteRegistro(int id) {
        if (repositoryPort.findRegistroDiarioById(id).isEmpty()) throw new EntidadNoEncontradaException("RegistroDiario", id);
        try {
            repositoryPort.deleteRegistroDiarioById(id);
            cache.remove(id);
            System.out.println("Registro " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar el registro diario.", e);
        }
    }

    private void validarTemperatura(double temp) throws ValidacionException {
        if (temp < 35.0 || temp > 42.0)
            throw new ValidacionException("Temperatura basal fuera de rango (35.0 - 42.0°C): " + temp);
    }

    private void validarPeso(double peso) throws ValidacionException {
        if (peso < 20.0 || peso > 300.0)
            throw new ValidacionException("Peso fuera de rango válido (20 - 300 kg): " + peso);
    }

    private void imprimirRegistro(RegistroDiario r) {
        System.out.println("──────────────────────────────");
        System.out.println("ID:          " + r.getIdRegistro());
        System.out.println("Fecha:       " + r.getFecha());
        System.out.println("Temperatura: " + r.getTemperaturaBasal() + "°C");
        System.out.println("Peso:        " + r.getPeso() + "kg");
        System.out.println("Sueño:       " + r.getCalidadSueno());
        System.out.println("Notas:       " + r.getNotasLibres());
        System.out.println("──────────────────────────────");
    }
}
