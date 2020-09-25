package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Direccion;

public class DireccionSqlProvider {
	
	public String insert(List<Direccion> direcciones, int idPersona) {
		return new SQL() {{
			INSERT_INTO("direccion");
			
			for(Direccion direccion:direcciones) {
			
				VALUES("departamento_id", String.valueOf(direccion.getDepartamento().getId()));
			}
			
		}}.toString();
	}
	
	public String update(Direccion direccion) {
		return new SQL() {{
			UPDATE("direccion");
			if(direccion.getDepartamento().getId() >0) {
				SET("departamento_id", String.valueOf(direccion.getDepartamento().getId()));
			}
			WHERE("id = "+"'".concat(String.valueOf(direccion.getId())).concat("'"));
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			DELETE_FROM("direccion");
			WHERE("id = "+String.valueOf(id));
		}}.toString();
	}
	
	public String showDireccion(Direccion direccion) {
		return new SQL() {{
			SELECT("*");
			FROM("direccion");
			if(direccion.getId() >0) {
				WHERE("id ="+direccion.getId());
			}
		}}.toString();
	}
	
}
