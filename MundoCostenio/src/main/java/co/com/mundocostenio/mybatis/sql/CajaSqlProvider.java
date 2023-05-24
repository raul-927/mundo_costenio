package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Caja;


public class CajaSqlProvider {
	
	public String insert(Caja caja) {
		return new SQL() {{
			INSERT_INTO("caja");
			if(caja.getCajaFecha()!=null) {
				VALUES("caja_fecha", String.valueOf(caja.getCajaFecha()));
			}
			if(caja.getCajaHora()!=null) {
				VALUES("caja_hora", String.valueOf(caja.getCajaHora()));
			}
			if(caja.getEstado()!=null) {
				VALUES("estado", "'".concat(caja.getEstado().name()).concat("'"));
			}
			if(caja.getCajaUsr()!=null && caja.getCajaUsr()!="") {
				VALUES("caja_usr", "'".concat(caja.getCajaUsr()).concat("'"));
			}
			
		}}.toString();
	}
	public String update(Caja caja) {
		return new SQL() {{
			UPDATE("caja");
			if(caja.getCajaFecha()!=null) {
				SET("caja_fecha = "+ String.valueOf(caja.getCajaFecha()));
			}
			if(caja.getCajaHora()!=null) {
				SET("caja_hora = "+ String.valueOf(caja.getCajaHora()));
			}
			if(caja.getEstado()!=null) {
				SET("estado = " +"'".concat(caja.getEstado().name()).concat("'"));
			}
			if(caja.getCajaUsr()!=null && caja.getCajaUsr()!="") {
				SET("caja_usr = " +"'".concat(caja.getCajaUsr()).concat("'"));
			}
			WHERE("caja_id = " +String.valueOf(caja.getCajaId()));
			
		}}.toString();
	}
	
	public String select(Caja caja) {
		return new SQL() {{
			SELECT("caja_id, estado, caja_fecha, caja_hora, caja_usr");
			FROM("caja");
			if(caja.getCajaId() > 0) {
				WHERE("caja_id = " + String.valueOf(caja.getCajaId()));
			}
			else {
				if(caja.getCajaFecha()!=null) {
					WHERE("caja_fecha = " + String.valueOf(caja.getCajaFecha()));
				}
				if(caja.getCajaHora()!=null) {
					WHERE("caja_hora = " + String.valueOf(caja.getCajaHora()));
				}
				if(caja.getCajaUsr()!=null && caja.getCajaUsr()!="") {
					WHERE("caja_usr = " + "'".concat(caja.getCajaUsr()).concat("'"));
				}
			}
			
			
			
		}}.toString();
	}
	
	public String cargoCajaActual(){
		return new SQL(){{
			SELECT("caja_id, caja_estado, caja_fecha, caja_hora, caja_usr");
			FROM("caja"); 
			WHERE("caja_id = ("+selectMaxIdCaja()+")");
		}}.toString();
	}
	private String selectMaxIdCaja(){
		return new SQL(){{
			SELECT("MAX(caja_id)");
			FROM("caja");
		}}.toString();
	}
}