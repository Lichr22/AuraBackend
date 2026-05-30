package application;

import application.exceptions.BaseDatosException;
import application.exceptions.EntidadNoEncontradaException;
import application.exceptions.ValidacionException;
import application.inputs.PerfilMenstrualService;
import application.ports.PerfilMenstrualRepositoryPort;
import domain.PerfilMenstrual;

import java.util.List;

public class PerfilMenstrualServiceImplementation implements PerfilMenstrualService {

    private final PerfilMenstrualRepositoryPort repository;

    public PerfilMenstrualServiceImplementation(PerfilMenstrualRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) throws ValidacionException {
        PerfilMenstrual filled = perfil.createPerfil(perfil);
        if (filled == null) throw new ValidacionException("Datos de perfil menstrual inválidos.");
        try {
            return repository.savePerfilMenstrual(filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al guardar perfil menstrual.", e);
        }
    }

    @Override
    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil) throws ValidacionException {
        PerfilMenstrual filled = perfil.updatePerfil(perfil);
        if (filled == null) throw new ValidacionException("Datos de perfil menstrual inválidos para actualizar.");
        try {
            return repository.updatePerfilMenstrual(filled.getIdPerfil(), filled);
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar perfil menstrual.", e);
        }
    }

    @Override
    public void getPerfilById(int id, PerfilMenstrual perfil) {
        try {
            PerfilMenstrual p = repository.findPerfilMenstrualById(id)
                    .orElseThrow(() -> new EntidadNoEncontradaException("PerfilMenstrual", id));
            System.out.println("Id: " + p.getIdPerfil() + " | Edad: " + p.getEdad() + " | Ciclo: " + p.getCicloPromedio() + " dias");
        } catch (EntidadNoEncontradaException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new BaseDatosException("Error al buscar perfil menstrual con id " + id, e);
        }
    }

    @Override
    public void getAllPerfiles(List<PerfilMenstrual> perfiles, PerfilMenstrual perfil) {
        try {
            List<PerfilMenstrual> result = repository.findAllPerfilesMenstruales();
            if (result.isEmpty()) {
                System.out.println("No hay perfiles registrados.");
            } else {
                result.forEach(p -> System.out.println("[" + p.getIdPerfil() + "] Edad: " + p.getEdad() + " | Ciclo: " + p.getCicloPromedio() + " dias"));
            }
        } catch (Exception e) {
            throw new BaseDatosException("Error al obtener perfiles menstruales.", e);
        }
    }

    @Override
    public void deletePerfil(int id) {
        try {
            repository.deletePerfilMenstrualById(id);
            System.out.println("Perfil con id " + id + " eliminado.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar perfil menstrual con id " + id, e);
        }
    }
}
