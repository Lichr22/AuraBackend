package application.userinterface;

import application.domain.*;
import application.util.FormValidationUtil;
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

    public MenuApp(UsuarioView usuarioView, CicloView cicloView,
                   PerfilMenstrualView perfilMenstrualView, RegistroDiarioView registroDiarioView,
                   RegistroFlujoView registroFlujoView, ActividadSexualView actividadSexualView,
                   PrediccionView prediccionView, RecomendacionIAView recomendacionIAView,
                   VinculoParejaView vinculoParejaView, PermisosCompartidosView permisosCompartidosView) {
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

    public void iniciar() {
        boolean corriendo = true;

        while (corriendo) {
            System.out.println("\n========== AURA - MENÚ PRINCIPAL ==========");
            System.out.println("1.  Usuario");
            System.out.println("2.  Ciclo");
            System.out.println("3.  Perfil Menstrual");
            System.out.println("4.  Registro Diario");
            System.out.println("5.  Registro de Flujo");
            System.out.println("6.  Actividad Sexual");
            System.out.println("7.  Predicción");
            System.out.println("8.  Recomendación IA");
            System.out.println("9.  Vínculo Pareja");
            System.out.println("10. Permisos Compartidos");
            System.out.println("0.  Salir");
            System.out.println("============================================");

            int opcion = FormValidationUtil.validateInt("Seleccione una opción:");

            switch (opcion) {
                case 1  -> usuarioView.createUsuario();
                case 2  -> cicloView.createCiclo();
                case 3  -> perfilMenstrualView.createPerfil();
                case 4  -> registroDiarioView.createRegistro();
                case 5  -> registroFlujoView.createRegistroFlujo();
                case 6  -> actividadSexualView.createActividadSexual();
                case 7  -> prediccionView.createPrediccion();
                case 8  -> recomendacionIAView.createRecomendacion();
                case 9  -> vinculoParejaView.createVinculo();
                case 10 -> permisosCompartidosView.createPermiso();
                case 0  -> corriendo = false;
                default -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("Saliendo de Aura. ¡Hasta pronto!");
    }
}

