package co.com.mundocostenio.mybatis.sql;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Calle;

public class CalleSqlProvider {
	
	public String insert(Calle calle) {
		return new SQL() {{
			INSERT_INTO("calle");
			if(calle.getNombreCalle()!= null && calle.getNombreCalle()!="") {
				VALUES("nombre_calle", "'".concat(calle.getNombreCalle()).concat("'"));
			}
			if(calle.getTipoCalle()!= null) {
				VALUES("tipo_calle", "'".concat(calle.getTipoCalle().name()).concat("'"));
			}
		}}.toString();
	}
	
	
	public String insertDireccionCalles(int direccionId, List<Calle>calles) {
		return new SQL() {{
			INSERT_INTO("direccion_calles");
			INTO_COLUMNS("direccion_id", "calle_id");
			for(Calle calle: calles) {
				INTO_VALUES(String.valueOf(direccionId), String.valueOf(calle.getCalleId()));
				ADD_ROW();
			}
			
		}}.toString();
	}
	public String update(Calle calle) {
		return new SQL() {{
			if(calle.getCalleId() > 0) {
				UPDATE("calle");
				if(calle.getNombreCalle()!= null && calle.getNombreCalle()!="") {
					SET("nombre_calle = "+ "'".concat(calle.getNombreCalle()).concat("'"));
				} if(calle.getTipoCalle()!= null) {
					SET("tipo_calle = "+ "'".concat(calle.getTipoCalle().name()).concat("'"));
				}
				WHERE("calle_id = "+String.valueOf(calle.getCalleId()));
			}
		}}.toString();
	}
	
	public String delete(Calle calle)  throws SQLException {
			return new SQL() {{
				if(calle.getCalleId()!=null && calle.getCalleId() > 0) {
					DELETE_FROM("calle");
					WHERE("calle_id = " + String.valueOf(calle.getCalleId()));
				}
				else {
					throw new SQLException("calle_id no debe ser cero o null");
				}
			}}.toString();
	}
	
	public String select(Calle calle) {
		return new SQL() {{
			SELECT("calle_id, tipo_calle, nombre_calle");
			FROM("calle");
			if(calle != null) {
				if(calle.getCalleId()!= null && calle.getCalleId() >0) {
					WHERE("calle_id = " + String.valueOf(calle.getCalleId()));
				} else {
					if(calle.getNombreCalle()!= null && calle.getNombreCalle() !="") {
						WHERE("nombre_calle = " + "'".concat(calle.getNombreCalle()).concat("'"));
					}
					if(calle.getTipoCalle()!= null) {
						WHERE("tipo_calle = " + "'".concat(calle.getTipoCalle().name()).concat("'"));
					}
				}
			}
		}}.toString();
	}
	
}
