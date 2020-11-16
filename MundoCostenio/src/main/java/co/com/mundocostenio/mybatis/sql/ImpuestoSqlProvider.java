package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Barrio;
import co.com.mundocostenio.domain.Impuesto;


public class ImpuestoSqlProvider {
	
	public String insert(Impuesto impuesto) {
		return new SQL() {{
			INSERT_INTO("impuesto");
			if(impuesto.getImpuestoDesc()!=null && impuesto.getImpuestoDesc()!="") {
				
			}
			if(impuesto.getImpuestoDescAbrv()!=null && impuesto.getImpuestoDescAbrv()!="") {
				
			}
			if(impuesto.getTipoImpuesto()!=null) {
				
			}
			if(impuesto.getImpuestoValor()!=null) {
				
			}
			if(impuesto.getCuenta()!=null) {
				
			}
		}}.toString();
	}
}