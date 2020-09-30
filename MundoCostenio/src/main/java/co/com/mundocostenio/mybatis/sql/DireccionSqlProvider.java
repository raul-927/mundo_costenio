package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Direccion;

public class DireccionSqlProvider {
	
	public String insert(Direccion direccion) {
		return new SQL() {{
			INSERT_INTO("direccion");
			if(direccion.getDepartamento()!=null) {
				VALUES("departamento_id", String.valueOf(direccion.getDepartamento().getDepartamentoId()));
			}
			
		}}.toString();
	}
	
	public String update(Direccion direccion) {
		return new SQL() {{
			UPDATE("direccion");
			if(direccion.getDepartamento().getDepartamentoId() >0) {
				SET("departamento_id", String.valueOf(direccion.getDepartamento().getDepartamentoId()));
			}
			WHERE("direccion_id = "+"'".concat(String.valueOf(direccion.getDireccionId())).concat("'"));
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			DELETE_FROM("direccion");
			WHERE("direccion_id = "+String.valueOf(id));
		}}.toString();
	}
	
	public String select(Direccion direccion) {
		return new SQL() {{
			SELECT("*");
			FROM("direccion");
			if(direccion.getDireccionId() >0) {
				WHERE("id ="+direccion.getDireccionId());
			}
		}}.toString();
	}
	
}
