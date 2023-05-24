package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Departamento;

public class DepartamentoSqlProvider {
	
	public String insert(Departamento departamento) {
		return new SQL() {{
			INSERT_INTO("departamento");
			if(departamento.getNombreDepartamento() != null && departamento.getNombreDepartamento() !="" ) {
				VALUES("nombre_departamento","'".concat(departamento.getNombreDepartamento()).concat("'"));
			}
			
		}}.toString();
	}
	
	public String update(Departamento departamento) {
		return new SQL() {{
			if(departamento.getDepartamentoId() > 0) {
				UPDATE("departamento");
				if(departamento.getNombreDepartamento() !=null && departamento.getNombreDepartamento()!="") {
					SET("nombre_departamento",departamento.getNombreDepartamento());
				}
				WHERE("id = " +departamento.getDepartamentoId());
			}
			
		}}.toString();
	}
	
	public String delete(Departamento departamento) {
		return new SQL() {{
			if(departamento!=null && departamento.getDepartamentoId()!=null && departamento.getDepartamentoId() > 0) {
				DELETE_FROM("departamento");
				WHERE("departamentoId = " + String.valueOf(departamento.getDepartamentoId()));
			}
		}}.toString();
	}
	
	public String select(Departamento departamento) {
		return new SQL() {{
			SELECT("departamento_id, nombre_departamento");
			FROM("departamento");
			
			if(departamento!= null && departamento.getDepartamentoId()!=null && departamento.getDepartamentoId() > 0) {
				WHERE("departamento_id = " + String.valueOf(departamento.getDepartamentoId()));
			}else {
				if(departamento.getNombreDepartamento()!=null && departamento.getNombreDepartamento()!="") {
					WHERE("nombre_departamento = " + "'".concat(departamento.getNombreDepartamento()).concat("'"));
				}
			}
		}}.toString();
	}
	
}
