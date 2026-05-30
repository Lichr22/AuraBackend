package application.infrastructure.db;

import application.domain.PermisosCompartidos;
import application.domain.Usuario;
import application.infrastructure.mapper.PermisosCompartidosRowMapper;
import application.service.port.PermisosCompartidosRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PermisosCompartidosDAO extends BaseDAO implements PermisosCompartidosRepositoryPort {

    private final PermisosCompartidosRowMapper mapper = new PermisosCompartidosRowMapper();


    @Override
    public PermisosCompartidos savePermiso(PermisosCompartidos permiso) {
        String sql = "INSERT INTO permisos_compartidos (id_usuario_propietario, id_usuario_invitado, nivel_acceso, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, permiso.getUsuarioPropietario().getIdUsuario());
            stmt.setInt(2, permiso.getUsuarioInvitado().getIdUsuario());
            stmt.setString(3, permiso.getNivelAcceso());
            stmt.setString(4, permiso.getEstado());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) permiso.setIdPermiso(rs.getLong(1));
            return permiso;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar permiso compartido: " + e.getMessage(), e);
        }
    }

    @Override
    public PermisosCompartidos updatePermiso(Long id, PermisosCompartidos permiso) {
        String sql = "UPDATE permisos_compartidos SET nivel_acceso=?, estado=? WHERE id_permiso=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, permiso.getNivelAcceso());
            stmt.setString(2, permiso.getEstado());
            stmt.setLong(3, id);
            stmt.executeUpdate();
            return permiso;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar permiso compartido: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<PermisosCompartidos> findPermisoById(Long id) {
        String sql = "SELECT * FROM permisos_compartidos WHERE id_permiso = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar permiso compartido: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PermisosCompartidos> findAllPermisos() {
        String sql = "SELECT * FROM permisos_compartidos ORDER BY id_permiso";
        List<PermisosCompartidos> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar permisos compartidos: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deletePermisoById(Long id) {
        String sql = "DELETE FROM permisos_compartidos WHERE id_permiso = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar permiso compartido: " + e.getMessage(), e);
        }
    }

}
