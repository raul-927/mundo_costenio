package co.com.mundocostenio.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.Calle;


public class BarrioSqlProvider {
	
	public String insert(Barrio barrio) {
		return new SQL() {{
			INSERT_INTO("barrio");
			
			if(barrio.getNombreBarrio() != null && barrio.getNombreBarrio() !="") {
				VALUES("nombre_barrio", barrio.getNombreBarrio());
			}
		}}.toString();
	}
	public String update(Barrio barrio) {
		return new SQL() {{
			if(barrio.getBarrioId() > 0) {
				UPDATE("barrio");
				if(barrio.getNombreBarrio() != null && barrio.getNombreBarrio() !="") {
					SET("nombre_barrio", "'".concat(barrio.getNombreBarrio()).concat("'"));
				}
				WHERE("barrio_id = "+ String.valueOf(barrio.getBarrioId()));
			}
			
		}}.toString();
	}
	
	public String delete(int barrioId) {
		return new SQL() {{
			if(barrioId >0) {
				DELETE_FROM("barrio");
				WHERE("barrio_id = "+barrioId);
			}
		}}.toString();
	}
	
	public String select(Barrio barrio) {
		return new SQL() {{
			SELECT("b.barrio_id, b.nombre_barrio");
			SELECT("u.ubicacion_id, u.nro_puerta, u.geo_localizacion");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			
			FROM("barrio b");
			FROM("ubicacion u");
			FROM("calle c");
			FROM("ubicacion_calle ubc");
			
			WHERE("b.ubicacion_id = u.ubicacion_id");
			WHERE("u.ubicacion_id= ubc.ubicacion_id");
			WHERE("ubc.calle_id = c.calle_id");
			
			if( barrio.getBarrioId() > 0) {
				WHERE("barrio_id = "+ String.valueOf(barrio.getBarrioId()));
			}else {
				if(barrio.getNombreBarrio() !=null && barrio.getNombreBarrio() !=""){
					WHERE("nombre_barrio = " + "'".concat(barrio.getNombreBarrio()).concat("'"));
				}
			}
			
			
		}}.toString();
	}
	
}
