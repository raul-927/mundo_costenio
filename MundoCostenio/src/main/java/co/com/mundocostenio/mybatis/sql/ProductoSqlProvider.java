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
	
	public String update(Producto producto) {
		return new SQL() {{
			UPDATE("producto");
			if(producto.getNombre() != null) {
				SET("nombre", "'".concat(producto.getNombre()).concat("'"));
			}
			if(producto.getTipoProducto() !=null) {
				SET("tipo_prod_id", "'".concat(String.valueOf(producto.getTipoProducto().getTipProdId())).concat("'"));
			}
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			DELETE_FROM("producto");
			WHERE("prodId = " + id);
		}}.toString();
	}
	
	public String selectProducto(Producto producto) {
		return new SQL() {{
			
		}}.toString();
	}

}
