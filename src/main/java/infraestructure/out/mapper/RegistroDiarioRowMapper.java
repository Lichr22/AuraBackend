package infraestructure.out.mapper;

import domain.RegistroDiario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroDiarioRowMapper {

    public RegistroDiario map(ResultSet rs) throws SQLException {
        return new RegistroDiario(
                rs.getInt("id_registro"),
                null,
                null,
                rs.getDate("fecha").toLocalDate(),
                rs.getDouble("temperatura_basal"),
                rs.getDouble("peso"),
                rs.getString("calidad_sueno"),
                rs.getString("notas_libres")
        );
    }
}
