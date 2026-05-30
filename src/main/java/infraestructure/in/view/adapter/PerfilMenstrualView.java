package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.PerfilMenstrual;
import application.PerfilMenstrualServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class PerfilMenstrualView {

    private final PerfilMenstrualServiceImplementation service;
    private final PerfilMenstrual perfilMenstrual;

    public PerfilMenstrualView(PerfilMenstrualServiceImplementation service, PerfilMenstrual perfilMenstrual) {
        this.service = service;
        this.perfilMenstrual = perfilMenstrual;
    }

    public void createPerfil() {
        try {
            service.createPerfil(perfilMenstrual);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updatePerfil() {
        try {
            service.updatePerfil(perfilMenstrual);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
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
