package application.service.outputs;

import application.domain.PerfilMenstrual;

import java.util.List;

public interface PerfilMenstrualService {

    PerfilMenstrual createPerfil(PerfilMenstrual perfil);

    PerfilMenstrual updatePerfil(PerfilMenstrual perfil);

    void getPerfilById(int id, PerfilMenstrual perfil);

    void getAllPerfiles(List<PerfilMenstrual> perfiles, PerfilMenstrual perfil);

    void deletePerfil(int id);

}
