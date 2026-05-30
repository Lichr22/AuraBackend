package application.infrastructure.db;

import application.domain.PerfilMenstrual;
import application.domain.Usuario;
import application.service.port.PerfilMenstrualRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PerfilMenstrualDAO implements PerfilMenstrualRepositoryPort {

    private final Connection connection;

    public PerfilMenstrualDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public PerfilMenstrual savePerfilMenstrual(PerfilMenstrual perfil) {
        String sql = "INSERT INTO perfiles_menstruales (id_usuario, edad, ciclo_promedio, duracion_periodo_promedio, usa_anticonceptivo, tipo_anticonceptivo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, perfil.getUsuario().getIdUsuario());
            stmt.setInt(2, perfil.getEdad());
            stmt.setInt(3, perfil.getCicloPromedio());
            stmt.setInt(4, perfil.getDuracionPeriodoPromedio());
            stmt.setBoolean(5, perfil.getUsaAnticonceptivo());
            stmt.setString(6, perfil.getTipoAnticonceptivo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) perfil.setIdPerfil(rs.getInt(1));
            return perfil;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar perfil menstrual: " + e.getMessage(), e);
        }
    }

    @Override
    public PerfilMenstrual updatePerfilMenstrual(int id, PerfilMenstrual perfil) {
        String sql = "UPDATE perfiles_menstruales SET edad=?, ciclo_promedio=?, duracion_periodo_promedio=?, usa_anticonceptivo=?, tipo_anticonceptivo=? WHERE id_perfil=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, perfil.getEdad());
            stmt.setInt(2, perfil.getCicloPromedio());
            stmt.setInt(3, perfil.getDuracionPeriodoPromedio());
            stmt.setBoolean(4, perfil.getUsaAnticonceptivo());
            stmt.setString(5, perfil.getTipoAnticonceptivo());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return perfil;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar perfil menstrual: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<PerfilMenstrual> findPerfilMenstrualById(int id) {
        String sql = "SELECT * FROM perfiles_menstruales WHERE id_perfil = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapear(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar perfil menstrual: " + e.getMessage(), e);
        }
    }

    @Override
    public List<PerfilMenstrual> findAllPerfilesMenstruales() {
        String sql = "SELECT * FROM perfiles_menstruales ORDER BY id_perfil";
        List<PerfilMenstrual> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar perfiles menstruales: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deletePerfilMenstrualById(int id) {
        String sql = "DELETE FROM perfiles_menstruales WHERE id_perfil = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar perfil menstrual: " + e.getMessage(), e);
        }
    }

    private PerfilMenstrual mapear(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("id_usuario"));

        return new PerfilMenstrual(
            rs.getInt("id_perfil"),
            usuario,
            rs.getInt("edad"),
            rs.getInt("ciclo_promedio"),
            rs.getInt("duracion_periodo_promedio"),
            rs.getBoolean("usa_anticonceptivo"),
            rs.getString("tipo_anticonceptivo")
        );
    }
}
