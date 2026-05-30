package application.userinterface;

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
                case 1  -> menuUsuario();
                case 2  -> menuCiclo();
                case 3  -> menuPerfilMenstrual();
                case 4  -> menuRegistroDiario();
                case 5  -> menuRegistroFlujo();
                case 6  -> menuActividadSexual();
                case 7  -> menuPrediccion();
                case 8  -> menuRecomendacionIA();
                case 9  -> menuVinculoPareja();
                case 10 -> menuPermisosCompartidos();
                case 0  -> corriendo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
        System.out.println("Saliendo de Aura. ¡Hasta pronto!");
    }

    // ── Submenús ──────────────────────────────────────────────────────────────

    private void menuUsuario() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Usuario ---");
            System.out.println("1. Crear usuario");
            System.out.println("2. Actualizar usuario");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Listar todos los usuarios");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> usuarioView.createUsuario();
                case 2 -> usuarioView.updateUsuario();
                case 3 -> usuarioView.getUsuarioById();
                case 4 -> usuarioView.getAllUsuarios();
                case 5 -> usuarioView.deleteUsuario();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuCiclo() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Ciclo ---");
            System.out.println("1. Crear ciclo");
            System.out.println("2. Actualizar ciclo");
            System.out.println("3. Buscar ciclo por ID");
            System.out.println("4. Listar todos los ciclos");
            System.out.println("5. Eliminar ciclo");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> cicloView.createCiclo();
                case 2 -> cicloView.updateCiclo();
                case 3 -> cicloView.getCicloById();
                case 4 -> cicloView.getAllCiclos();
                case 5 -> cicloView.deleteCiclo();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuPerfilMenstrual() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Perfil Menstrual ---");
            System.out.println("1. Crear perfil");
            System.out.println("2. Actualizar perfil");
            System.out.println("3. Buscar perfil por ID");
            System.out.println("4. Listar todos los perfiles");
            System.out.println("5. Eliminar perfil");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> perfilMenstrualView.createPerfil();
                case 2 -> perfilMenstrualView.updatePerfil();
                case 3 -> perfilMenstrualView.getPerfilById();
                case 4 -> perfilMenstrualView.getAllPerfiles();
                case 5 -> perfilMenstrualView.deletePerfil();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuRegistroDiario() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Registro Diario ---");
            System.out.println("1. Crear registro");
            System.out.println("2. Actualizar registro");
            System.out.println("3. Buscar registro por ID");
            System.out.println("4. Listar todos los registros");
            System.out.println("5. Eliminar registro");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> registroDiarioView.createRegistro();
                case 2 -> registroDiarioView.updateRegistro();
                case 3 -> registroDiarioView.getRegistroById();
                case 4 -> registroDiarioView.getAllRegistros();
                case 5 -> registroDiarioView.deleteRegistro();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuRegistroFlujo() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Registro de Flujo ---");
            System.out.println("1. Crear registro de flujo");
            System.out.println("2. Actualizar registro de flujo");
            System.out.println("3. Buscar registro de flujo por ID");
            System.out.println("4. Listar todos los registros de flujo");
            System.out.println("5. Eliminar registro de flujo");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> registroFlujoView.createRegistroFlujo();
                case 2 -> registroFlujoView.updateRegistroFlujo();
                case 3 -> registroFlujoView.getRegistroFlujoById();
                case 4 -> registroFlujoView.getAllRegistrosFlujo();
                case 5 -> registroFlujoView.deleteRegistroFlujo();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuActividadSexual() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Actividad Sexual ---");
            System.out.println("1. Crear actividad sexual");
            System.out.println("2. Actualizar actividad sexual");
            System.out.println("3. Buscar actividad sexual por ID");
            System.out.println("4. Listar todas las actividades sexuales");
            System.out.println("5. Eliminar actividad sexual");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> actividadSexualView.createActividadSexual();
                case 2 -> actividadSexualView.updateActividadSexual();
                case 3 -> actividadSexualView.getActividadSexualById();
                case 4 -> actividadSexualView.getAllActividadesSexuales();
                case 5 -> actividadSexualView.deleteActividadSexual();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuPrediccion() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Predicción ---");
            System.out.println("1. Crear predicción");
            System.out.println("2. Actualizar predicción");
            System.out.println("3. Buscar predicción por ID");
            System.out.println("4. Listar todas las predicciones");
            System.out.println("5. Eliminar predicción");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> prediccionView.createPrediccion();
                case 2 -> prediccionView.updatePrediccion();
                case 3 -> prediccionView.getPrediccionById();
                case 4 -> prediccionView.getAllPredicciones();
                case 5 -> prediccionView.deletePrediccion();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuRecomendacionIA() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Recomendación IA ---");
            System.out.println("1. Crear recomendación");
            System.out.println("2. Actualizar recomendación");
            System.out.println("3. Buscar recomendación por ID");
            System.out.println("4. Listar todas las recomendaciones");
            System.out.println("5. Eliminar recomendación");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> recomendacionIAView.createRecomendacion();
                case 2 -> recomendacionIAView.updateRecomendacion();
                case 3 -> recomendacionIAView.getRecomendacionById();
                case 4 -> recomendacionIAView.getAllRecomendaciones();
                case 5 -> recomendacionIAView.deleteRecomendacion();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuVinculoPareja() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Vínculo Pareja ---");
            System.out.println("1. Crear vínculo");
            System.out.println("2. Actualizar vínculo");
            System.out.println("3. Buscar vínculo por ID");
            System.out.println("4. Listar todos los vínculos");
            System.out.println("5. Eliminar vínculo");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> vinculoParejaView.createVinculo();
                case 2 -> vinculoParejaView.updateVinculo();
                case 3 -> vinculoParejaView.getVinculoById();
                case 4 -> vinculoParejaView.getAllVinculos();
                case 5 -> vinculoParejaView.deleteVinculo();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void menuPermisosCompartidos() {
        boolean activo = true;
        while (activo) {
            System.out.println("\n--- Permisos Compartidos ---");
            System.out.println("1. Crear permiso");
            System.out.println("2. Actualizar permiso");
            System.out.println("3. Buscar permiso por ID");
            System.out.println("4. Listar todos los permisos");
            System.out.println("5. Eliminar permiso");
            System.out.println("0. Volver");
            switch (FormValidationUtil.validateInt("Seleccione:")) {
                case 1 -> permisosCompartidosView.createPermiso();
                case 2 -> permisosCompartidosView.updatePermiso();
                case 3 -> permisosCompartidosView.getPermisoById();
                case 4 -> permisosCompartidosView.getAllPermisos();
                case 5 -> permisosCompartidosView.deletePermiso();
                case 0 -> activo = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

}
