package application.service.outputs;

import application.domain.PerfilMenstrual;

import java.util.List;

public interface PerfilMenstrualService {

    PerfilMenstrual createPerfil(PerfilMenstrual perfil);

    PerfilMenstrual updatePerfil(PerfilMenstrual perfil);

    void deletePerfil(int id);

    List<PerfilMenstrual> getPerfilById(int id);

}
