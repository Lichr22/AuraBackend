package infraestructure.out.mapper;

import domain.RegistroFlujo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroFlujoRowMapper {

    public RegistroFlujo map(ResultSet rs) throws SQLException {
        return new RegistroFlujo(
                rs.getInt("id_flujo"),
                null,
                rs.getString("tipo_textura"),
                rs.getString("color"),
                rs.getString("cantidad")
        );
    }
}
