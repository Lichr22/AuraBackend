package application.config;

import application.infrastructure.db.*;
import application.service.*;
import application.service.port.*;
import application.userinterface.MenuApp;
import application.view.*;

public class Config {

    public static MenuApp createMenuApp() {

        // ── 1. Singleton de conexión (se instancia una sola vez) ─────────────
        //    Esto dispara la conexión a PostgreSQL al arrancar la app
        DatabaseConnection.getInstance();

        // ── 2. Factory — crea todos los DAOs sin exponer sus clases concretas ─
        RepositoryFactory factory = RepositoryFactory.getInstance();

        UsuarioRepositoryPort           usuarioRepo        = factory.createUsuarioRepository();
        CicloRepositoryPort             cicloRepo          = factory.createCicloRepository();
        PerfilMenstrualRepositoryPort   perfilRepo         = factory.createPerfilMenstrualRepository();
        RegistroDiarioRepositoryPort    registroDiarioRepo = factory.createRegistroDiarioRepository();
        RegistroFlujoRepositoryPort     registroFlujoRepo  = factory.createRegistroFlujoRepository();
        ActividadSexualRepositoryPort   actividadRepo      = factory.createActividadSexualRepository();
        PrediccionRepositoryPort        prediccionRepo     = factory.createPrediccionRepository();
        RecomendacionIARepositoryPort   recomendacionRepo  = factory.createRecomendacionIARepository();
        VinculoParejaRepositoryPort     vinculoRepo        = factory.createVinculoParejaRepository();
        PermisosCompartidosRepositoryPort permisosRepo     = factory.createPermisosCompartidosRepository();

        // ── 3. Services — inyección de dependencias por constructor ───────────
        //    Cada service recibe su puerto (interfaz), no el DAO concreto
        UsuarioServiceImplementation          usuarioService     = new UsuarioServiceImplementation(usuarioRepo);
        CicloServiceImplementation            cicloService       = new CicloServiceImplementation(cicloRepo);
        PerfilMenstrualServiceImplementation  perfilService      = new PerfilMenstrualServiceImplementation(perfilRepo);
        RegistroDiarioServiceImplementation   registroService    = new RegistroDiarioServiceImplementation(registroDiarioRepo);
        RegistroFlujoServiceImplementation    flujoService       = new RegistroFlujoServiceImplementation(registroFlujoRepo);
        ActividadSexualServiceImplementation  actividadService   = new ActividadSexualServiceImplementation(actividadRepo);
        PrediccionServiceImplementation       prediccionService  = new PrediccionServiceImplementation(prediccionRepo);
        RecomendacionIAServiceImplementation  recomendacionService = new RecomendacionIAServiceImplementation(recomendacionRepo);
        VinculoParejaServiceImplementation    vinculoService     = new VinculoParejaServiceImplementation(vinculoRepo);
        PermisosCompartidosServiceImplementation permisosService = new PermisosCompartidosServiceImplementation(permisosRepo);

        // ── 4. Views — reciben el service (no la implementación concreta) ─────
        UsuarioView           usuarioView       = new UsuarioView(usuarioService);
        CicloView             cicloView         = new CicloView(cicloService);
        PerfilMenstrualView   perfilView2       = new PerfilMenstrualView(perfilService);
        RegistroDiarioView    registroView      = new RegistroDiarioView(registroService);
        RegistroFlujoView     flujoView         = new RegistroFlujoView(flujoService);
        ActividadSexualView   actividadView     = new ActividadSexualView(actividadService);
        PrediccionView        prediccionView    = new PrediccionView(prediccionService);
        RecomendacionIAView   recomendacionView = new RecomendacionIAView(recomendacionService);
        VinculoParejaView     vinculoView       = new VinculoParejaView(vinculoService);
        PermisosCompartidosView permisosView    = new PermisosCompartidosView(permisosService);

        // ── 5. Ensamblar y retornar el menú principal ─────────────────────────
        return new MenuApp(
            usuarioView, cicloView, perfilView2, registroView, flujoView,
            actividadView, prediccionView, recomendacionView, vinculoView, permisosView
        );
    }
}
