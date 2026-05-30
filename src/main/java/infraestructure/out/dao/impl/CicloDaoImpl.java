package infraestructure.out.dao.impl;

import domain.Ciclo;
import infraestructure.out.dao.CicloDao;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.CicloRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CicloDaoImpl implements CicloDao {

    private final Connection connection;
    private final CicloRowMapper mapper = new CicloRowMapper();

    public CicloDaoImpl() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public Ciclo save(Ciclo c) {
        String sql = "INSERT INTO ciclo (id_ciclo, id_usuario, fecha_inicio, fecha_fin, duracion_total, es_regular) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, c.getIdCiclo());
            ps.setObject(2, c.getUsuario() != null ? c.getUsuario().getIdUsuario() : null);
            ps.setDate(3, Date.valueOf(c.getFechaInicio()));
            ps.setDate(4, c.getFechaFin() != null ? Date.valueOf(c.getFechaFin()) : null);
            ps.setInt(5, c.getDuracionTotal());
            ps.setBoolean(6, c.isEsRegular());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar ciclo: " + e.getMessage());
        }
        return c;
    }

    @Override
    public Ciclo update(Integer id, Ciclo c) {
        String sql = "UPDATE ciclo SET fecha_inicio=?, fecha_fin=?, duracion_total=?, es_regular=? WHERE id_ciclo=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(c.getFechaInicio()));
            ps.setDate(2, c.getFechaFin() != null ? Date.valueOf(c.getFechaFin()) : null);
            ps.setInt(3, c.getDuracionTotal());
            ps.setBoolean(4, c.isEsRegular());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar ciclo: " + e.getMessage());
        }
        return c;
    }

    @Override
    public Optional<Ciclo> findById(Integer id) {
        String sql = "SELECT * FROM ciclo WHERE id_ciclo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar ciclo: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Ciclo> findAll() {
        List<Ciclo> lista = new ArrayList<>();
        String sql = "SELECT * FROM ciclo";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar ciclos: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM ciclo WHERE id_ciclo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar ciclo: " + e.getMessage());
        }
    }
}
