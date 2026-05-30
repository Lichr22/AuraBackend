package infraestructure.out.mapper;

import domain.VinculoPareja;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VinculoParejaRowMapper {

    public VinculoPareja map(ResultSet rs) throws SQLException {
        return new VinculoPareja(
                rs.getLong("id_vinculo_pareja"),
                null,
                null,
                rs.getString("estado_vinculo"),
                rs.getDate("fecha_vinculacion").toLocalDate()
        );
    }
}
