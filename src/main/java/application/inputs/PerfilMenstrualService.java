package application.inputs;

import application.exceptions.ValidacionException;
import domain.PerfilMenstrual;

import java.util.List;

public interface PerfilMenstrualService {

    PerfilMenstrual createPerfil(PerfilMenstrual perfil) throws ValidacionException;

    PerfilMenstrual updatePerfil(PerfilMenstrual perfil) throws ValidacionException;

    void getPerfilById(int id, PerfilMenstrual perfil);

    void getAllPerfiles(List<PerfilMenstrual> perfiles, PerfilMenstrual perfil);

    void deletePerfil(int id);

}
