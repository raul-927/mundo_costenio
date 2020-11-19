package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Asiento;

public class AsientoSqlProvider {
	
	public String insert(Asiento asiento) {
		return new SQL() {{
			INSERT_INTO("asiento");
			if(asiento.getCaja()!=null && asiento.getCaja().getCajaId() > 0) {
				VALUES("caja_id", String.valueOf(asiento.getCaja().getCajaId()));
			}
			if(asiento.getCuentaDebe()!=null && asiento.getCuentaDebe().getCuentaId() > 0) {
				VALUES("cuenta_debe_id", String.valueOf(asiento.getCuentaDebe().getCuentaId()));
			}
			if(asiento.getCuentaHaber()!=null && asiento.getCuentaHaber().getCuentaId() > 0) {
				VALUES("cuenta_haber_id", String.valueOf(asiento.getCuentaHaber().getCuentaId()));
			}
			if(asiento.getDescripcion()!=null && asiento.getDescripcion()!="") {
				VALUES("descripcion", "'".concat(asiento.getDescripcion()).concat("'"));
			}
			if(asiento.getFecha()!=null) {
				VALUES("fecha", String.valueOf(asiento.getFecha()));
			}
			if(asiento.getHora()!=null) {
				VALUES("hora", String.valueOf(asiento.getHora()));
			}
			if(asiento.getMontoDebe()!=null) {
				VALUES("monto_debe", String.valueOf(asiento.getMontoDebe()));
			}
			if(asiento.getMontoHaber()!=null) {
				VALUES("monto_haber", String.valueOf(asiento.getMontoHaber()));
			}
		}}.toString();
	}
	
	public String update(Asiento asiento) {
		return new SQL() {{
			UPDATE("asiento");
			if(asiento.getCaja()!=null && asiento.getCaja().getCajaId() > 0) {
				SET("caja_id = "+ String.valueOf(asiento.getCaja().getCajaId()));
			}
			if(asiento.getCuentaDebe()!=null && asiento.getCuentaDebe().getCuentaId() > 0) {
				SET("cuenta_debe_id = "+ String.valueOf(asiento.getCuentaDebe().getCuentaId()));
			}
			if(asiento.getCuentaHaber()!=null && asiento.getCuentaHaber().getCuentaId() > 0) {
				SET("cuenta_haber_id = "+ String.valueOf(asiento.getCuentaHaber().getCuentaId()));
			}
			if(asiento.getDescripcion()!=null && asiento.getDescripcion()!="") {
				SET("descripcion = "+ "'".concat(asiento.getDescripcion()).concat("'"));
			}
			if(asiento.getFecha()!=null) {
				SET("fecha = "+ String.valueOf(asiento.getFecha()));
			}
			if(asiento.getHora()!=null) {
				SET("hora = "+ String.valueOf(asiento.getHora()));
			}
			if(asiento.getMontoDebe()!=null) {
				SET("monto_debe = "+ String.valueOf(asiento.getMontoDebe()));
			}
			if(asiento.getMontoHaber()!=null) {
				SET("monto_haber = "+ String.valueOf(asiento.getMontoHaber()));
			}
			WHERE("asiento_id = " + String.valueOf(asiento.getAsientoId()));
		}}.toString();
	}
	
	public String select(Asiento asiento) {
		return new SQL() {{
			SELECT("a.asiento_id, a.descripcion, a.monto_debe, a.monto_haber, a.fecha, a.hora");
			SELECT("cd.cuenta_id, cd.cuenta_desc, cd.tipo_cuenta, cd.cuenta_fecha, cd.cuenta_hora, cd.cuenta_usuario");
			SELECT("ch.cuenta_id, ch.cuenta_desc, ch.tipo_cuenta, ch.cuenta_fecha, ch.cuenta_hora, ch.cuenta_usuario");
			SELECT("gd.grupo_cuenta_id, gd.tipo_grupo_cuenta, gd.grupo_cuenta_desc");
			SELECT("gh.grupo_cuenta_id, gh.tipo_grupo_cuenta, gh.grupo_cuenta_desc");
			SELECT("ca.caja_id, ca.estado, ca.cajaFecha, ca.cajaHora, ca.cajaUsr");
			
			FROM("asiento a");
			FROM("cuenta cd");
			FROM("cuenta ch");
			FROM("grupo_cuenta gd");
			FROM("grupo_cuenta gh");
			FROM("caja ca");
			
			WHERE("a.cuenta_debe_id   = cd.cuenta_id");
			WHERE("a.cuenta_haber_id  = ch_cuenta_id");
			WHERE("cd.grupo_cuenta_id = gd.grupo_cuenta_id");
			WHERE("ch.grupo_cuenta_id = gh.grupo_cuenta_id");
			WHERE("a.caja_id = ca.caja_id");
			
			if(asiento.getAsientoId() >0) {
				WHERE("a.asiento_id = " +String.valueOf(asiento.getAsientoId()));
			}
			else {
				if(asiento.getDescripcion()!=null && asiento.getDescripcion()!="") {
					WHERE("a.descripcion = " + "'".concat(asiento.getDescripcion()).concat("'"));
				}
				if(asiento.getCaja()!=null && asiento.getCaja().getCajaId() > 0) {
					WHERE("a.caja_id = " +String.valueOf(asiento.getCaja().getCajaId()));
				}
				if(asiento.getCuentaDebe()!=null && asiento.getCuentaDebe().getCuentaId()> 0) {
					WHERE("a.cuenta_debe_id = " + String.valueOf(asiento.getCuentaDebe().getCuentaId()));
				}
				if(asiento.getCuentaHaber()!=null && asiento.getCuentaHaber().getCuentaId()> 0) {
					WHERE("a.cuenta_haber_id = " + String.valueOf(asiento.getCuentaHaber().getCuentaId()));
				}
				if(asiento.getFecha()!=null) {
					WHERE("a.fecha = " +String.valueOf(asiento.getFecha()));
				}
				if(asiento.getHora()!=null) {
					WHERE("a.hora = " +String.valueOf(asiento.getHora()));
				}
				if(asiento.getMontoDebe()!=null) {
					WHERE("a.monto_debe = " + String.valueOf(asiento.getMontoDebe()));
				}
				if(asiento.getMontoHaber()!=null) {
					WHERE("a.monto_haber = " +String.valueOf(asiento.getMontoHaber()));
				}
			}
		}}.toString();
	}
}
