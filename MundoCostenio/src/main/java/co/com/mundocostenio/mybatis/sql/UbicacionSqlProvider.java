package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Ubicacion;


public class UbicacionSqlProvider {
	
	public String insert(Ubicacion ubicacion) {
		return new SQL() {{
			INSERT_INTO("ubicacion");
			if(ubicacion.getNroPuerta() >0) {
				VALUES("nro_puerta", String.valueOf(ubicacion.getNroPuerta()));
			}
			if(ubicacion.getGeoLocalizacion()!= null && ubicacion.getGeoLocalizacion()!="") {
				VALUES("geo_localizacion", "'".concat(ubicacion.getGeoLocalizacion()).concat("'"));
			}
		}}.toString();
	}
	public String update(Ubicacion ubicacion) {
		return new SQL() {{
			if(ubicacion.getUbicacionId() > 0) {
				UPDATE("ubicacion");
				if(ubicacion.getNroPuerta() >0) {
					SET("nro_puerta", String.valueOf(ubicacion.getNroPuerta()));
				}
				if(ubicacion.getGeoLocalizacion()!= null) {
					SET("geo_localizacion", "'".concat(ubicacion.getGeoLocalizacion()).concat("'"));
				}
				WHERE("ubicacion_id = "+ String.valueOf(ubicacion.getUbicacionId()));
			}
		}}.toString();
	}
	
	public String delete(Ubicacion ubicacion) {
		return new SQL() {{
			if(ubicacion !=null && ubicacion.getUbicacionId()!=null && ubicacion.getUbicacionId()>0) {
				DELETE_FROM("ubicacion");
				WHERE("ubicacion_id = "+String.valueOf(ubicacion.getUbicacionId()));
			}
		}}.toString();
	}
	
	public String select(Ubicacion ubicacion) {
		
		return new SQL() {{
			SELECT("u.ubicacion_id, u.nro_puerta, u.geo_localizacion");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			FROM("ubicacion u");
			FROM("calle c");
			FROM("ubicacion_calle ubc");
			WHERE("u.ubicacion_id= ubc.ubicacion_id");
			WHERE("ubc.calle_id = c.calle_id");
			if(ubicacion != null) {
				if(ubicacion.getUbicacionId() > 0) {
					WHERE("u.ubicacion_id = " + String.valueOf(ubicacion.getUbicacionId()));
				}else {
					if(ubicacion.getGeoLocalizacion()!= null && ubicacion.getGeoLocalizacion()!="") {
						WHERE("u.geo_localizacion = " + "'".concat(ubicacion.getGeoLocalizacion()).concat("'"));
					}
					if(ubicacion.getNroPuerta() > 0) {
						WHERE("u.nro_puerta = " + String.valueOf(ubicacion.getNroPuerta()));
					}
					
				}
			}
		}}.toString();
	}
	
}
