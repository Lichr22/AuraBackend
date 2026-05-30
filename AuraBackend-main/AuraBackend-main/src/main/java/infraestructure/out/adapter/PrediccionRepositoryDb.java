package infraestructure.out.adapter;

import application.ports.PrediccionRepositoryPort;
import domain.Prediccion;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.PrediccionRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrediccionRepositoryDb extends BaseRepositoryDB implements PrediccionRepositoryPort {

    private final PrediccionRowMapper mapper = new PrediccionRowMapper();


    @Override
    public Prediccion savePrediccion(Prediccion p) {
        String sql = "INSERT INTO prediccion (id_prediccion, id_usuario, fecha_calculo, proxima_menstruacion_estimada, inicio_ventana_fertil, fin_ventana_fertil, probabilidad_embarazo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPrediccion());
            ps.setObject(2, p.getUsuario() != null ? p.getUsuario().getIdUsuario() : null);
            ps.setDate(3, Date.valueOf(p.getFechaCalculo()));
            ps.setDate(4, Date.valueOf(p.getProximaMenstruacionEstimada()));
            ps.setDate(5, Date.valueOf(p.getInicioVentanaFertil()));
            ps.setDate(6, Date.valueOf(p.getFinVentanaFertil()));
            ps.setString(7, p.getProbabilidadEmbarazo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar predicción: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Prediccion updatePrediccion(int id, Prediccion p) {
        String sql = "UPDATE prediccion SET fecha_calculo=?, proxima_menstruacion_estimada=?, inicio_ventana_fertil=?, fin_ventana_fertil=?, probabilidad_embarazo=? WHERE id_prediccion=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(p.getFechaCalculo()));
            ps.setDate(2, Date.valueOf(p.getProximaMenstruacionEstimada()));
            ps.setDate(3, Date.valueOf(p.getInicioVentanaFertil()));
            ps.setDate(4, Date.valueOf(p.getFinVentanaFertil()));
            ps.setString(5, p.getProbabilidadEmbarazo());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar predicción: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Optional<Prediccion> findPrediccionById(int id) {
        String sql = "SELECT * FROM prediccion WHERE id_prediccion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar predicción: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Prediccion> findAllPredicciones() {
        List<Prediccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM prediccion";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar predicciones: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deletePrediccionById(int id) {
        String sql = "DELETE FROM prediccion WHERE id_prediccion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar predicción: " + e.getMessage());
        }
    }
}
