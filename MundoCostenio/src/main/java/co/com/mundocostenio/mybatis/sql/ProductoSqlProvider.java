package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.Producto;

public class ProductoSqlProvider {
	
	public String insert(Producto producto) {
		return new SQL() {{
			INSERT_INTO("producto");
			if(producto.getNombre() != null) {
				VALUES("nombre", "'".concat(producto.getNombre()).concat("'"));
			}
			if(producto.getTipoProducto() !=null) {
				VALUES("tipo_producto_id", "'".concat(String.valueOf(producto.getTipoProducto().getTipProdId())).concat("'"));
			}
			if(producto.getImpuesto()!=null && producto.getImpuesto().getImpuestoId() > 0) {
				VALUES("impuesto_id", String.valueOf(producto.getImpuesto().getImpuestoId()));
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
	
	public String delete(Producto producto) {
		return new SQL() {{
			if(producto.getProdId() > 0) {
				DELETE_FROM("producto");
				WHERE("prodId = " + producto.getProdId());
			}
			
		}}.toString();
	}
	
	public String selectProducto(Producto producto) {
		return new SQL() {{
			SELECT("p.producto_id, p.nombre");
			SELECT("t.tipo_producto_id, t.desc_tipo_producto");
			SELECT("ct.cuenta_id, ct.cuenta_desc, ct.tipo_cuenta, ct.cuenta_fecha, ct.cuenta_hora, ct.cuenta_usuario");
			SELECT("gct.grupo_cuenta_id, gct.tipo_grupo_cuenta, gct.grupo_cuenta_desc");
			SELECT("i.impuesto_id, i.impuesto_desc, i.impuesto_desc_abrv, i.impuesto_valor, i.tipo_impuesto");
			SELECT("ci.cuenta_id, ci.cuenta_desc, ci.tipo_cuenta, ci.cuenta_fecha, ci.cuenta_hora, ci.cuenta_usuario");
			SELECT("gci.grupo_cuenta_id, gci.tipo_grupo_cuenta, gci.grupo_cuenta_desc");
			
			FROM("producto p");
			FROM("tipo_producto t");
			FROM("cuenta ct");
			FROM("grupo_cuenta gct");
			FROM("impuesto i");
			FROM("cuenta ci");
			FROM("grupo_cuenta gci");
			
			WHERE("p.tipo_producto_id = t.tipo_producto_id");
			WHERE("t.cuenta_id = ct.cuenta_id");
			WHERE("ct.grupo_cuenta_id = gct.grupo_cuenta_id");
			WHERE("p.impuesto_id = i.impuesto_id");
			WHERE("i.cuenta_id = ci.cuenta_id");
			WHERE("ci.grupo_cuenta_id = gci.grupo_cuenta_id");
			
			if(producto.getProdId()!=null && producto.getProdId() > 0) {
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
						}else if(producto.getTipoProducto().getDescTipoProducto()!=null && producto.getTipoProducto().getDescTipoProducto()!=""){
							WHERE("t.descripcion = " + "'".concat(producto.getTipoProducto().getDescTipoProducto()).concat("'"));
						}
					}
				}
			}
		}}.toString();
	}
}
