package application.service;

import application.domain.PerfilMenstrual;

import java.util.List;

public class PerfilMenstrualServiceImplementation implements PerfilMenstrualService {

    @Override
    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) {
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
