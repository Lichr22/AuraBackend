package infraestructure.out.adapter;

import application.ports.RegistroDiarioRepositoryPort;
import domain.RegistroDiario;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.RegistroDiarioRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistroDiarioRepositoryDb implements RegistroDiarioRepositoryPort {

    private final Connection connection;
    private final RegistroDiarioRowMapper mapper = new RegistroDiarioRowMapper();

    public RegistroDiarioRepositoryDb() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public RegistroDiario saveRegistroDiario(RegistroDiario r) {
        String sql = "INSERT INTO registro_diario (id_registro, id_usuario, id_ciclo, fecha, temperatura_basal, peso, calidad_sueno, notas_libres) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, r.getIdRegistro());
            ps.setObject(2, r.getUsuario() != null ? r.getUsuario().getIdUsuario() : null);
            ps.setObject(3, r.getCiclo() != null ? r.getCiclo().getIdCiclo() : null);
            ps.setDate(4, Date.valueOf(r.getFecha()));
            ps.setDouble(5, r.getTemperaturaBasal());
            ps.setDouble(6, r.getPeso());
            ps.setString(7, r.getCalidadSueno());
            ps.setString(8, r.getNotasLibres());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar registro diario: " + e.getMessage());
        }
        return r;
    }

    @Override
    public RegistroDiario updateRegistroDiario(int id, RegistroDiario r) {
        String sql = "UPDATE registro_diario SET fecha=?, temperatura_basal=?, peso=?, calidad_sueno=?, notas_libres=? WHERE id_registro=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(r.getFecha()));
            ps.setDouble(2, r.getTemperaturaBasal());
            ps.setDouble(3, r.getPeso());
            ps.setString(4, r.getCalidadSueno());
            ps.setString(5, r.getNotasLibres());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar registro diario: " + e.getMessage());
        }
        return r;
    }

    @Override
    public Optional<RegistroDiario> findRegistroDiarioById(int id) {
        String sql = "SELECT * FROM registro_diario WHERE id_registro = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar registro diario: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<RegistroDiario> findAllRegistrosDiarios() {
        List<RegistroDiario> lista = new ArrayList<>();
        String sql = "SELECT * FROM registro_diario";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar registros diarios: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteRegistroDiarioById(int id) {
        String sql = "DELETE FROM registro_diario WHERE id_registro = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro diario: " + e.getMessage());
        }
    }
}
