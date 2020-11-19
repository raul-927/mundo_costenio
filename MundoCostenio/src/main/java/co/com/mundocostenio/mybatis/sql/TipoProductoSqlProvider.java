package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.TipoProducto;

public class TipoProductoSqlProvider {
	
	public String insert(TipoProducto tipoProducto) {
		return new SQL() {{
			if(tipoProducto.getDescTipoProducto()!= null && tipoProducto.getDescTipoProducto() !="") {
				INSERT_INTO("tipo_producto");
				VALUES("desc_tipo_producto","'".concat(tipoProducto.getDescTipoProducto()).concat("'"));
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
				WHERE("tip_prod_id = " + String.valueOf(tipProdId));
			}
			
		}}.toString();
	}
	
	public String selectTipoProducto(TipoProducto tipoProducto) {
		return new SQL() {{
			SELECT("tip_prod_id, desc_tipo_producto");
			FROM("tipo_producto");
			if(tipoProducto.getTipProdId() > 0) {
				WHERE("tip_prod_id = " + String.valueOf(tipoProducto.getTipProdId()));
			}else if(tipoProducto.getDescTipoProducto()!=null && tipoProducto.getDescTipoProducto()!="") {
				WHERE("desc_tipo_producto = " + "'".concat(tipoProducto.getDescTipoProducto()).concat("'"));
			}
		}}.toString();
	}
}
