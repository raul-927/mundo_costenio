package co.com.mundocostenio.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Calle;
import co.com.mundocostenio.domain.Ubicacion;


public class UbicacionSqlProvider {
	
	public String insert(Ubicacion ubicacion) {
		return new SQL() {{
			INSERT_INTO("ubicacion");
			
			if(ubicacion.getCalle1() != null) {
				VALUES("id_calle_1", String.valueOf(ubicacion.getCalle1().getCalleId()));
			}
			if(ubicacion.getCalle2() != null) {
				VALUES("id_calle_2", String.valueOf(ubicacion.getCalle2().getCalleId()));
			}
			if(ubicacion.getNroPuerta() >0) {
				VALUES("nro_puerta", String.valueOf(ubicacion.getNroPuerta()));
			}
			if(ubicacion.getGeoLocalizacion()!= null) {
				VALUES("geo_localizacion", ubicacion.getGeoLocalizacion());
			}
		}}.toString();
	}
	public String update(Ubicacion ubicacion) {
		return new SQL() {{
			UPDATE("ubicacion");
			if(ubicacion.getCalle1() != null) {
				SET("id_calle_1", String.valueOf(ubicacion.getCalle1().getCalleId()));
			}
			if(ubicacion.getCalle2() != null) {
				SET("id_calle_2", String.valueOf(ubicacion.getCalle2().getCalleId()));
			}
			if(ubicacion.getNroPuerta() >0) {
				SET("nro_puerta", String.valueOf(ubicacion.getNroPuerta()));
			}
			if(ubicacion.getGeoLocalizacion()!= null) {
				SET("geo_localizacion", ubicacion.getGeoLocalizacion());
			}
			WHERE("id = "+ubicacion.getUbicacionId());
		}}.toString();
	}
	
	public String delete(Ubicacion ubicacion) {
		return new SQL() {{
			if(ubicacion.getUbicacionId() >0) {
				DELETE_FROM("ubicacion");
				WHERE("id = "+ubicacion.getUbicacionId());
			}
		}}.toString();
	}
	
	public String showUbicacion(Map<String,Object>map) {
		int id = Integer.parseInt(map.get("id").toString());
		String geoLocalizacion = map.get("geoLocalizacion").toString();
		Calle calle1 = (Calle) map.get("calle1");
		Calle calle2 = (Calle) map.get("calle2");
		return new SQL() {{
			SELECT("*");
			FROM("ubicacion");
			if( id > 0) {
				WHERE("id = "+id);
			}
			if(calle1 !=null){
				WHERE("id_calle_1 = "+"'".concat(String.valueOf(calle1.getCalleId())).concat("'"));
			}
			if(calle2 !=null){
				WHERE("id_calle_2 = "+calle2.getCalleId());
			}
			if(geoLocalizacion !=null && geoLocalizacion !=""){
				WHERE("geo_localizacion = "+geoLocalizacion);
			}
		}}.toString();
	}
	
}
