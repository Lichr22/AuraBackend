package application.infrastructure.db;

import application.service.port.*;

// Patrón Factory — centraliza la creación de todos los DAOs (req. 5)
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {}

    // También es Singleton — una sola fábrica en la app (req. 6)
    public static RepositoryFactory getInstance() {
        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;
    }

    public UsuarioRepositoryPort createUsuarioRepository() {
        return new UsuarioDAO();
    }

    public CicloRepositoryPort createCicloRepository() {
        return new CicloDAO();
    }

    public PerfilMenstrualRepositoryPort createPerfilMenstrualRepository() {
        return new PerfilMenstrualDAO();
    }

    public RegistroDiarioRepositoryPort createRegistroDiarioRepository() {
        return new RegistroDiarioDAO();
    }

    public RegistroFlujoRepositoryPort createRegistroFlujoRepository() {
        return new RegistroFlujoDAO();
    }

    public ActividadSexualRepositoryPort createActividadSexualRepository() {
        return new ActividadSexualDAO();
    }

    public PrediccionRepositoryPort createPrediccionRepository() {
        return new PrediccionDAO();
    }

    public RecomendacionIARepositoryPort createRecomendacionIARepository() {
        return new RecomendacionIADAO();
    }

    public VinculoParejaRepositoryPort createVinculoParejaRepository() {
        return new VinculoParejaDAO();
    }

    public PermisosCompartidosRepositoryPort createPermisosCompartidosRepository() {
        return new PermisosCompartidosDAO();
    }
}
