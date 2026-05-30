package application.infrastructure.db;

import application.domain.Prediccion;
import application.domain.Usuario;
import application.infrastructure.mapper.PrediccionRowMapper;
import application.service.port.PrediccionRepositoryPort;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrediccionDAO extends BaseDAO implements PrediccionRepositoryPort {

    private final PrediccionRowMapper mapper = new PrediccionRowMapper();


    @Override
    public Prediccion savePrediccion(Prediccion prediccion) {
        String sql = "INSERT INTO predicciones (id_usuario, fecha_calculo, proxima_menstruacion_estimada, inicio_ventana_fertil, fin_ventana_fertil, probabilidad_embarazo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, prediccion.getUsuario().getIdUsuario());
            stmt.setDate(2, Date.valueOf(prediccion.getFechaCalculo()));
            stmt.setDate(3, Date.valueOf(prediccion.getProximaMenstruacionEstimada()));
            stmt.setDate(4, Date.valueOf(prediccion.getInicioVentanaFertil()));
            stmt.setDate(5, Date.valueOf(prediccion.getFinVentanaFertil()));
            stmt.setString(6, prediccion.getProbabilidadEmbarazo());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) prediccion.setIdPrediccion(rs.getInt(1));
            return prediccion;
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar predicción: " + e.getMessage(), e);
        }
    }

    @Override
    public Prediccion updatePrediccion(int id, Prediccion prediccion) {
        String sql = "UPDATE predicciones SET fecha_calculo=?, proxima_menstruacion_estimada=?, inicio_ventana_fertil=?, fin_ventana_fertil=?, probabilidad_embarazo=? WHERE id_prediccion=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(prediccion.getFechaCalculo()));
            stmt.setDate(2, Date.valueOf(prediccion.getProximaMenstruacionEstimada()));
            stmt.setDate(3, Date.valueOf(prediccion.getInicioVentanaFertil()));
            stmt.setDate(4, Date.valueOf(prediccion.getFinVentanaFertil()));
            stmt.setString(5, prediccion.getProbabilidadEmbarazo());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return prediccion;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar predicción: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Prediccion> findPrediccionById(int id) {
        String sql = "SELECT * FROM predicciones WHERE id_prediccion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar predicción: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Prediccion> findAllPredicciones() {
        String sql = "SELECT * FROM predicciones ORDER BY fecha_calculo DESC";
        List<Prediccion> lista = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar predicciones: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void deletePrediccionById(int id) {
        String sql = "DELETE FROM predicciones WHERE id_prediccion = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar predicción: " + e.getMessage(), e);
        }
    }

}
