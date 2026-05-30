package application.infrastructure.db;

import application.domain.Usuario;
import application.infrastructure.mapper.UsuarioRowMapper;
import application.service.port.UsuarioRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO extends BaseDAO implements UsuarioRepositoryPort {

    private final UsuarioRowMapper mapper = new UsuarioRowMapper();


    @Override
    public Usuario saveUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, contrasena_hash, rol, codigo_vinculacion, fecha_registro, estado_cuenta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContrasenaHash());
            stmt.setString(4, usuario.getRol());
            stmt.setString(5, usuario.getCodigoVinculacion());
            stmt.setTimestamp(6, Timestamp.valueOf(usuario.getFechaRegistro()));
            stmt.setString(7, usuario.getEstadoCuenta());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) usuario.setIdUsuario(rs.getInt(1));
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario updateUsuario(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre=?, email=?, rol=?, estado_cuenta=? WHERE id_usuario=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getRol());
            stmt.setString(4, usuario.getEstadoCuenta());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            return usuario;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Usuario> findUsuarioById(int id) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        String sql = "SELECT * FROM usuarios ORDER BY nombre";
        List<Usuario> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar usuarios: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deleteUsuarioById(int id) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar usuario: " + e.getMessage(), e);
        }
    }

}
