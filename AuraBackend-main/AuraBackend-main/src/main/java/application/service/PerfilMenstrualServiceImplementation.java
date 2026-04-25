package application.service;

import application.domain.PerfilMenstrual;
import application.service.outputs.PerfilMenstrualService;

import java.util.List;

public class PerfilMenstrualServiceImplementation implements PerfilMenstrualService {

    public PerfilMenstrualServiceImplementation(PerfilMenstrualServiceImplementation perfilMenstrualServiceImplementation, PerfilMenstrual perfilMenstrual) {
    }

    public PerfilMenstrualServiceImplementation() {

    }

    @Override
    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) {
        perfil.createPerfil(perfil);
        return perfil;
    }

    @Override
    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil) {
        return perfil;
    }

    @Override
    public void deletePerfil(int id) {
    }

    @Override
    public List<PerfilMenstrual> getPerfilById(int id) {
        return List.of();
    }

}
