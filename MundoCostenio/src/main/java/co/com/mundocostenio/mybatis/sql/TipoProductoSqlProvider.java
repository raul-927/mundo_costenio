package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.TipoProducto;

public class TipoProductoSqlProvider {
	
	public String insert(TipoProducto tipoProducto) {
		
		return new SQL() {{
			INSERT_INTO("tipo_producto");
			if(tipoProducto.getTipProdId() > 0) {
				VALUES("id", "'".concat(String.valueOf(tipoProducto.getTipProdId())).concat("'"));
			}
			if(tipoProducto.getDescripcion()!= null) {
				VALUES("descripcion","'".concat(tipoProducto.getDescripcion()).concat("'"));
			}
			
		}}.toString();
	}
}
