package co.com.mundocostenio.mybatis.sql;

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
			SELECT("d.departamento_id, d.nombre_departamento");
			
			FROM("barrio b");
			FROM("departamento d");
			
			WHERE("b.departamento_id = d.departamento_id");
			if( barrio.getBarrioId() > 0) {
				WHERE("barrio_id = "+ String.valueOf(barrio.getBarrioId()));
			}else {
				if(barrio.getNombreBarrio() !=null && barrio.getNombreBarrio() !=""){
					WHERE("nombre_barrio = " + "'".concat(barrio.getNombreBarrio()).concat("'"));
				}
			}
			if(barrio.getDepartamento()!=null) {
				if(barrio.getDepartamento().getNombreDepartamento()!=null && barrio.getDepartamento().getNombreDepartamento()!="") {
					WHERE("d.nombre_departamento = " + "'".concat(barrio.getDepartamento().getNombreDepartamento()).concat("'"));
				}
			}
			
			
		}}.toString();
	}
	
}
