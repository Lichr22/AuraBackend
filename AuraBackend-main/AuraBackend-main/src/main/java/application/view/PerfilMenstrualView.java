package application.view;

import application.domain.PerfilMenstrual;
import application.service.PerfilMenstrualServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class PerfilMenstrualView {

    private final PerfilMenstrualServiceImplementation service;
    private final PerfilMenstrual perfilMenstrual;

    public PerfilMenstrualView(PerfilMenstrualServiceImplementation service, PerfilMenstrual perfilMenstrual) {
        this.service = service;
        this.perfilMenstrual = perfilMenstrual;
    }

    public void createPerfil() {
        service.createPerfil(perfilMenstrual);
    }

    public void updatePerfil() {
        service.updatePerfil(perfilMenstrual);
    }

    public void getPerfilById() {
        int id = FormValidationUtil.validateInt("Ingrese el id del perfil a consultar:");
        service.getPerfilById(id, perfilMenstrual);
    }

    public void getAllPerfiles() {
        service.getAllPerfiles(new ArrayList<>(), perfilMenstrual);
    }

    public void deletePerfil() {
        int id = FormValidationUtil.validateInt("Ingrese el id del perfil a eliminar:");
        service.deletePerfil(id);
    }

}
