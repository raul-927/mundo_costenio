package co.com.mundocostenio.mybatis.sql;

import org.apache.ibatis.jdbc.SQL;
import co.com.mundocostenio.domain.ListaPrecios;
import co.com.mundocostenio.domain.PrecioProducto;

public class ListaPreciosSqlProvider {

	public String insert(ListaPrecios insert) {
		
		return new SQL() {{
			INSERT_INTO("lista_precios");
			if(insert.getDescripcionLista()!= null) {
				VALUES("descripcion_lista", "'".concat(String.valueOf(insert.getDescripcionLista())).concat("'"));
			}
			if(insert.getFechaVigencia() != null) {
				VALUES("fecha_vig_id", String.valueOf(insert.getFechaVigencia().getFechaVigenciaId()));
			}
		}}.toString();
	}
	
	public String update(ListaPrecios update) {
		return new SQL() {{
			UPDATE("lista_precios");
			if(update.getDescripcionLista()!= null) {
				SET("descripcion_lista", "'".concat(String.valueOf(update.getDescripcionLista())).concat("'"));
			}
			if(update.getFechaVigencia() != null) {
				SET("fecha_vig_id", String.valueOf(update.getFechaVigencia().getFechaVigenciaId()));
			}
		}}.toString();
	}
	
	public String delete(int id) {
		return new SQL() {{}}.toString();
	}

	public String selectListaPrecios(ListaPrecios listaPrecios) {
		String sql =  new SQL() {{
			SELECT("l.lista_precio_id, l.descripcion_lista");
			SELECT("f.fecha_vigencia_id, f.fecha_ini,f.fecha_fin");
			SELECT("pre.precio_prod_id, pre.monto");
			SELECT("pro.prod_id, pro.nombre");
			SELECT("t.tip_prod_id, t.descripcion");
			
			FROM("lista_precios l");
			FROM("fecha_vig_list_prec f");
			FROM("precio_producto pre");
			FROM("producto pro");
			FROM("tipo_producto t");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.fecha_vig_id = f.fecha_vigencia_id"); 
			WHERE("l.lista_precio_id = ls.lis_prec_id"); 
			WHERE("ls.prec_prod_id = pre.precio_prod_id"); 
			WHERE("pre.prod_id = pro.prod_id"); 
			WHERE("pro.tipo_prod_id = t.tip_prod_id");
			
			if(listaPrecios != null) {
				if(listaPrecios.getListaPrecioId() > 0) {
					WHERE("l.lista_precio_id = "  + String.valueOf(listaPrecios.getListaPrecioId()));
				} else {
					if(listaPrecios.getDescripcionLista()!= null && listaPrecios.getDescripcionLista() != "") {
						WHERE("l.descripcion_lista LIKE '%"  + listaPrecios.getDescripcionLista() + "%'");
					}else
					if(listaPrecios.getFechaVigencia() != null) {
						if(listaPrecios.getFechaVigencia().getFechaVigenciaId() > 0) {
							WHERE("f.fecha_vigencia_id = " + String.valueOf(listaPrecios.getFechaVigencia().getFechaVigenciaId()));
						}else {
							if(listaPrecios.getFechaVigencia().getFechaIni() != null) {
								WHERE("f.fecha_ini = '" + String.valueOf(listaPrecios.getFechaVigencia().getFechaIni()) + "'");
							}
							if(listaPrecios.getFechaVigencia().getFechaFin() != null) {
								WHERE("f.fecha_fin = '" + String.valueOf(listaPrecios.getFechaVigencia().getFechaFin()) + "'");
							}
						}
					}
					if(listaPrecios.getPrecioProductoList() != null && listaPrecios.getPrecioProductoList().size() > 0) {
						for(PrecioProducto precProd: listaPrecios.getPrecioProductoList()) {
							if(precProd.getMonto() > 0) {
								WHERE("pre.monto = " + precProd.getMonto());
							}
							if(precProd.getProducto()!= null) {
								if(precProd.getProducto().getNombre()!= null && precProd.getProducto().getNombre()!="") {
									WHERE("pro.nombre = " + "'".concat(precProd.getProducto().getNombre()).concat("'"));
								}
								if(precProd.getProducto().getTipoProducto()!= null) {
									if(precProd.getProducto().getTipoProducto().getDescripcion()!=null && precProd.getProducto().getTipoProducto().getDescripcion()!= "") {
										WHERE("t.descripcion = " + "'".concat(precProd.getProducto().getTipoProducto().getDescripcion()).concat("'"));
									}
								}
							}
						}
					}
				}
			}
			
		}}.toString();
		System.out.println(sql);
		return sql;
	}
}
