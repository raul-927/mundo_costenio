package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.GrupoCuenta;


public class GrupoCuentaSqlProvider {
	
	public String insert(GrupoCuenta grupoCuenta) {
		String sql = new SQL() {{
			if(grupoCuenta !=null) {
				INSERT_INTO("grupo_cuenta");
				if(grupoCuenta.getGrupoCuentaDesc()!= null && grupoCuenta.getGrupoCuentaDesc()!="") {
					VALUES("grupo_cuenta_desc", "'".concat(grupoCuenta.getGrupoCuentaDesc()).concat("'"));
				}
				if(grupoCuenta.getTipoGrupoCuenta()!=null) {
					VALUES("tipo_grupo_cuenta", "'".concat(grupoCuenta.getTipoGrupoCuenta().name()).concat("'"));
				}
			}
		}}.toString();
		return sql;
	}
	
	public String update(GrupoCuenta grupoCuenta) {
		String sql = new SQL() {{
			if(grupoCuenta !=null) {
				UPDATE("grupo_cuenta");
				if(grupoCuenta.getGrupoCuentaDesc()!= null && grupoCuenta.getGrupoCuentaDesc()!="") {
					SET("grupo_cuenta_desc = " +  "'".concat(grupoCuenta.getGrupoCuentaDesc()).concat("'"));
				}
				if(grupoCuenta.getTipoGrupoCuenta()!=null) {
					SET("tipo_grupo_cuenta = "+ "'".concat(grupoCuenta.getTipoGrupoCuenta().name()).concat("'"));
				}
				WHERE("grupo_cuenta_id = " + String.valueOf(grupoCuenta.getGrupoCuentaId()));
			}
		}}.toString();
		return sql;
	}
	
	public String delete(GrupoCuenta grupoCuenta) {
		return new SQL() {{
			if(grupoCuenta!=null) {
				if(grupoCuenta.getGrupoCuentaId() > 0) {
					DELETE_FROM("grupo_cuenta");
					WHERE("grupo_cuenta_id = " + String.valueOf(grupoCuenta.getGrupoCuentaId()));
				}
			}
		}}.toString();
	}
	
	public String select(GrupoCuenta grupoCuenta) {
		return new SQL() {{
			SELECT("grupo_cuenta_id, tipo_grupo_cuenta, grupo_cuenta_desc");
			FROM("grupo_cuenta");
			if(grupoCuenta !=null) {
				if(grupoCuenta.getGrupoCuentaId() > 0) {
					WHERE("grupo_cuenta_id = " + String.valueOf(grupoCuenta.getGrupoCuentaId()));
				}else {
					if(grupoCuenta.getGrupoCuentaDesc()!=null && grupoCuenta.getGrupoCuentaDesc()!="") {
						WHERE("grupo_cuenta_desc = " + "'".concat(grupoCuenta.getGrupoCuentaDesc()).concat("'"));
					}
					if(grupoCuenta.getTipoGrupoCuenta()!=null) {
						WHERE("tipo_grupo_cuenta = " + "'".concat(grupoCuenta.getTipoGrupoCuenta().name()).concat("'"));
					}
				}
			}
		}}.toString();
	}
}