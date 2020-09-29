package co.com.mundocostenio.mybatis.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Departamento;

public class DepartamentoSqlProvider {
	
	public String insert(Departamento departamento) {
		return new SQL() {{
			INSERT_INTO("departamento");
			if(departamento.getNombreDepartamento() != null && departamento.getNombreDepartamento() !="" ) {
				VALUES("nombre_departamento",departamento.getNombreDepartamento());
			}
		}}.toString();
	}
	
	public String update(Departamento departamento) {
		return new SQL() {{
			UPDATE("departamento");
			if(departamento.getNombreDepartamento() !=null && departamento.getNombreDepartamento()!="") {
				SET("nombre_departamento",departamento.getNombreDepartamento());
			}
			WHERE("id = " +departamento.getDepartamentoId());
		}}.toString();
	}
	
	public String showAll() {
		return new SQL() {{
			SELECT("*");
			FROM("departamento");
		}}.toString();
	}
	
	public String showById(Map<String, Object>map) {
		String id = map.get("id").toString();
		
		return new SQL() {{
			SELECT("*");
			FROM("departamento");
			WHERE("id = "+id);
		}}.toString();
	}
	
}
