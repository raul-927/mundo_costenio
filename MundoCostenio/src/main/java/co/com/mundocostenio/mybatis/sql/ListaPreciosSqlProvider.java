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
			SELECT("t.tip_prod_id, t.desc_tipo_producto");
			
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
									if(precProd.getProducto().getTipoProducto().getDescTipoProducto()!=null && precProd.getProducto().getTipoProducto().getDescTipoProducto()!= "") {
										WHERE("t.desc_tipo_producto = " + "'".concat(precProd.getProducto().getTipoProducto().getDescTipoProducto()).concat("'"));
									}
								}
							}
						}
					}
				}
			}
		}}.toString();
		return sql;
	}
	
	public String selectActualListaPrecios() {
		String query = 
		 new SQL() {{
			SELECT("l.lista_precio_id, l.descripcion_lista");
			SELECT("f.fecha_vigencia_id, f.fecha_ini,f.fecha_fin");
			SELECT("pre.precio_prod_id, pre.monto");
			SELECT("pro.prod_id, pro.nombre");
			SELECT("t.tip_prod_id, t.desc_tipo_producto");
			
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
			WHERE("CURRENT_DATE() BETWEEN f.fecha_ini AND f.fecha_fin");
			OR();
			WHERE("CURRENT_DATE() > f.fecha_ini");
			WHERE("f.fecha_fin = '01/01/3030'");
		}}.toString();
		System.out.print(query);
		return query;
	}
	
	public String selectNuevoProducto() {
		String query = 
		 new SQL() {{
			SELECT("p.prod_id, p.nombre");
			SELECT("t.tip_prod_id, t.desc_tipo_producto");
			FROM("producto p");
			FROM("tipo_producto t");
			WHERE("p.tipo_prod_id = t.tip_prod_id");
			WHERE("p.prod_id NOT IN (" + verificarProductoExistenteEnListaActual() + ")");
		}}.toString();
		System.out.print(query);
		return query;
	}
	
	private String verificarProductoExistenteEnListaActual() {
		return new SQL() {{
			SELECT("pro.prod_id");
			
			FROM("producto pro");
			FROM("lista_precios l");
			FROM("fecha_vig_list_prec f");
			FROM("precio_producto pre");
			
			FROM("tipo_producto t");
			FROM("list_prod_and_prec_prod ls");
			
			WHERE("l.fecha_vig_id = f.fecha_vigencia_id"); 
			WHERE("l.lista_precio_id = ls.lis_prec_id"); 
			WHERE("ls.prec_prod_id = pre.precio_prod_id"); 
			WHERE("pre.prod_id = pro.prod_id"); 
			WHERE("pro.tipo_prod_id = t.tip_prod_id");
			WHERE("CURRENT_DATE() BETWEEN f.fecha_ini AND f.fecha_fin");
			OR();
			WHERE("CURRENT_DATE() > f.fecha_ini");
			WHERE("f.fecha_fin = '01/01/3030'");
		}}.toString();
	}
	
}