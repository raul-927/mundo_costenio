package co.com.mundocostenio.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Calle;

public class CalleSqlProvider {
	
	public String insert(Calle calle) {
		return new SQL() {{
			INSERT_INTO("calle");
			if(calle.getNombre()!= null) {
				VALUES("nombre", "'".concat(calle.getNombre()).concat("'"));
			}
			if(calle.getTipoCalle()!= null) {
				VALUES("tipo_calle", "'".concat(calle.getTipoCalle().getDescripcion()).concat("'"));
			}
		}}.toString();
	}
	public String update(Calle calle) {
		return new SQL() {{
			UPDATE("calle");
			if(calle.getNombre()!= null) {
				SET("nombre", calle.getNombre());
			} if(calle.getTipoCalle()!= null) {
				SET("tipo_calle", String.valueOf(calle.getTipoCalle()));
			}
			
			WHERE("id = "+calle.getCalleId());
		}}.toString();
	}
	
	public String delete(Calle calle) {
		return new SQL() {{
			if(calle.getCalleId() >0) {
				DELETE_FROM("calle");
				WHERE("id = "+"'".concat(String.valueOf(calle.getCalleId())).concat("'"));
			}
		}}.toString();
	}
	
	public String showCalle(Map<String,Object>map) {
		int id = Integer.parseInt(map.get("id").toString());
		String tipoCalle = map.get("tipoCalle").toString();
		String nombre = map.get("nombre").toString();
		return new SQL() {{
			SELECT("*");
			FROM("calle");
			if( id > 0) {
				WHERE("id = "+id);
			}else {
				if(tipoCalle !=null){
					WHERE("tipo_calle = "+"'".concat(tipoCalle).concat("'"));
				}
				if(nombre !=null){
					WHERE("nombre = "+"'".concat(nombre).concat("'"));
				}
			}
		}}.toString();
	}
	
}
