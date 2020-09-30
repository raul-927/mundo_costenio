package co.com.mundocostenio.mybatis.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Barrio;
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
	
	public String insertDepartamentoBarrio(int departamentoId, List<Barrio>barrios) {
		return new SQL() {{
			INSERT_INTO("departamento_barrio");
			INTO_COLUMNS("departamento_id", "barrio_id");
			for(Barrio barrio: barrios) {
				INTO_VALUES(String.valueOf(departamentoId), String.valueOf(barrio.getBarrioId()));
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
	
	public String delete(int departamentoId) {
		return new SQL() {{
			if(departamentoId > 0) {
				DELETE_FROM("departamento");
				WHERE("departamentoId = " + String.valueOf(departamentoId));
			}
		}}.toString();
	}
	
	public String select(Departamento departamento) {
		return new SQL() {{
			SELECT("d.departamento_id, d.nombre_departamento");
			SELECT("b.barrio_id, b.nombre_barrio");
			SELECT("u.ubicacion_id, u.nro_puerta, u.geo_localizacion");
			SELECT("c.calle_id, c.tipo_calle, c.nombre_calle");
			
			FROM("departamento d");
			FROM("barrio b");
			FROM("ubicacion u");
			FROM("calle c");
			FROM("departamento_barrio db");
			FROM("ubicacion_calle ubc");
			
			WHERE("d.departamento_id = db.departamento_id");
			WHERE("db.barrio_id = b.barrio_id");
			WHERE("b.ubicacion_id = u.ubicacion_id");
			WHERE("b.ubicacion_id = u.ubicacion_id");
			WHERE("u.ubicacion_id= ubc.ubicacion_id");
			WHERE("ubc.calle_id = c.calle_id");
			
			if(departamento.getDepartamentoId() > 0) {
				WHERE("d.departamento_id = " + String.valueOf(departamento.getDepartamentoId()));
			}else {
				if(departamento.getNombreDepartamento()!=null && departamento.getNombreDepartamento()!="") {
					WHERE("d.nombre_departamento = " + "'".concat(departamento.getNombreDepartamento()).concat("'"));
				}
				
			}
		}}.toString();
	}
	
}
