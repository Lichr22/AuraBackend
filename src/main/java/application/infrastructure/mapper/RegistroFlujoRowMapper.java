package application.infrastructure.mapper;

import application.domain.RegistroDiario;
import application.domain.RegistroFlujo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroFlujoRowMapper {

    public RegistroFlujo map(ResultSet rs) throws SQLException {
        RegistroDiario registroDiario = new RegistroDiario(rs.getInt("id_registro"));

        return new RegistroFlujo(
            rs.getInt("id_flujo"),
            registroDiario,
            rs.getString("tipo_textura"),
            rs.getString("color"),
            rs.getString("cantidad")
        );
    }
}
