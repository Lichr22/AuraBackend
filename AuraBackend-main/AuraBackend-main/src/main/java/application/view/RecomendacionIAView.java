package application.view;

import application.domain.RecomendacionIA;
import application.service.RecomendacionIAServiceImplementation;
import application.util.FormValidationUtil;

import java.util.ArrayList;

public class RecomendacionIAView {

    private final RecomendacionIAServiceImplementation service;
    private final RecomendacionIA recomendacionIA;

    public RecomendacionIAView(RecomendacionIAServiceImplementation service, RecomendacionIA recomendacionIA) {
        this.service = service;
        this.recomendacionIA = recomendacionIA;
    }

    public void createRecomendacion() {
        service.createRecomendacion(recomendacionIA);
    }

    public void updateRecomendacion() {
        service.updateRecomendacion(recomendacionIA);
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
