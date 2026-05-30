package infraestructure.out.dao.impl;

import domain.PerfilMenstrual;
import infraestructure.out.dao.PerfilMenstrualDao;
import infraestructure.out.db.DataBaseConnectionMySQL;
import infraestructure.out.mapper.PerfilMenstrualRowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PerfilMenstrualDaoImpl implements PerfilMenstrualDao {

    private final Connection connection;
    private final PerfilMenstrualRowMapper mapper = new PerfilMenstrualRowMapper();

    public PerfilMenstrualDaoImpl() {
        this.connection = DataBaseConnectionMySQL.getInstance().getConnection();
    }

    @Override
    public PerfilMenstrual save(PerfilMenstrual p) {
        String sql = "INSERT INTO perfil_menstrual (id_perfil, id_usuario, edad, ciclo_promedio, duracion_periodo_promedio, usa_anticonceptivo, tipo_anticonceptivo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPerfil());
            ps.setObject(2, p.getUsuario() != null ? p.getUsuario().getIdUsuario() : null);
            ps.setInt(3, p.getEdad());
            ps.setInt(4, p.getCicloPromedio());
            ps.setInt(5, p.getDuracionPeriodoPromedio());
            ps.setBoolean(6, p.getUsaAnticonceptivo());
            ps.setString(7, p.getTipoAnticonceptivo());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar perfil menstrual: " + e.getMessage());
        }
        return p;
    }

    @Override
    public PerfilMenstrual update(Integer id, PerfilMenstrual p) {
        String sql = "UPDATE perfil_menstrual SET edad=?, ciclo_promedio=?, duracion_periodo_promedio=?, usa_anticonceptivo=?, tipo_anticonceptivo=? WHERE id_perfil=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, p.getEdad());
            ps.setInt(2, p.getCicloPromedio());
            ps.setInt(3, p.getDuracionPeriodoPromedio());
            ps.setBoolean(4, p.getUsaAnticonceptivo());
            ps.setString(5, p.getTipoAnticonceptivo());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar perfil menstrual: " + e.getMessage());
        }
        return p;
    }

    @Override
    public Optional<PerfilMenstrual> findById(Integer id) {
        String sql = "SELECT * FROM perfil_menstrual WHERE id_perfil = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return Optional.of(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al buscar perfil menstrual: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<PerfilMenstrual> findAll() {
        List<PerfilMenstrual> lista = new ArrayList<>();
        String sql = "SELECT * FROM perfil_menstrual";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) lista.add(mapper.map(rs));
        } catch (SQLException e) {
            System.out.println("Error al listar perfiles menstruales: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM perfil_menstrual WHERE id_perfil = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar perfil menstrual: " + e.getMessage());
        }
    }
}
