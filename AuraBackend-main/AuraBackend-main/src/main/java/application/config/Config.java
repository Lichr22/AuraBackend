package application.config;

import application.domain.*;
import application.service.*;
import application.ui.MenuApp;
import application.view.*;

public class Config {

    public static MenuApp createMenuApp() {

        Usuario usuario = new Usuario();
        UsuarioServiceImplementation usuarioServiceImplementation = new UsuarioServiceImplementation();
        UsuarioView usuarioView = new UsuarioView(usuarioServiceImplementation, usuario);

        Ciclo ciclo = new Ciclo();
        CicloServiceImplementation cicloServiceImplementation = new CicloServiceImplementation();
        CicloView cicloView = new CicloView(cicloServiceImplementation, ciclo);

        PerfilMenstrual perfilMenstrual = new PerfilMenstrual();
        PerfilMenstrualServiceImplementation perfilMenstrualServiceImplementation = new PerfilMenstrualServiceImplementation();
        PerfilMenstrualView perfilMenstrualView = new PerfilMenstrualView(perfilMenstrualServiceImplementation, perfilMenstrual);

        RegistroDiario registroDiario = new RegistroDiario();
        RegistroDiarioServiceImplementation registroDiarioServiceImplementation = new RegistroDiarioServiceImplementation();
        RegistroDiarioView registroDiarioView = new RegistroDiarioView(registroDiarioServiceImplementation, registroDiario);

        RegistroFlujo registroFlujo = new RegistroFlujo();
        RegistroFlujoServiceImplementation registroFlujoServiceImplementation = new RegistroFlujoServiceImplementation();
        RegistroFlujoView registroFlujoView = new RegistroFlujoView(registroFlujoServiceImplementation, registroFlujo);

        ActividadSexual actividadSexual = new ActividadSexual();
        ActividadSexualServiceImplementation actividadSexualServiceImplementation = new ActividadSexualServiceImplementation();
        ActividadSexualView actividadSexualView = new ActividadSexualView(actividadSexualServiceImplementation, actividadSexual);

        Prediccion prediccion = new Prediccion();
        PrediccionServiceImplementation prediccionServiceImplementation = new PrediccionServiceImplementation();
        PrediccionView prediccionView = new PrediccionView(prediccionServiceImplementation, prediccion);

        RecomendacionIA recomendacionIA = new RecomendacionIA();
        RecomendacionIAServiceImplementation recomendacionIAServiceImplementation = new RecomendacionIAServiceImplementation();
        RecomendacionIAView recomendacionIAView = new RecomendacionIAView(recomendacionIAServiceImplementation, recomendacionIA);

        VinculoPareja vinculoPareja = new VinculoPareja();
        VinculoParejaServiceImplementation vinculoParejaServiceImplementation = new VinculoParejaServiceImplementation();
        VinculoParejaView vinculoParejaView = new VinculoParejaView(vinculoParejaServiceImplementation, vinculoPareja);

        PermisosCompartidos permisosCompartidos = new PermisosCompartidos();
        PermisosCompartidosServiceImplementation permisosCompartidosServiceImplementation = new PermisosCompartidosServiceImplementation();
        PermisosCompartidosView permisosCompartidosView = new PermisosCompartidosView(permisosCompartidosServiceImplementation, permisosCompartidos);

        return new MenuApp(usuarioView, cicloView, perfilMenstrualView, registroDiarioView, registroFlujoView,
                actividadSexualView, prediccionView, recomendacionIAView, vinculoParejaView, permisosCompartidosView);
    }

}
