package application.infrastructure.mapper;

import application.domain.Usuario;
import application.domain.VinculoPareja;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VinculoParejaRowMapper {

    public VinculoPareja map(ResultSet rs) throws SQLException {
        Usuario mujer = new Usuario();
        mujer.setIdUsuario(rs.getInt("id_mujer"));

        Usuario pareja = new Usuario();
        pareja.setIdUsuario(rs.getInt("id_pareja"));

        return new VinculoPareja(
            rs.getLong("id_vinculo_pareja"),
            mujer,
            pareja,
            rs.getString("estado_vinculo"),
            rs.getDate("fecha_vinculacion").toLocalDate()
        );
    }
}
