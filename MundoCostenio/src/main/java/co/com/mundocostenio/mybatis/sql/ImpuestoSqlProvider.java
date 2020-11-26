package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Impuesto;


public class ImpuestoSqlProvider {
	
	public String insert(Impuesto impuesto) {
		return new SQL() {{
			INSERT_INTO("impuesto");
			if(impuesto.getImpuestoDesc()!=null && impuesto.getImpuestoDesc()!="") {
				VALUES("impuesto_desc", "'".concat(impuesto.getImpuestoDesc()).concat("'"));
			}
			if(impuesto.getImpuestoDescAbrv()!=null && impuesto.getImpuestoDescAbrv()!="") {
				VALUES("impuesto_desc_abrv", "'".concat(impuesto.getImpuestoDescAbrv().concat("'")));
			}
			if(impuesto.getTipoImpuesto()!=null) {
				VALUES("tipo_impuesto", "'".concat(impuesto.getTipoImpuesto().name()).concat("'"));
			}
			if(impuesto.getImpuestoValor()!=null) {
				VALUES("impuesto_valor", String.valueOf(impuesto.getImpuestoValor()));
			}
			if(impuesto.getCuenta()!=null) {
				VALUES("cuenta_id", String.valueOf(impuesto.getCuenta().getCuentaId()));
			}
		}}.toString();
	}
	
	public String update(Impuesto impuesto) {
		return new SQL() {{
			UPDATE("impuesto");
			if(impuesto.getImpuestoDesc()!=null && impuesto.getImpuestoDesc()!="") {
				SET("impuesto_desc = "+ "'".concat(impuesto.getImpuestoDesc()).concat("'"));
			}
			if(impuesto.getImpuestoDescAbrv()!=null && impuesto.getImpuestoDescAbrv()!="") {
				SET("impuesto_desc_abrv = "+ "'".concat(impuesto.getImpuestoDescAbrv().concat("'")));
			}
			if(impuesto.getTipoImpuesto()!=null) {
				SET("tipo_impuesto = "+ "'".concat(impuesto.getTipoImpuesto().name()).concat("'"));
			}
			if(impuesto.getImpuestoValor()!=null) {
				SET("impuesto_valor = "+ String.valueOf(impuesto.getImpuestoValor()));
			}
			if(impuesto.getCuenta()!=null) {
				SET("cuenta_id = "+ String.valueOf(impuesto.getCuenta().getCuentaId()));
			}
			WHERE("impuesto_id = " + String.valueOf(impuesto.getImpuestoId()));
		}}.toString();
	}
	
	public String delete(Impuesto impuesto) {
		return new SQL() {{
			DELETE_FROM("impuesto");
			WHERE("impuesto_id = " + String.valueOf(impuesto.getImpuestoId()));
		}}.toString();
	}
	
	public String select(Impuesto impuesto) {
		return new SQL() {{
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.tipo_impuesto");
			SELECT("c.cuenta_id, c.cuenta_desc, c.tipo_cuenta, c.cuenta_fecha, c.cuenta_hora, c.cuenta_usuario");
			SELECT("g.grupo_cuenta_id, g.tipo_grupo_cuenta, g.grupo_cuenta_desc");
			
			FROM("impuesto i");
			FROM("cuenta c");
			FROM("grupo_cuenta g");
			
			WHERE("i.cuenta_id = c.cuenta_id");
			WHERE("c.grupo_cuenta_id = g.grupo_cuenta_id");
			if(impuesto.getImpuestoId()> 0) {
				WHERE("i.impuesto_id = " + String.valueOf(impuesto.getImpuestoId()));
			}
			else {
				if(impuesto.getImpuestoDesc()!= null && impuesto.getImpuestoDesc()!="") {
					WHERE("i.impuesto_desc = " + "'".concat(impuesto.getImpuestoDesc()).concat("'"));
				}
				if(impuesto.getImpuestoDescAbrv() !=null && impuesto.getImpuestoDescAbrv()!="") {
					WHERE("i.impuesto_desc_abrv = " + "'".concat(impuesto.getImpuestoDescAbrv()).concat("'"));
				}
				if(impuesto.getImpuestoValor()!=null) {
					WHERE("i.impuesto_valor = " + String.valueOf(impuesto.getImpuestoValor()));
				}
				if(impuesto.getTipoImpuesto()!=null) {
					WHERE("i.tipo_impuesto = " + "'".concat(impuesto.getTipoImpuesto().name()).concat("'"));
				}
				if(impuesto.getCuenta()!=null && impuesto.getCuenta().getCuentaId() > 0) {
					WHERE("i.cuenta_id = " + String.valueOf(impuesto.getCuenta().getCuentaId()));
				}
				else if(impuesto.getCuenta()!=null && impuesto.getCuenta().getCuentaDesc()!=null && impuesto.getCuenta().getCuentaDesc()!="") {
					WHERE("c.cuenta_desc= " + "'".concat(impuesto.getCuenta().getCuentaDesc()).concat("'"));
				}
			}
			
		}}.toString();
	}
}