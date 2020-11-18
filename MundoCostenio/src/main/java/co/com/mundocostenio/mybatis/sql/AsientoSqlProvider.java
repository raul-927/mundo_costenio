package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Asiento;

public class AsientoSqlProvider {
	
	public String insert(Asiento asiento) {
		return new SQL() {{
			INSERT_INTO("asiento");
			if(asiento.getCaja()!=null && asiento.getCaja().getCajaId() > 0) {
				
			}
			VALUES("", "");
		}}.toString();
	}

}
