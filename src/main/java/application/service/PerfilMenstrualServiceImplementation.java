package application.service;

import application.domain.PerfilMenstrual;
import application.service.outputs.PerfilMenstrualService;
import application.service.port.PerfilMenstrualRepositoryPort;

import java.util.List;

public class PerfilMenstrualServiceImplementation implements PerfilMenstrualService {

    public PerfilMenstrualServiceImplementation(PerfilMenstrualRepositoryPort perfilRepo) {}

    @Override
    public PerfilMenstrual createPerfil(PerfilMenstrual perfil) {
        return perfil.createPerfil(perfil);
    }

    @Override
    public PerfilMenstrual updatePerfil(PerfilMenstrual perfil) {
        return perfil.updatePerfil(perfil);
    }

    @Override
    public void getPerfilById(int id, PerfilMenstrual perfil) {
        perfil.getPerfilById(id);
    }

    @Override
    public void getAllPerfiles(List<PerfilMenstrual> perfiles, PerfilMenstrual perfil) {
        perfil.getAllPerfiles(perfiles);
    }

    @Override
    public void deletePerfil(int id) {
        new PerfilMenstrual().deletePerfil(id);
    }

}
