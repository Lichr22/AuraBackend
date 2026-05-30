package infraestructure.out.mapper;

import domain.PermisosCompartidos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermisosCompartidosRowMapper {

    public PermisosCompartidos map(ResultSet rs) throws SQLException {
        return new PermisosCompartidos(
                rs.getLong("id_permiso"),
                null,
                null,
                rs.getString("nivel_acceso"),
                rs.getString("estado")
        );
    }
}
