package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.PrecioProducto;

public class PrecioProductoSqlProvider {
	
	public String insert(List<PrecioProducto> precioProductoList) {
		return new SQL() {{
			
			INSERT_INTO("precio_producto");
			INTO_COLUMNS("monto", "producto_id");
			for(PrecioProducto precProd: precioProductoList) {
				INTO_VALUES("'".concat(String.valueOf(precProd.getMonto())).concat("'"), "'".concat(String.valueOf(precProd.getProducto().getProdId())).concat("'"));
				ADD_ROW();
			}
			
		}}.toString();
		
	}
	
	public String insertListaAndPrecioProducto(int listaId, List<PrecioProducto> precioProductoList) {
		String resultado = new SQL() {{
			INSERT_INTO("list_prod_and_prec_prod");
			INTO_COLUMNS("lista_precio_id", "precio_producto_id");
			for(PrecioProducto precProd: precioProductoList) {
				INTO_VALUES(String.valueOf(listaId), String.valueOf(precProd.getPrecioProdId()));
				ADD_ROW();
			}
		}}.toString();
		
		return resultado;
	}
	
	public String selectPrecioProductoByListId(int id) {
		return new SQL() {{
			SELECT("pre.id, pre.monto");
			SELECT("pro.id, pro.nombre");
			SELECT("t.id, t.descripcion");
			
			FROM("precio_producto pre");
			FROM("producto pro");
			FROM("tipo_producto t");
			FROM("lista_precios l");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.lista_precio_id = ls.lista_precio_id");
			WHERE("ls.precio_producto_id = pre.precio_producto_id");
			WHERE("pre.producto_id = pro.producto_id");
			WHERE("pro.tipo_producto_id = t.tipo_producto_id");
			WHERE("l.lista_precio_id = " + String.valueOf(id));
		}}.toString();
	}
}