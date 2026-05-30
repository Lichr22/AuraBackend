package infraestructure.config;

import userinterface.MenuApp;

public class Config {

    public static MenuApp createMenuApp() {
        return new MenuApp(
                ViewFactory.createUsuarioView(),
                ViewFactory.createCicloView(),
                ViewFactory.createPerfilMenstrualView(),
                ViewFactory.createRegistroDiarioView(),
                ViewFactory.createRegistroFlujoView(),
                ViewFactory.createActividadSexualView(),
                ViewFactory.createPrediccionView(),
                ViewFactory.createRecomendacionIAView(),
                ViewFactory.createVinculoParejaView(),
                ViewFactory.createPermisosCompartidosView()
        );
    }
}
