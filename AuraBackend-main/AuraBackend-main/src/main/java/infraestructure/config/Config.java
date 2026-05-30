package infraestructure.config;

import application.*;
import domain.*;
import userinterface.MenuApp;
import infraestructure.in.view.adapter.*;
import infraestructure.out.adapter.*;

public class Config {

    public static MenuApp createMenuApp() {

        Usuario usuario = new Usuario();
        UsuarioRepositoryDB usuarioRepository = new UsuarioRepositoryDB();
        UsuarioServiceImplementation usuarioServiceImplementation = new UsuarioServiceImplementation(usuarioRepository);
        UsuarioView usuarioView = new UsuarioView(usuarioServiceImplementation, usuario);

        Ciclo ciclo = new Ciclo();
        CicloRepositoryDb cicloRepository = new CicloRepositoryDb();
        CicloServiceImplementation cicloServiceImplementation = new CicloServiceImplementation(cicloRepository);
        CicloView cicloView = new CicloView(cicloServiceImplementation, ciclo);

        PerfilMenstrual perfilMenstrual = new PerfilMenstrual();
        PerfilMenstrualRepositoryDb perfilMenstrualRepository = new PerfilMenstrualRepositoryDb();
        PerfilMenstrualServiceImplementation perfilMenstrualServiceImplementation = new PerfilMenstrualServiceImplementation(perfilMenstrualRepository);
        PerfilMenstrualView perfilMenstrualView = new PerfilMenstrualView(perfilMenstrualServiceImplementation, perfilMenstrual);

        RegistroDiario registroDiario = new RegistroDiario();
        RegistroDiarioRepositoryDb registroDiarioRepository = new RegistroDiarioRepositoryDb();
        RegistroDiarioServiceImplementation registroDiarioServiceImplementation = new RegistroDiarioServiceImplementation(registroDiarioRepository);
        RegistroDiarioView registroDiarioView = new RegistroDiarioView(registroDiarioServiceImplementation, registroDiario);

        RegistroFlujo registroFlujo = new RegistroFlujo();
        RegistroFlujoRepositoryDb registroFlujoRepository = new RegistroFlujoRepositoryDb();
        RegistroFlujoServiceImplementation registroFlujoServiceImplementation = new RegistroFlujoServiceImplementation(registroFlujoRepository);
        RegistroFlujoView registroFlujoView = new RegistroFlujoView(registroFlujoServiceImplementation, registroFlujo);

        ActividadSexual actividadSexual = new ActividadSexual();
        ActividadSexualRepositoryDb actividadSexualRepository = new ActividadSexualRepositoryDb();
        ActividadSexualServiceImplementation actividadSexualServiceImplementation = new ActividadSexualServiceImplementation(actividadSexualRepository);
        ActividadSexualView actividadSexualView = new ActividadSexualView(actividadSexualServiceImplementation, actividadSexual);

        Prediccion prediccion = new Prediccion();
        PrediccionRepositoryDb prediccionRepository = new PrediccionRepositoryDb();
        PrediccionServiceImplementation prediccionServiceImplementation = new PrediccionServiceImplementation(prediccionRepository);
        PrediccionView prediccionView = new PrediccionView(prediccionServiceImplementation, prediccion);

        RecomendacionIA recomendacionIA = new RecomendacionIA();
        RecomendacionIARepositoryDb recomendacionIARepository = new RecomendacionIARepositoryDb();
        RecomendacionIAServiceImplementation recomendacionIAServiceImplementation = new RecomendacionIAServiceImplementation(recomendacionIARepository);
        RecomendacionIAView recomendacionIAView = new RecomendacionIAView(recomendacionIAServiceImplementation, recomendacionIA);

        VinculoPareja vinculoPareja = new VinculoPareja();
        VinculoParejaRepositoryDb vinculoParejaRepository = new VinculoParejaRepositoryDb();
        VinculoParejaServiceImplementation vinculoParejaServiceImplementation = new VinculoParejaServiceImplementation(vinculoParejaRepository);
        VinculoParejaView vinculoParejaView = new VinculoParejaView(vinculoParejaServiceImplementation, vinculoPareja);

        PermisosCompartidos permisosCompartidos = new PermisosCompartidos();
        PermisosCompartidosRepositoryDb permisosCompartidosRepository = new PermisosCompartidosRepositoryDb();
        PermisosCompartidosServiceImplementation permisosCompartidosServiceImplementation = new PermisosCompartidosServiceImplementation(permisosCompartidosRepository);
        PermisosCompartidosView permisosCompartidosView = new PermisosCompartidosView(permisosCompartidosServiceImplementation, permisosCompartidos);

        return new MenuApp(usuarioView, cicloView, perfilMenstrualView, registroDiarioView, registroFlujoView,
                actividadSexualView, prediccionView, recomendacionIAView, vinculoParejaView, permisosCompartidosView);
    }
}
