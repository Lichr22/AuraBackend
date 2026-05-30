package infraestructure.out.mapper;

import domain.PerfilMenstrual;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilMenstrualRowMapper {

    public PerfilMenstrual map(ResultSet rs) throws SQLException {
        return new PerfilMenstrual(
                rs.getInt("id_perfil"),
                null,
                rs.getInt("edad"),
                rs.getInt("ciclo_promedio"),
                rs.getInt("duracion_periodo_promedio"),
                rs.getBoolean("usa_anticonceptivo"),
                rs.getString("tipo_anticonceptivo")
        );
    }
}
