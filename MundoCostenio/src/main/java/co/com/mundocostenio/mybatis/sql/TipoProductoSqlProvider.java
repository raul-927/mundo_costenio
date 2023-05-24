package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.model.TipoProducto;

public class TipoProductoSqlProvider {
	
	public String insert(TipoProducto tipoProducto) {
		return new SQL() {{
			if(tipoProducto.getDescTipoProducto()!= null && tipoProducto.getDescTipoProducto() !="") {
				INSERT_INTO("tipo_producto");
				VALUES("desc_tipo_producto","'".concat(tipoProducto.getDescTipoProducto()).concat("'"));
				VALUES("cuenta_id", String.valueOf(tipoProducto.getCuenta().getCuentaId()));
			}
			
		}}.toString();
	}
	
	public String update(TipoProducto tipoProducto) {
		return new SQL() {{
			if(tipoProducto.getDescTipoProducto()!= null && tipoProducto.getDescTipoProducto() !="") {
				UPDATE("tipo_producto");
				SET("desc_tipo_producto = "+"'".concat(tipoProducto.getDescTipoProducto()).concat("'"));
				WHERE("tip_prod_id = " + String.valueOf(tipoProducto.getTipProdId()));
			}
			
		}}.toString();
	}
	
	public String delete(int tipProdId) {
		return new SQL() {{
			if(tipProdId > 0) {
				DELETE_FROM("tipo_producto");
				WHERE("tipo_producto_id = " + String.valueOf(tipProdId));
			}
			
		}}.toString();
	}
	
	public String selectTipoProducto(TipoProducto tipoProducto) {
		return new SQL() {{
			SELECT("t.tipo_producto_id, t.desc_tipo_producto");
			SELECT("c.cuenta_id, c.cuenta_desc, c.tipo_cuenta, c.cuenta_fecha, c.cuenta_hora, c.cuenta_usuario");
			SELECT("g.grupo_cuenta_id, g.tipo_grupo_cuenta, g.grupo_cuenta_desc");
			
			FROM("tipo_producto t");
			FROM("cuenta c");
			FROM("grupo_cuenta g");
			
			WHERE("t.cuenta_id = c.cuenta_id");
			WHERE("c.grupo_cuenta_id = g.grupo_cuenta_id");
			if(tipoProducto != null) {
				if(tipoProducto.getTipProdId()!= null && tipoProducto.getTipProdId() > 0) {
					WHERE("tipo_producto_id = " + String.valueOf(tipoProducto.getTipProdId()));
				}else if(tipoProducto.getDescTipoProducto()!=null && tipoProducto.getDescTipoProducto()!="") {
					WHERE("desc_tipo_producto = " + "'".concat(tipoProducto.getDescTipoProducto()).concat("'"));
				}
			}
		}}.toString();
	}
}
