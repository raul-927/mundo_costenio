package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Cuenta;


public class CuentaSqlProvider {
	
	public String insert(Cuenta cuenta) {
		String query = new SQL() {{
			INSERT_INTO("cuenta");
			if(cuenta.getCuentaDesc()!=null && cuenta.getCuentaDesc()!="") {
				VALUES("cuenta_desc", "'".concat(cuenta.getCuentaDesc()).concat("'"));
			}
			if(cuenta.getTipoCuenta()!=null) {
				VALUES("tipo_cuenta", "'".concat(cuenta.getTipoCuenta().name()).concat("'"));
			}
			if(cuenta.getCuentaFecha()!=null) {
				VALUES("cuenta_fecha", "'".concat(cuenta.getCuentaFecha().toString()).concat("'"));
			}
			if(cuenta.getCuentaHora() !=null) {
				VALUES("cuenta_hora", "'".concat(cuenta.getCuentaHora().toString()).concat("'"));
			}
			if(cuenta.getCuentaUsuario()!=null && cuenta.getCuentaUsuario()!="") {
				VALUES("cuenta_usuario", "'".concat(cuenta.getCuentaUsuario()).concat("'"));
			}
			if(cuenta.getGrupoCuenta()!=null) {
				if(cuenta.getGrupoCuenta().getGrupoCuentaId() != null && cuenta.getGrupoCuenta().getGrupoCuentaId() > 0) {
					VALUES("grupo_cuenta_id", String.valueOf(cuenta.getGrupoCuenta().getGrupoCuentaId()));
				}
			}
		}}.toString();
		System.out.println(query);
		return query;
	}
	
	public String update(Cuenta cuenta) {
		return new SQL() {{
			UPDATE("cuenta");
			if(cuenta.getCuentaDesc()!=null && cuenta.getCuentaDesc()!="") {
				SET("cuenta_desc = "+ "'".concat(cuenta.getCuentaDesc()).concat("'"));
			}
			if(cuenta.getCuentaFecha()!=null) {
				SET("cuenta_fecha = "+ "'".concat(cuenta.getCuentaFecha().toString()).concat("'"));
			}
			if(cuenta.getCuentaHora() !=null) {
				SET("cuenta_hora = "+ "'".concat(cuenta.getCuentaHora().toString()).concat("'"));
			}
			if(cuenta.getCuentaUsuario()!=null && cuenta.getCuentaUsuario()!="") {
				SET("cuenta_usuario = "+ "'".concat(cuenta.getCuentaUsuario()).concat("'"));
			}
			if(cuenta.getGrupoCuenta()!=null) {
				if(cuenta.getGrupoCuenta().getGrupoCuentaId() > 0) {
					SET("grupo_cuenta_id = "+ String.valueOf(cuenta.getGrupoCuenta().getGrupoCuentaId()));
				}
			}
			WHERE("cuenta_id = " + String.valueOf(cuenta.getCuentaId()));
		}}.toString();
	}
	
	public String delete(Cuenta cuenta) {
		return new SQL() {{
			if(cuenta !=null) {
				DELETE_FROM("cuenta");
				WHERE("cuenta_id = " + String.valueOf(cuenta.getCuentaId()));
			}
		}}.toString();
	}
	
	public String select(Cuenta cuenta) {
		return new SQL() {{
			SELECT("c.cuenta_id, c.cuenta_desc, c.tipo_cuenta, c.cuenta_fecha, c.cuenta_hora, c.cuenta_usuario");
			SELECT("g.grupo_cuenta_id, g.tipo_grupo_cuenta, g.grupo_cuenta_desc");
			FROM("cuenta c");
			FROM("grupo_cuenta g");
			WHERE("c.grupo_cuenta_id = g.grupo_cuenta_id");
			if(cuenta != null) {
				if(cuenta.getCuentaId()!=null && cuenta.getCuentaId() > 0) {
					WHERE("c.cuenta_id = " + String.valueOf(cuenta.getCuentaId()));
				}
				else {
					if(cuenta.getCuentaDesc()!=null && cuenta.getCuentaDesc()!="") {
						WHERE("c.cuenta_desc = " +"'".concat(cuenta.getCuentaDesc()).concat("'"));
					}
					if(cuenta.getTipoCuenta()!=null) {
						WHERE("c.tipo_cuenta = " + "'".concat(cuenta.getTipoCuenta().name()).concat("'"));
					}
					if(cuenta.getCuentaFecha()!=null) {
						WHERE("c.cuenta_fecha = " + "'".concat(cuenta.getCuentaFecha().toString()).concat("'"));
					}
					if(cuenta.getCuentaHora()!=null) {
						WHERE("c.cuenta_hora = " + "'".concat(cuenta.getCuentaHora().toString()).concat("'"));
					}
					if(cuenta.getCuentaUsuario()!=null && cuenta.getCuentaUsuario()!="") {
						WHERE("c.cuenta_usuario = " + "'".concat(cuenta.getCuentaUsuario()).concat("'"));
					}
					if(cuenta.getGrupoCuenta()!=null) {
						if(cuenta.getGrupoCuenta().getGrupoCuentaId() > 0) {
							WHERE("g.grupo_cuenta_id = " + String.valueOf(cuenta.getGrupoCuenta().getGrupoCuentaId()));
						}
						else {
							if(cuenta.getGrupoCuenta().getGrupoCuentaDesc()!=null && cuenta.getGrupoCuenta().getGrupoCuentaDesc()!="") {
								WHERE("g.grupo_cuenta_desc = " + "'".concat(cuenta.getGrupoCuenta().getGrupoCuentaDesc()).concat("'"));
							}
							if(cuenta.getGrupoCuenta().getTipoGrupoCuenta()!=null) {
								WHERE("g.tipo_grupo_cuenta = " + "'".concat(cuenta.getGrupoCuenta().getTipoGrupoCuenta().name()).concat("'"));
							}
						}
					}
				}
			}
		}}.toString();
	}
}