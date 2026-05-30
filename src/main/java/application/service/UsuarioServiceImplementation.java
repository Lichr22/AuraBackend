package application.service;

import application.domain.Usuario;
import application.domain.enums.EstadoCuenta;
import application.domain.enums.RolUsuario;
import application.exception.BaseDatosException;
import application.exception.EntidadNoEncontradaException;
import application.exception.ValidacionException;
import application.service.outputs.UsuarioService;
import application.service.port.UsuarioRepositoryPort;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class UsuarioServiceImplementation implements UsuarioService {

    // ── Inyección de dependencias por constructor (requisito 7) ──────────────
    private final UsuarioRepositoryPort repositoryPort;

    public UsuarioServiceImplementation(UsuarioRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    // ── Colección Map para caché en memoria (requisito 11) ───────────────────
    private final Map<Integer, Usuario> cacheUsuarios = new HashMap<>();

    // ════════════════════════════════════════════════════════════════════════
    //  CREATE
    // ════════════════════════════════════════════════════════════════════════

    @Override
    public Usuario createUsuario(Usuario usuario) {
        // Validación de negocio (requisito 10) — lanza Checked exception
        try {
            validarEmailUnico(usuario.getEmail());
            validarRolValido(usuario.getRol());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }

        // Establecer valores por defecto del negocio
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setEstadoCuenta(EstadoCuenta.ACTIVO.getDescription());
        usuario.setCodigoVinculacion(generarCodigoVinculacion());

        // Persistir usando el puerto (requisito 3 — Ports & Adapters)
        try {
            Usuario guardado = repositoryPort.saveUsuario(usuario);
            cacheUsuarios.put(guardado.getIdUsuario(), guardado); // actualizar caché
            System.out.println("Usuario creado exitosamente con id: " + guardado.getIdUsuario());
            return guardado;
        } catch (Exception e) {
            // Unchecked exception para errores de infraestructura (requisito 8)
            throw new BaseDatosException("Error al guardar el usuario en la base de datos.", e);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  UPDATE
    // ════════════════════════════════════════════════════════════════════════

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        // Verificar que el usuario existe antes de actualizar
        Optional<Usuario> existente = repositoryPort.findUsuarioById(usuario.getIdUsuario());
        if (existente.isEmpty()) {
            throw new EntidadNoEncontradaException("Usuario", usuario.getIdUsuario());
        }

        try {
            validarRolValido(usuario.getRol());
            validarEstadoCuentaValido(usuario.getEstadoCuenta());
        } catch (ValidacionException e) {
            System.out.println("Error de validación: " + e.getMessage());
            return null;
        }

        try {
            Usuario actualizado = repositoryPort.updateUsuario(usuario.getIdUsuario(), usuario);
            cacheUsuarios.put(actualizado.getIdUsuario(), actualizado); // refrescar caché
            System.out.println("Usuario actualizado exitosamente.");
            return actualizado;
        } catch (Exception e) {
            throw new BaseDatosException("Error al actualizar el usuario.", e);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  READ — por ID
    // ════════════════════════════════════════════════════════════════════════

    @Override
    public void getUsuarioById(int id, Usuario usuario) {
        // Buscar primero en caché (colección Map — requisito 11)
        if (cacheUsuarios.containsKey(id)) {
            imprimirUsuario(cacheUsuarios.get(id));
            return;
        }

        // Si no está en caché, buscar en base de datos
        Optional<Usuario> encontrado = repositoryPort.findUsuarioById(id);

        // Unchecked exception si no existe (requisito 8)
        if (encontrado.isEmpty()) {
            throw new EntidadNoEncontradaException("Usuario", id);
        }

        cacheUsuarios.put(id, encontrado.get()); // guardar en caché
        imprimirUsuario(encontrado.get());
    }

    // ════════════════════════════════════════════════════════════════════════
    //  READ — todos
    // ════════════════════════════════════════════════════════════════════════

    @Override
    public void getAllUsuarios(List<Usuario> usuarios, Usuario usuario) {
        List<Usuario> lista = repositoryPort.findAllUsuarios();

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        // Uso de streams y Collectors (requisito 11 — Colecciones)
        lista.stream()
                .sorted(Comparator.comparing(Usuario::getNombre))
                .forEach(u -> System.out.println(
                        "[" + u.getIdUsuario() + "] " + u.getNombre() +
                                " | " + u.getEmail() +
                                " | " + u.getRol() +
                                " | " + u.getEstadoCuenta()
                ));

        System.out.println("Total de usuarios: " + lista.size());
    }

    // ════════════════════════════════════════════════════════════════════════
    //  DELETE
    // ════════════════════════════════════════════════════════════════════════

    @Override
    public void deleteUsuario(int id) {
        // Verificar existencia antes de eliminar
        Optional<Usuario> existente = repositoryPort.findUsuarioById(id);
        if (existente.isEmpty()) {
            throw new EntidadNoEncontradaException("Usuario", id);
        }

        try {
            repositoryPort.deleteUsuarioById(id);
            cacheUsuarios.remove(id); // limpiar caché
            System.out.println("Usuario con id " + id + " eliminado correctamente.");
        } catch (Exception e) {
            throw new BaseDatosException("Error al eliminar el usuario.", e);
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MÉTODOS AUXILIARES — validaciones de negocio (requisito 10)
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Validación de negocio: el email debe ser único en el sistema.
     * Lanza Checked exception — el llamador debe decidir qué hacer. (requisito 8)
     */
    private void validarEmailUnico(String email) throws ValidacionException {
        List<Usuario> todos = repositoryPort.findAllUsuarios();

        // Uso de streams para filtrar (requisito 11)
        boolean existeEmail = todos.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));

        if (existeEmail) {
            throw new ValidacionException("El email '" + email + "' ya está registrado en el sistema.");
        }
    }

    /**
     * Validación de negocio: el rol debe ser uno de los valores permitidos por el enum.
     */
    private void validarRolValido(String rol) throws ValidacionException {
        // Uso de Set para búsqueda O(1) (requisito 11)
        Set<String> rolesPermitidos = Arrays.stream(RolUsuario.values())
                .map(RolUsuario::getDescription)
                .collect(Collectors.toSet());

        if (!rolesPermitidos.contains(rol)) {
            throw new ValidacionException(
                    "El rol '" + rol + "' no es válido. Roles permitidos: " + rolesPermitidos
            );
        }
    }

    /**
     * Validación de negocio: el estado de cuenta debe coincidir con el enum.
     */
    private void validarEstadoCuentaValido(String estado) throws ValidacionException {
        Set<String> estadosPermitidos = Arrays.stream(EstadoCuenta.values())
                .map(EstadoCuenta::getDescription)
                .collect(Collectors.toSet());

        if (!estadosPermitidos.contains(estado)) {
            throw new ValidacionException(
                    "El estado '" + estado + "' no es válido. Estados permitidos: " + estadosPermitidos
            );
        }
    }

    /**
     * Genera un código único de vinculación para el usuario.
     * Usa UUID para garantizar unicidad (colecciones — requisito 11).
     */
    private String generarCodigoVinculacion() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    /**
     * Imprime los datos de un usuario en consola de forma formateada.
     */
    private void imprimirUsuario(Usuario u) {
        System.out.println("──────────────────────────────");
        System.out.println("ID:              " + u.getIdUsuario());
        System.out.println("Nombre:          " + u.getNombre());
        System.out.println("Email:           " + u.getEmail());
        System.out.println("Rol:             " + u.getRol());
        System.out.println("Código vinc.:    " + u.getCodigoVinculacion());
        System.out.println("Fecha registro:  " + u.getFechaRegistro());
        System.out.println("Estado cuenta:   " + u.getEstadoCuenta());
        System.out.println("──────────────────────────────");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MÉTODOS EXTRA — uso avanzado de colecciones (requisito 11)
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Retorna solo los usuarios con estado ACTIVO usando streams.
     */
    public List<Usuario> getUsuariosActivos() {
        return repositoryPort.findAllUsuarios().stream()
                .filter(u -> u.getEstadoCuenta().equals(EstadoCuenta.ACTIVO.getDescription()))
                .sorted(Comparator.comparing(Usuario::getNombre))
                .collect(Collectors.toList());
    }

    /**
     * Agrupa usuarios por rol usando Map y streams.
     */
    public Map<String, List<Usuario>> getUsuariosAgrupadosPorRol() {
        return repositoryPort.findAllUsuarios().stream()
                .collect(Collectors.groupingBy(Usuario::getRol));
    }
}