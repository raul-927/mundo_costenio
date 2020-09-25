package co.com.mundocostenio.mybatis.sql;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;

import co.com.mundocostenio.domain.PrecioProducto;

public class PrecioProductoSqlProvider {
	
	public String insert(List<PrecioProducto> precioProductoList) {
		return new SQL() {{
			
			INSERT_INTO("precio_producto");
			INTO_COLUMNS("monto", "prod_id");
			for(PrecioProducto precProd: precioProductoList) {
				INTO_VALUES("'".concat(String.valueOf(precProd.getMonto())).concat("'"), "'".concat(String.valueOf(precProd.getProducto().getProdId())).concat("'"));
				ADD_ROW();
			}
			
		}}.toString();
		
	}
	
	public String insertListaAndPrecioProducto(int listaId, List<PrecioProducto> precioProductoList) {
		String resultado = new SQL() {{
			INSERT_INTO("list_prod_and_prec_prod");
			INTO_COLUMNS("lis_prec_id", "prec_prod_id");
			for(PrecioProducto precProd: precioProductoList) {
				INTO_VALUES(String.valueOf(listaId), String.valueOf(precProd.getPrecioProdId()));
				ADD_ROW();
			}
		}}.toString();
		
		return resultado;
	}
	
	public String selectPrecioProductoByListId(int id) {
		return new SQL() {{
			SELECT("pre.id, pre.monto, pro.id, pro.nombre, t.id, t.descripcion");
			FROM("lista_precios l");
			FROM("list_prod_and_prec_prod ls");
			FROM("precio_producto pre");
			FROM("producto pro");
			FROM("tipo_producto t");
			WHERE("l.id = ls.lis_prec_id");
			WHERE("ls.prec_prod_id = pre.id");
			WHERE("pre.prod_id = pro.id");
			WHERE("pro.tipo_prod_id = t.id");
			WHERE("l.id = " + id);
		}}.toString();
	}
}