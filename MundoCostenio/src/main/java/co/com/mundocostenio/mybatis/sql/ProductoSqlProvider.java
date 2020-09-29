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
			if(producto.getNombre() != null && producto.getNombre()!="") {
				SET("nombre", "'".concat(producto.getNombre()).concat("'"));
			}
			if(producto.getTipoProducto() !=null && producto.getTipoProducto().getTipProdId() > 0) {
				SET("tipo_prod_id", "'".concat(String.valueOf(producto.getTipoProducto().getTipProdId())).concat("'"));
			}
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{
			if(id > 0) {
				DELETE_FROM("producto");
				WHERE("prodId = " + id);
			}
			
		}}.toString();
	}
	
	public String selectProducto(Producto producto) {
		return new SQL() {{
			SELECT("p.prod_id, p.nombre");
			SELECT("t.tip_prod_id, t.descripcion");
			FROM("producto p");
			FROM("tipo_producto t");
			WHERE("p.tipo_prod_id = t.tipo_prod_id");
			if(producto.getProdId() > 0) {
				WHERE("prod_id = " + String.valueOf(producto.getProdId()));
			}
			else {
				if(producto.getNombre()!= null && producto.getNombre() !="") {
					WHERE("p.nombre = " + "'".concat(producto.getNombre()).concat("'"));
				}
				else {
					if(producto.getTipoProducto()!=null) {
						if(producto.getTipoProducto().getTipProdId() > 0) {
							WHERE("t.tip_prod_id = " + String.valueOf(producto.getTipoProducto().getTipProdId()));
						}else if(producto.getTipoProducto().getDescripcion()!=null && producto.getTipoProducto().getDescripcion()!=""){
							WHERE("t.descripcion = " + "'".concat(producto.getTipoProducto().getDescripcion()).concat("'"));
						}
					}
				}
			}
		}}.toString();
	}
}
