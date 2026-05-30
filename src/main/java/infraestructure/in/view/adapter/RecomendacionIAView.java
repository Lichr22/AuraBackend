package infraestructure.in.view.adapter;

import application.exceptions.ValidacionException;
import domain.RecomendacionIA;
import application.RecomendacionIAServiceImplementation;
import infraestructure.util.FormValidationUtil;

import java.util.ArrayList;

public class RecomendacionIAView {

    private final RecomendacionIAServiceImplementation service;
    private final RecomendacionIA recomendacionIA;

    public RecomendacionIAView(RecomendacionIAServiceImplementation service, RecomendacionIA recomendacionIA) {
        this.service = service;
        this.recomendacionIA = recomendacionIA;
    }

    public void createRecomendacion() {
        try {
            service.createRecomendacion(recomendacionIA);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void updateRecomendacion() {
        try {
            service.updateRecomendacion(recomendacionIA);
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
        }
    }

    public void getRecomendacionById() {
        long id = FormValidationUtil.validateInt("Ingrese el id de la recomendación a consultar:");
        service.getRecomendacionById(id, recomendacionIA);
    }

    public void getAllRecomendaciones() {
        service.getAllRecomendaciones(new ArrayList<>(), recomendacionIA);
    }

    public void deleteRecomendacion() {
        long id = FormValidationUtil.validateInt("Ingrese el id de la recomendación a eliminar:");
        service.deleteRecomendacion(id);
    }

}
