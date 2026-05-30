package infraestructure.out.adapter;

import application.ports.ActividadSexualRepositoryPort;
import domain.ActividadSexual;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.ActividadSexualRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActividadSexualRepositoryDb extends BaseRepositoryDB implements ActividadSexualRepositoryPort {

    private final ActividadSexualRowMapper mapper = new ActividadSexualRowMapper();


    @Override
    public ActividadSexual saveActividadSexual(ActividadSexual a) {
        String sql = "INSERT INTO actividad_sexual (id_actividad, uso_preservativo, orgasmo, metodo_adicional) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, a.getIdActividad());
            ps.setBoolean(2, a.getUsoPreservativo());
            ps.setBoolean(3, a.getOrgasmo());
            ps.setString(4, a.getMetodoAdicional());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar actividad sexual: " + e.getMessage());
        }
        return a;
    }

    @Override
    public ActividadSexual updateActividadSexual(int id, ActividadSexual a) {
        String sql = "UPDATE actividad_sexual SET uso_preservativo=?, orgasmo=?, metodo_adicional=? WHERE id_actividad=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBoolean(1, a.getUsoPreservativo());
            ps.setBoolean(2, a.getOrgasmo());
            ps.setString(3, a.getMetodoAdicional());
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar actividad sexual: " + e.getMessage());
        }
        return a;
    }

    @Override
    public Optional<ActividadSexual> findActividadSexualById(int id) {
        String sql = "SELECT * FROM actividad_sexual WHERE id_actividad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar actividad sexual: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<ActividadSexual> findAllActividadesSexuales() {
        List<ActividadSexual> lista = new ArrayList<>();
        String sql = "SELECT * FROM actividad_sexual";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar actividades sexuales: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteActividadSexualById(int id) {
        String sql = "DELETE FROM actividad_sexual WHERE id_actividad = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar actividad sexual: " + e.getMessage());
        }
    }
}
