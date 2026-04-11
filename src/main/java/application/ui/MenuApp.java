package application.ui;

import application.view.*;

public class MenuApp {

    private final UsuarioView usuarioView;
    private final CicloView cicloView;
    private final PerfilMenstrualView perfilMenstrualView;
    private final RegistroDiarioView registroDiarioView;
    private final RegistroFlujoView registroFlujoView;
    private final ActividadSexualView actividadSexualView;
    private final PrediccionView prediccionView;
    private final RecomendacionIAView recomendacionIAView;
    private final VinculoParejaView vinculoParejaView;
    private final PermisosCompartidosView permisosCompartidosView;

    public MenuApp(UsuarioView usuarioView, CicloView cicloView, PerfilMenstrualView perfilMenstrualView,
                   RegistroDiarioView registroDiarioView, RegistroFlujoView registroFlujoView,
                   ActividadSexualView actividadSexualView, PrediccionView prediccionView,
                   RecomendacionIAView recomendacionIAView, VinculoParejaView vinculoParejaView,
                   PermisosCompartidosView permisosCompartidosView) {
        this.usuarioView = usuarioView;
        this.cicloView = cicloView;
        this.perfilMenstrualView = perfilMenstrualView;
        this.registroDiarioView = registroDiarioView;
        this.registroFlujoView = registroFlujoView;
        this.actividadSexualView = actividadSexualView;
        this.prediccionView = prediccionView;
        this.recomendacionIAView = recomendacionIAView;
        this.vinculoParejaView = vinculoParejaView;
        this.permisosCompartidosView = permisosCompartidosView;
    }

}
