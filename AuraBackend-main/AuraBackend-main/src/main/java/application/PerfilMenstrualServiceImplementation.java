package application;

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
    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) {
        PerfilMenstrual filled = perfil.createPerfil(perfil);
        return filled != null ? repository.savePerfilMenstrual(filled) : null;
    }

    @Override
    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil) {
        PerfilMenstrual filled = perfil.updatePerfil(perfil);
        return filled != null ? repository.updatePerfilMenstrual(filled.getIdPerfil(), filled) : null;
    }

    @Override
    public void getPerfilById(int id, PerfilMenstrual perfil) {
        repository.findPerfilMenstrualById(id)
                .ifPresentOrElse(
                        p -> System.out.println("Id: " + p.getIdPerfil() + " | Edad: " + p.getEdad() + " | Ciclo: " + p.getCicloPromedio() + " dias"),
                        () -> System.out.println("Perfil con id " + id + " no encontrado.")
                );
    }

    @Override
    public void getAllPerfiles(List<PerfilMenstrual> perfiles, PerfilMenstrual perfil) {
        List<PerfilMenstrual> result = repository.findAllPerfilesMenstruales();
        if (result.isEmpty()) {
            System.out.println("No hay perfiles registrados.");
        } else {
            result.forEach(p -> System.out.println("[" + p.getIdPerfil() + "] Edad: " + p.getEdad() + " | Ciclo: " + p.getCicloPromedio() + " dias"));
        }
    }

    @Override
    public void deletePerfil(int id) {
        repository.deletePerfilMenstrualById(id);
        System.out.println("Perfil con id " + id + " eliminado.");
    }
}
