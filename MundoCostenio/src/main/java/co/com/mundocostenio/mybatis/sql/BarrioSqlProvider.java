package co.com.mundocostenio.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Barrio;


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
			UPDATE("barrio");
			if(barrio.getNombreBarrio() != null && barrio.getNombreBarrio() !="") {
				SET("nombre_barrio", barrio.getNombreBarrio());
			}
			WHERE("barrio_id = "+barrio.getBarrioId());
		}}.toString();
	}
	
	public String delete(Barrio barrio) {
		return new SQL() {{
			if(barrio.getBarrioId() >0) {
				DELETE_FROM("barrio");
				WHERE("id = "+barrio.getBarrioId());
			}else if(barrio.getNombreBarrio() != null && barrio.getNombreBarrio() !="") {
				DELETE_FROM("barrio");
				WHERE("nombre_barrio", barrio.getNombreBarrio());
			}
		}}.toString();
	}
	
	public String showBarrio(Map<String,Object>map) {
		int id = Integer.parseInt(map.get("id").toString());
		String nombreBarrio = map.get("nombreBarrio").toString();
		return new SQL() {{
			SELECT("*");
			FROM("barrio");
			if( id > 0) {
				WHERE("id = "+id);
			}
			if(nombreBarrio !=null && nombreBarrio !=""){
				WHERE("nombre_barrio = "+nombreBarrio);
			}
			
		}}.toString();
	}
	
}
