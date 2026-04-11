package application.view;

import application.domain.PerfilMenstrual;
import application.service.PerfilMenstrualServiceImplementation;

public class PerfilMenstrualView {

    private final PerfilMenstrualServiceImplementation perfilMenstrualServiceImplementation;
    private final PerfilMenstrual perfilMenstrual;

    public PerfilMenstrualView(PerfilMenstrualServiceImplementation perfilMenstrualServiceImplementation, PerfilMenstrual perfilMenstrual) {
        this.perfilMenstrualServiceImplementation = perfilMenstrualServiceImplementation;
        this.perfilMenstrual = perfilMenstrual;
    }

    public void createPerfil() {
        perfilMenstrualServiceImplementation.createPerfil(perfilMenstrual);
    }

    public void updatePerfil() {
        perfilMenstrualServiceImplementation.updatePerfil(perfilMenstrual);
    }

}
