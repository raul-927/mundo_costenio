package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.Producto;

public class ProductoSqlProvider {
	
	public String insert(Producto producto) {
		
		return new SQL() {{
			INSERT_INTO("producto");
			if(producto.getNombre() != null) {
				VALUES("nombre", "'".concat(producto.getNombre()).concat("'"));
			}
			if(producto.getTipoProducto() !=null) {
				VALUES("tipo_prod_id", "'".concat(String.valueOf(producto.getTipoProducto().getTipProdId())).concat("'"));
			}
		}}.toString();
	}

}
