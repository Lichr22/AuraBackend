package infraestructure.out.dao.impl;

import domain.Prediccion;
import infraestructure.out.dao.PrediccionDao;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.PrediccionRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrediccionDaoImpl implements PrediccionDao {

    private final Connection connection;
    private final PrediccionRowMapper mapper = new PrediccionRowMapper();

    public PrediccionDaoImpl() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public Prediccion save(Prediccion p) {
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
    public Prediccion update(Integer id, Prediccion p) {
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
    public Optional<Prediccion> findById(Integer id) {
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
    public List<Prediccion> findAll() {
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
    public void deleteById(Integer id) {
        String sql = "DELETE FROM prediccion WHERE id_prediccion = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar predicción: " + e.getMessage());
        }
    }
}
