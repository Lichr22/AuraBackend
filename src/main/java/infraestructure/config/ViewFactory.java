package infraestructure.config;

import application.*;
import domain.*;
import infraestructure.in.view.adapter.*;
import infraestructure.out.adapter.*;

public class ViewFactory {

    public static UsuarioView createUsuarioView() {
        return new UsuarioView(
                new UsuarioServiceImplementation(new UsuarioRepositoryDB()),
                new Usuario()
        );
    }

    public static CicloView createCicloView() {
        return new CicloView(
                new CicloServiceImplementation(new CicloRepositoryDb()),
                new Ciclo()
        );
    }

    public static PerfilMenstrualView createPerfilMenstrualView() {
        return new PerfilMenstrualView(
                new PerfilMenstrualServiceImplementation(new PerfilMenstrualRepositoryDb()),
                new PerfilMenstrual()
        );
    }

    public static RegistroDiarioView createRegistroDiarioView() {
        return new RegistroDiarioView(
                new RegistroDiarioServiceImplementation(new RegistroDiarioRepositoryDb()),
                new RegistroDiario()
        );
    }

    public static RegistroFlujoView createRegistroFlujoView() {
        return new RegistroFlujoView(
                new RegistroFlujoServiceImplementation(new RegistroFlujoRepositoryDb()),
                new RegistroFlujo()
        );
    }

    public static ActividadSexualView createActividadSexualView() {
        return new ActividadSexualView(
                new ActividadSexualServiceImplementation(new ActividadSexualRepositoryDb()),
                new ActividadSexual()
        );
    }

    public static PrediccionView createPrediccionView() {
        return new PrediccionView(
                new PrediccionServiceImplementation(new PrediccionRepositoryDb()),
                new Prediccion()
        );
    }

    public static RecomendacionIAView createRecomendacionIAView() {
        return new RecomendacionIAView(
                new RecomendacionIAServiceImplementation(new RecomendacionIARepositoryDb()),
                new RecomendacionIA()
        );
    }

    public static VinculoParejaView createVinculoParejaView() {
        return new VinculoParejaView(
                new VinculoParejaServiceImplementation(new VinculoParejaRepositoryDb()),
                new VinculoPareja()
        );
    }

    public static PermisosCompartidosView createPermisosCompartidosView() {
        return new PermisosCompartidosView(
                new PermisosCompartidosServiceImplementation(new PermisosCompartidosRepositoryDb()),
                new PermisosCompartidos()
        );
    }
}
