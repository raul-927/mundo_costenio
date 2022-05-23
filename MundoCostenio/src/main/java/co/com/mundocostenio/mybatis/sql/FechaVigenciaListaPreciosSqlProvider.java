package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import co.com.mundocostenio.domain.FechaVigenciaListaPrecios;

@Component("fechaVigenciaListaPreciosSqlProvider")
public class FechaVigenciaListaPreciosSqlProvider {
	
	public String insert(FechaVigenciaListaPrecios insert) {
		return new SQL() {{
			INSERT_INTO("fecha_vig_list_prec");
			if(insert.getFechaIni()!= null) {
				System.out.println("fechaIni: "+insert.getFechaIni());
				VALUES("fecha_ini","'".concat(insert.getFechaIni().toString()).concat("'"));
			}
			if(insert.getFechaFin()!= null) {
				VALUES("fecha_fin", "'".concat(insert.getFechaFin().toString()).concat("'"));
			}
		}}.toString();
	}
	
	
	public String selectFechaVigenciaById(int id) {
		return new SQL() {{
			SELECT("*");
			FROM("fecha_vig_list_prec");
			WHERE("id = " + String.valueOf(id));
		}}.toString();
	}

}
