package application.view;

import application.domain.Ciclo;
import application.service.CicloServiceImplementation;

public class CicloView {

    private final CicloServiceImplementation cicloServiceImplementation;
    private final Ciclo ciclo;

    public CicloView(CicloServiceImplementation cicloServiceImplementation, Ciclo ciclo) {
        this.cicloServiceImplementation = cicloServiceImplementation;
        this.ciclo = ciclo;
    }

    public void createCiclo() {
        cicloServiceImplementation.createCiclo(ciclo);
    }

}
